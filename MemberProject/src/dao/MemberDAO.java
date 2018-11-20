package dao;

import static db.jdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Member;

public class MemberDAO {

	private static MemberDAO MemberDAO;
	private Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	private MemberDAO() {
	} // 생성자

	// 메소드
	// loginDAO가 없으면 생성. 있으면 바로 리턴. (싱글톤)
	public static MemberDAO getInstance() {
		if (MemberDAO == null) {
			MemberDAO = new MemberDAO();
		}
		return MemberDAO;
	}

	// DB와 Conncetion
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	// int 타입의 Member타입의 변수를 받아서 쿼리문을 날린 후 결과값을 보냄.
	public int memberJoin(Member member) {
		int result = 0;
		String sql = "INSERT INTO MEMBER1 VALUES (?,?,?,?,?,?)";
		try {
			// conn DB와 연결되어 있는 객체.
			// 쿼리문을 날릴 준비함.(쿼리문을 전달하는 인턴페이스 타입의 변수에 저장)
			pstmt = conn.prepareStatement(sql);

			// 물음표 채우기
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());

			// executeQuery()는 SELECT 할 때만 실행.
			// executeUpdate()는 INSERT, DELETE, UPDATE
			// 성공하게 되면 1이상의 값이 출력됨.
			// 0이 아닌 값이라면 INSERT가 성공함을 의미.
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("memberJoin 오류!!" + e);
		} finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	//MeberLoginService에서 호출하는 메소드.
	public Member memberLogin(String id, String password) {
	
		//DB에 저장되어 있는지 확인해서 loginMember에 저장. 없으면 null
		Member loginMember = null;
		String sql = "SELECT * FROM MEMBER1 WHERE ID=? AND PASSWORD=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				loginMember = new Member();
				loginMember.setId(rs.getString("id"));
				loginMember.setPassword(rs.getString("password"));
				loginMember.setName(rs.getString("name"));
				loginMember.setAge(rs.getInt("age"));
				loginMember.setGender(rs.getString("gender"));
				loginMember.setEmail(rs.getString("email"));

			}
		} catch (Exception e) {
			System.out.println("DB 오류");
			e.printStackTrace();
		} finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return loginMember;
	}
}
