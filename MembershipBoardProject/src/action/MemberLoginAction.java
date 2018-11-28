package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberLoginService;
import vo.ActionForward;
import vo.Member;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberLoginAction 실행");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		ActionForward forward = new ActionForward();
		MemberLoginService memberLoginService = new MemberLoginService();
		Member member = memberLoginService.memberlogin(id,password);	//로그인 성공시 true, 비밀번호나 아이디가 다른 경우 false
		
		if(member!=null) {//로그인 성공하면 게시판으로 보내짐
			HttpSession session = request.getSession();
			session.setAttribute("memberId",id);
			session.setAttribute("memberPassword", password);
			forward.setPath("boardListAction.bo");	//BoardController로 보내짐.
			
		}else { //false 면 로그인 실패한 것. 로그인 화면으로 다시 돌아갈 것.
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('로그인 실패')");
			out.println("location.href='./memberLoginForm.me' </script>"); // 로그인 페이지로 이동.
		}
		System.out.println("MemberLoginAction 리턴");
		return forward;
	}

}
