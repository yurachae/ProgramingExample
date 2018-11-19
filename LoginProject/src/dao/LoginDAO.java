package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static db.jdbcUtil.*;
import vo.Member;

//

public class LoginDAO {
	// 싱글톤 객체를 만드는 과정.
	private static LoginDAO loginDAO;
	private Connection conn;

	private LoginDAO() {
	} // 생성자

	// 메소드
	// loginDAO가 없으면 생성. 있으면 바로 리턴.
	public static LoginDAO getInstance() {
		if (loginDAO == null) {
			loginDAO = new LoginDAO();
		}
		return loginDAO;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public Member memberLogin(String id, String password) {
		PreparedStatement pstmt = null;// 쿼리문을 전달하는 인터페이스
		ResultSet rs = null; // DB에서 전송한 결과를 담아놓는 인터페이스(조회한 결과를 담아놈) rs를 활용함.
		Member loginMember = null; // Member 클래스 타입 변수.
		String sql = "SELECT * FROM MEMBER1 WHERE id=?  and password=?"; // 쿼리문, 변경이 있을 수 있기 때문에 변수로
	
		try {
			// conn DB와 연결되어 있는 객체. 쿼리문을 날릴 준비함.(쿼리문을 전달하는 인턴페이스 타입의 변수에 저장)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); // index는 ?의 위치를 숫자로. x는 넣을 값.
			pstmt.setString(2, password);

			// 쿼리를 실행. 결과 값을 rs에 저장.
			rs = pstmt.executeQuery();

			// 결과 활용하기.
			if (rs.next()) {// iterator의 hasnext()와 비슷한 것. DB의 결과가 있으면 계속 실행.
				loginMember = new Member(); // Member 클래스의 객체를 선언 후 DB에서 조회된 내용을 필드 값으로 저장.

				// "id"는 DB 컬럼 이름으로 조회한 값을 loginMember 필드에 저장.
				loginMember.setId(rs.getString("id"));
				loginMember.setPassword(rs.getString("password"));
				loginMember.setName(rs.getString("name"));
				loginMember.setAge(rs.getInt("age"));
				loginMember.setAddress(rs.getString("address"));
				loginMember.setEmail(rs.getString("email"));
				loginMember.setGender(rs.getString("gender"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(pstmt);
				close(rs);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return loginMember;
	}

}
