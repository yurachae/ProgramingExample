package service;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;

import dao.LoginDAO;
import vo.Member;

public class LoginService {

	public Member memberLogin(String id, String password) {
		//LoginDAO 클래스에 대한 싱글톤 객체 생성.
		LoginDAO loginDAO = LoginDAO.getInstance();

		//Conncetion 객체 만듬. DB 연결하는 부분(접속하는 과정)***
		Connection conn = getConnection();	//getConncetion() 메소드는 jdbcUtil 메소드			
		loginDAO.setConnection(conn);
		
		//LoginDAO 클래스의 로그인 메소드 호출해 리턴값을 리턴.		
		Member loginMember = loginDAO.memberLogin(id,password);
		
		//접속해제.jdbcUtil 메소드.
		return loginMember;
	}

}
