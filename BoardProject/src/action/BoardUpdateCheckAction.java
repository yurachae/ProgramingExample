package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardCheckService;
import vo.ActionForward;

public class BoardUpdateCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int boardNum = Integer.parseInt(request.getParameter("BOARD_NUM"));
		String boardPass = request.getParameter("BOARD_PASS");
		BoardCheckService boardCheckService = new BoardCheckService();
		System.out.println("BoardUpdateCheckAction실행 :" + boardNum + " " + boardPass);

		// 비밀번호가 맞는지 확인해서 넘어오는 것.
		boolean result = boardCheckService.boardCheck(boardNum, boardPass);

		System.out.println("BoardUpdateCheckAction의 메소드 반환 값 :" + result);

		if (result) {// 비밀번호가 맞다면
			forward = new ActionForward();
			request.setAttribute("boardNum", boardNum);	
			forward.setPath("/board/check.jsp");
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('비밀번호 틀림')");
			out.println("location.href='boardList.bo' </script>");
		}

		return forward;
	}

}
