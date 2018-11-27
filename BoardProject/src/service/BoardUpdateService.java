package service;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;

import dao.BoardDAO;
import vo.Board;
import static db.jdbcUtil.*;

public class BoardUpdateService {

	public boolean boardUpdate(Board board) {
		BoardDAO boardDAO = BoardDAO.getInstance();	// 싱글톤 객체 생성
		Connection conn = getConnection();	//sql 연결
		boardDAO.setConnection(conn);
		
		int result = boardDAO.boardUpdate(board);
		
		boolean updateResult = false;
		if(result>0) {
			commit(conn);
			updateResult = true;
		}else {
			rollback(conn);
			updateResult = false;
		}
		return updateResult;
	}

}
