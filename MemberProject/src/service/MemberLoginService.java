package service;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Member;
import static db.jdbcUtil.*;

public class MemberLoginService {
	
	//메소드를 호출할 때 사용자가 입력한 id, password를 매개변수로 받음.
	public boolean memberLogin(Member member) {
		//싱글톤 객체 생성
		MemberDAO loginDAO = MemberDAO.getInstance();		
		//Connection 연결
		Connection conn = getConnection();		
		//연결한 connection 변수 conn을(연결정보) LoginDAO의 메소드인 setConnection을 호출할 때 넘겨줌.
		loginDAO.setConnection(conn);
		
		//Member 클래스의 변수에 
		//Member로 리턴되는 LoginDAO 메소드인  memberLogin을 호출(입력 받은 id와 password를 매개변수로 전달)		
		System.out.println("service 패키지의 member 객체의 "+member.getId());
		boolean result= loginDAO.memberLogin(member);
	
		
		//리턴 값이 boolean 타입이므로 DAO에서 가져온 리턴 값이 있는지 없는지 확인해서 true, false를 처리해서 전달함.
		if(result) {
			result = true;
			return result;
		}else {
			result = false;
			return result;
		}
	}
	
}
