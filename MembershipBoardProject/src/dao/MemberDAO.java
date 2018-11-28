package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Board;
import vo.Member;
import static db.jdbcUtil.*;

public class MemberDAO {

	private static MemberDAO MemberDAO;	//싱글톤으로 만들어 주기 위해서 
	private Connection conn;	//sql 연결
	PreparedStatement pstmt;
	ResultSet rs;


	public static MemberDAO getInstance() {
		if (MemberDAO == null) {
			MemberDAO = new MemberDAO();
		}
		return MemberDAO;
	}

	public void setConnetion(Connection conn) {
		this.conn = conn;
	}

	public Member memberLogin(String id) {
		System.out.println("memberLogin DAO 실행");
		 String sql = "SELECT ID,PASSWORD FROM MEMBER1 WHERE ID=? ";
		 Member member = null;
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
			}
		 }catch(Exception e) {
			 System.out.println("memberLogin의 DAO에서 생긴 예외 : "+e);
		 }finally {
			 try {
				 close(rs);
				 close(pstmt);
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		 }
		System.out.println(member.toString());
		System.out.println("memberLogin DAO 리턴");
		return member;
	}

	public int memberJoin(Member member) {
		System.out.println("memberJoin DAO 실행");
		String sql = "INSERT INTO MEMBER1 VALUES(?,?,?,?,?,?)";
		int result=0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			 System.out.println("memberJoin의 DAO에서 생긴 예외 : "+e);
		}finally {
			 try {
				 close(pstmt);
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		 }

		System.out.println("memberJoin DAO 리턴");
		return result;
	}

	public ArrayList<Member> memberList() {
		System.out.println("memberList DAO 실행");
		String sql ="SELECT * FROM MEMBER1";
		ArrayList<Member> memberList = new ArrayList<>();
		Member member = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender"));
				member.setEmail(rs.getString("email"));
				memberList.add(member);
				
			}
		}catch(Exception e) {
			System.out.println("memberList DAO에서 일어난 예외 :"+e);
		}finally {
			try {
				close(rs);
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("memberList DAO 리턴");
		return memberList;
	}
}
