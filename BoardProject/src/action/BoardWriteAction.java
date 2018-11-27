package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import service.BoardWriteService;
import vo.ActionForward;
import vo.Board;

//Action 인터페이스의 구현 클래스
public class BoardWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		String BOARD_NAME = request.getParameter("BOARD_NAME");
		String BOARD_PASS = request.getParameter("BOARD_PASS");
		String BOARD_SUBJECT = request.getParameter("BOARD_SUBJECT");
		String BOARD_CONTENT = request.getParameter("BOARD_CONTENT");

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date BOARD_DATE = new java.sql.Date(utilDate.getTime());

		Board board = new Board();
		board.setBOARD_NAME(BOARD_NAME);
		board.setBOARD_PASS(BOARD_PASS);
		board.setBOARD_SUBJECT(BOARD_SUBJECT);
		board.setBOARD_CONTENT(BOARD_CONTENT);
		board.setBOARD_DATE(BOARD_DATE);
		BoardWriteService boardWriteService = new BoardWriteService();
		boolean boardResult = boardWriteService.boardWrite(board);

		if (boardResult) {// true이면 commit함.
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo");
			//바로 jsp로 넘어가는 것이 아니라 변경된 List가 뜨도록 하기 위해서 컨트롤러로 보냄.
			
		} else {// false면 rollback
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('글등록 실패') location.href='/boardWrite.jsp' </script>");
		}

		return forward;
	}
}
