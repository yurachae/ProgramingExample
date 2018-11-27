package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardDetailService;
import vo.ActionForward;
import vo.Board;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		BoardDetailService boardDetailService = new BoardDetailService();
		Board boardDetail = boardDetailService.boardDetail(boardNum);
		
		HttpSession session = request.getSession();
		session.setAttribute("boardDetail", boardDetail);
		forward.setPath("/boardDetailForm.bo");//디스패처 방식으로 포워딩
		return forward;
	}

}
