package service;

import java.sql.Connection;

import dao.BoardDAO;
import vo.Board;

import static db.jdbcUtil.*;

public class BoardUpdateViewService {

	public Board boardUpdateView(int boardNum) {
		BoardDAO boardDAO = BoardDAO.getInstance();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);
		
		Board board = boardDAO.boardUpdateView(boardNum);
		
		return board;
	}

}
