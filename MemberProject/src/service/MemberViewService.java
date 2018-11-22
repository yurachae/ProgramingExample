package service;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Member;

public class MemberViewService {

	public Member memberView(String id) {
		MemberDAO memberDAO = MemberDAO.getInstance(); //싱글톤 객체 
		Connection conn = getConnection();	//jdbcUtil 클래스의 db 연결 객체 생성
		memberDAO.setConnection(conn);
		System.out.println("service로 넘어온 id 값 :"+id);
		
		Member member = memberDAO.memberView(id); //리턴 타입이 Member 클래스인 메소드 호출.
		System.out.println("DAO에서 service로 넘어온 값 :"+member.toString());
		return member;
	}

}
