package service;
//DAO 객체 만들고

//DB 연결하는 connection
//DB에 저장됨을 = 회원가입 성공 여부를 리턴.

import java.sql.Connection;

import static db.jdbcUtil.*;
import dao.MemberDAO;
import vo.Member;

public class MemberJoinService {

	// 메소드
	public boolean memberJoin(Member member) {
		MemberDAO memberDAO = MemberDAO.getInstance(); // 싱글톤
		Connection conn = getConnection(); // DB연결
		memberDAO.setConnection(conn); // DAO에 conncetion을 넘김.

		// 결과를 넘겨줄 변수
		boolean joinResult = false;
		// 결과 값이 1이 넘어오면 INSERT 성공.
		int result = memberDAO.memberJoin(member); // DAO의 회원가입 메소드를 member 변수를 매개변수로 호출.

		if (result > 0) {
			joinResult = true;
			commit(conn);
		} else {
			joinResult = false;
			rollback(conn);
		}
		close(conn);
		return joinResult;
	}
}
