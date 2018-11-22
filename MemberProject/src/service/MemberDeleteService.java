package service;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Member;
import static db.jdbcUtil.*;

public class MemberDeleteService {

	public boolean memberDelete(String id) {
		MemberDAO memberDAO = MemberDAO.getInstance();
		Connection conn = getConnection();
		memberDAO.setConnection(conn);
		
		boolean result = memberDAO.memberDelete(id);
		boolean deleteResult = false;
		
		if(result) {
			commit(conn);
			deleteResult = true;
		}else {
			rollback(conn);
			deleteResult = false;
		}
		
		return deleteResult;
	}

}
