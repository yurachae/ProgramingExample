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

	public boolean boardWrite(Board board) {
		// 쿼리문 총 10개 입력
		// 쿼리문에 SYSDATE를 하면 현재 날짜가 등록됨.(SEQ.NEXTVAL,?,?,?,?,?,?,?,?,SYSDATE)
		String sql = "INSERT INTO BOARD VALUES (SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?)"; // 글쓰기 위한 쿼리문

		// 테이블에서 최대값을 찾아서 글번호를 주자라는 것을 의미함. (SEQ.NEXTVAL 아닐 경우)
		String sql1 = "SELECT MAX(BOARD_NUM) FROM BOARD"; // 글번호 처리 쿼리문
		int num = 0; // 글번호

		int result = 0;
		boolean boardResult = false;
		try {
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();

			// 글번호 처리하는 부분.
			if (rs.next()) {
				num = rs.getInt(1) + 1; // 결과에서 첫 번째 결과를 의미함.
			} else {
				num = 1; // 아무런 글이 없으면 (조회가 안되는 것)
			}

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBOARD_NAME());
			pstmt.setString(2, board.getBOARD_PASS());
			pstmt.setString(3, board.getBOARD_SUBJECT());
			pstmt.setString(4, board.getBOARD_CONTENT());
			pstmt.setString(5, board.getBOARD_FILE());
			pstmt.setInt(6, num); // 답글의 원본 글의 번호를 저장하는 것.
			pstmt.setInt(7, board.getBOARD_RE_LEV()); // 답글 - 들여쓰기 할 때 사용.
			pstmt.setInt(8, board.getBOARD_RE_SEQ()); // 답글 - 출력 순서할 때 사용.
			pstmt.setInt(9, board.getBOARD_READCOUNT());
			pstmt.setDate(10, board.getBOARD_DATE());

			result = pstmt.executeUpdate();

			// DB에 저장됐는지 안됐는지 확인하는 if문
			if (result > 0) {
				boardResult = true;
			} else {
				boardResult = false;
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
		return boardResult;
	}

	public ArrayList<Board> boardList() {
		ArrayList<Board> boardlist = new ArrayList<>();
		Board board = null;
		String sql = "SELECT * FROM BOARD ORDER BY BOARD_NUM DESC";
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

				boardlist.add(board);
			}

		} catch (Exception e) {
			System.out.println("boardList DAO에서 생긴 예외 :" + e);
		}
		return boardlist;
	}

	public Board boardDetail(int boardNum) {
		String sql = "SELECT BOARD_READCOUNT FROM BOARD WHERE BOARD_NUM=?";
		Board boardDetail = new Board();
		int board_count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board_count = rs.getInt("BOARD_READCOUNT");
			}
		} catch (Exception e) {
			System.out.println("boardDetail- readCount 구하다 예외 발생 :" + e);
		}

		sql = "UPDATE BOARD SET BOARD_READCOUNT=? WHERE BOARD_NUM=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ++board_count);
			pstmt.setInt(2, boardNum);

			int result = pstmt.executeUpdate();
			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (Exception e) {
			System.out.println("boardDetail - readCount 테이블에 저장하다 예외 발생 :" + e);
		}

		sql = "SELECT * FROM BOARD WHERE BOARD_NUM=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				boardDetail.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				boardDetail.setBOARD_NAME(rs.getString("BOARD_NAME"));
				boardDetail.setBOARD_PASS(rs.getString("BOARD_PASS"));
				boardDetail.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				boardDetail.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				boardDetail.setBOARD_FILE(rs.getString("BOARD_FILE"));
				boardDetail.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				boardDetail.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				boardDetail.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				boardDetail.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				boardDetail.setBOARD_DATE(rs.getDate("BOARD_DATE"));
			}

		} catch (Exception e) {

			System.out.println("boardDetail- 선택된 member 정보 가져오다 예외 발생 :" + e);
		}
		return boardDetail;
	}

	public Board boardUpdateView(int boardNum) {
		String sql = "SELECT * FROM BOARD WHERE BOARD_NUM=?";
		Board board = new Board();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
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
		}catch(Exception e) {
			System.out.println("boardUpdateView DAO에서 일어난 예외 :"+e);
		}finally {
			try {
				close(rs);
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return board;
	}

	public int boardUpdate(Board board) {
		String sql = "UPDATE BOARD SET BOARD_CONTENT =?, BOARD_FILE=? WHERE BOARD_NUM=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBOARD_CONTENT());
			pstmt.setString(2, board.getBOARD_FILE());
			pstmt.setInt(3, board.getBOARD_NUM());
			
			result = pstmt.executeUpdate();
		
					
		}catch(Exception e) {
			System.out.println("boardUpdateView DAO에서 일어난 예외 :"+e);
		}
		return result;
	}

	public int boardDelete(int boardNum) {
		String sql = "DELETE FROM BOARD WHERE BOARD_NUM=?";
		int result =0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("boardDelete DAO에서 일어난 예외 :"+e);
		}
		return result;
		
	}

	public String boardCheck(int boardNum) {
		String sql = "SELECT BOARD_PASS FROM BOARD WHERE BOARD_NUM=?";
		String password =null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				password = rs.getString("BOARD_PASS");
			}
		}catch(Exception e) {
			System.out.println("boardCheck DAO에서 일어난 예외 :"+e);
		}

		System.out.println("boardCheck DAO 반환값 : "+password);
		return password;
	}

}
