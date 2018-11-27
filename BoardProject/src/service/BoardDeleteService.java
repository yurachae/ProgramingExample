package service;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;

import dao.BoardDAO;
import static db.jdbcUtil.*;

public class BoardDeleteService {

	public boolean boardDelete(int boardNum) {

		System.out.println("BoardDeleteService");
		BoardDAO boardDAO = new BoardDAO();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);
		
		int result = boardDAO.boardDelete(boardNum);
		boolean deleteResult = false;
		
		if(result>0) {
			commit(conn);
			deleteResult = true;
			
		}else {
			rollback(conn);
			deleteResult=false;
		}
		return deleteResult;
	}

}
