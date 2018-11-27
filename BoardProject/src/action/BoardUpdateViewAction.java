package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardUpdateViewService;
import vo.ActionForward;
import vo.Board;

public class BoardUpdateViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		BoardUpdateViewService boardUpdateService = new BoardUpdateViewService();

		Board board = boardUpdateService.boardUpdateView(boardNum);
		
		
		if (board != null) {
			request.setAttribute("boardUpdateView", board);
			forward.setRedirect(false);
			forward.setPath("boardUpdateForm.jsp");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('해당하는 게시판이 존재하지 않습니다.') location.href='/board/index.jsp' </script>");
	
		}

		return forward;

	}

}
