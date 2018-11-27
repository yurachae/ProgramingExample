package service;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;

import dao.BoardDAO;

public class BoardCheckService {

	public boolean boardCheck(int boardNum, String boardPass) {
		BoardDAO boardDAO = BoardDAO.getInstance();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);

		String checkpass = boardDAO.boardCheck(boardNum);
		boolean result = false;
		if (checkpass.equals(boardPass)) {// 입력한 password와 가져온 password가 같다면
			result = true;
		} else {
			result = false;
		}
		

		System.out.println("BoardCheckService 반환값 : "+result);
		return result;

	}

}
