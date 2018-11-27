package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.Board;
import static db.jdbcUtil.*;

public class BoardListService {

	public ArrayList<Board> boardList() {
		BoardDAO boardDAO = BoardDAO.getInstance();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);
		
		ArrayList<Board> boardlist = boardDAO.boardList();
		
		close(conn);
		return boardlist;
	}

}
