package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardUpdateService;
import vo.ActionForward;
import vo.Board;

public class BoardUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		Board board = new Board();
		
		board.setBOARD_NUM(Integer.parseInt(request.getParameter("BOARD_NUM")));
		board.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
		board.setBOARD_FILE(request.getParameter("BOARD_FILE"));
		
		BoardUpdateService boardUpdateService = new BoardUpdateService();
		boolean result = boardUpdateService.boardUpdate(board);
		
		if(result) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo");
		}
		return forward;
	}

}
