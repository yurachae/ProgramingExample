package service;

import dao.MemberDAO;
import vo.Member;
import static db.jdbcUtil.*;

import java.sql.Connection;

public class MemberIdCheckService {

	public boolean memberIdCheck(String id) {
		MemberDAO memberDAO = MemberDAO.getInstance();
		Connection conn = getConnection();
		memberDAO.setConnection(conn);

		System.out.println("Service의 memberIDCheck메소드로 넘어온 체크할 id: " + id);
		boolean resultId = false;

		boolean result = memberDAO.memberIdCheck(id);
		
		if (result) {
			// 중복된 아이디가 있음.
			resultId = true;
		} else {// 중복된 아이디가 없음.
			resultId = false;
		}
		return resultId;
	}

}
