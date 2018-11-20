package service;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Member;
import static db.jdbcUtil.*;

public class MemberLoginService {
	
	//메소드를 호출할 때 사용자가 입력한 id, password를 매개변수로 받음.
	public Member memberLogin(String id, String password) {
		//싱글톤 객체 생성
		MemberDAO loginDAO = MemberDAO.getInstance();
		
		//Connection 연결
		Connection conn = getConnection();
		
		//연결한 connection 변수 conn을 LoginDAO의 메소드인 setConnection을 호출할 때 넘겨줌.
		loginDAO.setConnection(conn);
		
		//Member 클래스의 변수에 
		//Member로 리턴되는 LoginDAO 메소드인  memberLogin을 호출(입력 받은 id와 password를 매개변수로 전달)
		Member loginMember = loginDAO.memberLogin(id,password);
	
		return loginMember;
	}
	
}
