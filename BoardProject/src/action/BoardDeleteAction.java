package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardDeleteService;
import vo.ActionForward;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		BoardDeleteService boardDeleteService= new BoardDeleteService();
		
		boolean result = boardDeleteService.boardDelete(boardNum);
		
		if(result) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo");
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('삭제 실패')");
			out.println("location.href='boardList.bo' </script>");
		}
		
		return forward;
		
	}

}
