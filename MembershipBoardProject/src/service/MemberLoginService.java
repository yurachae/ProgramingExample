package service;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Member;

public class MemberLoginService {

	public Member memberlogin(String id, String password) {
		System.out.println("MemberLoginService 실행");
		MemberDAO memberDAO = MemberDAO.getInstance(); // 싱글톤
		Connection conn = getConnection(); // sql 연결
		memberDAO.setConnetion(conn); // 연결을 DAO에 넘김

		Member member = memberDAO.memberLogin(id);
		System.out.println(member.toString());

		System.out.println("MemberLoginService 리턴");
		return member;

	}

}
