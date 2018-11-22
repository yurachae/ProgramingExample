package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.Member;
import static db.jdbcUtil.*;

public class MemberListService {

	public ArrayList<Member> memberList() {
		MemberDAO memberDAO = MemberDAO.getInstance();
		Connection conn = getConnection();
		memberDAO.setConnection(conn);
		
		ArrayList<Member> member = memberDAO.memberList();
		
		return member;
	}
	

}
