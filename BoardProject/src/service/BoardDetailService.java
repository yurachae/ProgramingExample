package service;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;

import dao.BoardDAO;
import vo.Board;


public class BoardDetailService {

	public Board boardDetail(int boardNum) {
		BoardDAO boardDAO = new BoardDAO();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);
				
		//보드 디테일 메소드 호출
		Board boardDetail = boardDAO.boardDetail(boardNum);
		
		return boardDetail;
		
	}

}
