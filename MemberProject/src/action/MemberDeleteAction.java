package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberDeleteService;
import vo.ActionForward;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");

		ActionForward forward = new ActionForward();
		MemberDeleteService memberDeleteService = new MemberDeleteService();

		// 해당된 아이디를 삭제한 나머지를 다시 가져와서 출력하려고 Member 클래스의 객체로 받음.
		boolean deleteResult = memberDeleteService.memberDelete(id);

		if (deleteResult) {// true면 삭제 성공
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('삭제 되었습니다.') </script>");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./memberListAction.me");			
		}else {//삭제 실패
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('삭제실패') location.href='./memberListAction.me' </script>");
		}
		return forward;

	}

}
