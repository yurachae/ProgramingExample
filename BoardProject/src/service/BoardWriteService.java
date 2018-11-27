package service;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;

import dao.BoardDAO;
import vo.Board;
import static db.jdbcUtil.*;


public class BoardWriteService {

	public boolean boardWrite(Board board) {
		BoardDAO boardDAO = new BoardDAO();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);
		
		boolean boardResult = boardDAO.boardWrite(board);
		boolean result = false;
		
		if(boardResult) {//true이면 성공
			System.out.println("db 입력 성공(service-commit)");
			commit(conn); 
			result =true;
		}else {
			System.out.println("db 입력 실패 (service-rollback)");
			rollback(conn);
			result = false;
		}
		
		return result;
	}

}
