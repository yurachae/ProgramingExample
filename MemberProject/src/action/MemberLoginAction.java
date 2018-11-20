package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberLoginService;
import vo.ActionForward;
import vo.Member;

public class MemberLoginAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.id, password를 받아옴
		String id = request.getParameter("id");
		String password= request.getParameter("password");
		
		//2. 받아온 값을 memberLoginService 클래스(Member클래스 타입으로 리턴되는)로 넘김
		
		MemberLoginService memberLoginService = new MemberLoginService();
		Member member = new Member();
		member = memberLoginService.memberLogin(id, password);

		ActionForward  forward = null;
		//3. 리턴 값으로 로그인 성공 실패 여부 판단.
		
		//성공 ,id 세션에 저장, memberListAction.me로 redirect
		if(member != null) {//성공
			HttpSession session = request.getSession();//session 객체 생성
			session.setAttribute("id", id);	//session 영역에 id 저장.
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./memberListAction.me");
		}
		//실패, 로그인 실패 alert띄우고 로그인 페이지로 다시 이동.
		else {
			response.setContentType("text/html;context=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('로그인 실패') history.back()</script>");
		}
		return forward;
	}

}

