package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardListService;
import vo.ActionForward;
import vo.Board;

public class BoardListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		BoardListService boardListService = new BoardListService();
		ArrayList<Board> boards = boardListService.boardList();
		
		//DB에 저장된 파일들이 있으면
		if(boards != null) {
			request.setAttribute("boardList", boards);
			forward=new ActionForward();
			forward.setPath("/board/boardList.jsp");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('글이 없습니다.') location.href='/board/index.jsp' </script>");
		}
		return forward;
		
	}
}
