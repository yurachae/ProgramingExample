package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Board;
import static db.jdbcUtil.*;

public class BoardDAO {

	private static BoardDAO BoardDAO;
	private Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 메소드
	// loginDAO가 없으면 생성. 있으면 바로 리턴. (싱글톤)
	public static BoardDAO getInstance() {
		if (BoardDAO == null) {
			BoardDAO = new BoardDAO();
		}
		return BoardDAO;
	}

	// DB와 Conncetion
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<Board> boardList() {
		System.out.println("boardList DAO 실행");
		String sql = "SELECT * FROM BOARD ORDER BY BOARD_NUM DESC";
		ArrayList<Board> boardList = new ArrayList<>();
		Board board = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				board = new Board();
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_NAME(rs.getString("BOARD_NAME"));
				board.setBOARD_PASS(rs.getString("BOARD_PASS"));
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				board.setBOARD_FILE(rs.getString("BOARD_FILE"));
				board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(rs.getDate("BOARD_DATE"));

				boardList.add(board);

			}
		} catch (Exception e) {
			System.out.println("BoardList DAO에서 일어난 예외 :" + boardList);
		} finally {
			try {
				close(pstmt);
				close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return boardList;
	}

	public boolean boardWrite(Board board) {
		String sql = "INSERT INTO BOARD VALUES(SEQ.NEXTVAL,?,?,?,?,?,SEQ.NEXTVAL,?,?,?,SYSDATE)";
		boolean writeResult = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBOARD_NAME());
			pstmt.setString(2, board.getBOARD_PASS());
			pstmt.setString(3, board.getBOARD_SUBJECT());
			pstmt.setString(4, board.getBOARD_CONTENT());
			pstmt.setString(5, board.getBOARD_FILE());
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 0);

			int num = pstmt.executeUpdate();
			if (num > 0) {
				writeResult = true;
			} else {
				writeResult = false;
			}

		} catch (Exception e) {
			System.out.println("boardWrite DAO에서 일어난 예외 :" + e);
		} finally {
			try {
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return writeResult;
	}

	public Board boardDetail(int boardNum) {

		System.out.println("boardDetail DAO 실행");
		String sql = "SELECT * FROM BOARD WHERE BOARD_NUM=?";
		Board board = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				board = new Board();
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_NAME(rs.getString("BOARD_NAME"));
				board.setBOARD_PASS(rs.getString("BOARD_PASS"));
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				board.setBOARD_FILE(rs.getString("BOARD_FILE"));
				board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
			}
		} catch (Exception e) {
			System.out.println("boardDetail DAO에서 일어난 예외 :" + e);
		} finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("boardDetail DAO 리턴");
		return board;
	}

}
