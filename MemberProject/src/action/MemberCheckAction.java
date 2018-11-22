package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberIdCheckService;
import vo.ActionForward;

public class MemberCheckAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		String checkId = request.getParameter("id");
		System.out.println("MemberCheckAction으로 넘겨진 체크할 id :"+checkId);
		
		MemberIdCheckService memberIdCheckService = new MemberIdCheckService();
		boolean resultId = memberIdCheckService.memberIdCheck(checkId);
		
		//해당하는 id가 DB에 있는지 없는지 확인해서 있으면 true.
		if(resultId) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('아이디 중복') location.href='./memberJoin.form' </script>");
	
		}
		//해당하는 id가 DB에 없으면 false
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('사용가능한 아이디') location.href='./memberJoin.form' </script>");
			
		/*	request.setAttribute("resultId", resultId);
			forward.setRedirect(true);//dispatcher 방식
			forward.setPath("./checkForm.jsp");
		*/}
		return forward;
	}	
}
