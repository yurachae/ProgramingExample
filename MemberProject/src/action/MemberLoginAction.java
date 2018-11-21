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
		Member member = new Member();

		// 1.id, password를 받아옴
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println("loginForm.jsp에서 입력한 id : " + id);

		// Member클래스의 객체로 id, password를 다룸
		member.setId(id);
		member.setPassword(password);
		System.out.println("member 객체의 id 필드 값 : " + member.getId());

		/*
		 * //2. 받아온 값을 memberLoginService 클래스(Member클래스 타입으로 리턴되는)로 넘김
		 * MemberLoginService memberLoginService = new MemberLoginService(); //로그인 서비스의
		 * 매소드를 호출한 결과를 Member 클래스 변수에 저장. member = memberLoginService.memberLogin(id,
		 * password);
		 */

		// 2. 받아온 값을 memberLoginService 클래스(boolean 타입으로 리턴되는)로 넘김
		MemberLoginService memberLoginService = new MemberLoginService();
		boolean result = memberLoginService.memberLogin(member);

		ActionForward forward = null;
		// 3. 리턴 값으로 로그인 성공 실패 여부 판단.

		// 성공 ,id 세션에 저장, memberListAction.me로 redirect
		if (result) {// 성공
			HttpSession session = request.getSession();// session 객체 생성
			session.setAttribute("id", id); // session 영역에 id 저장.
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./memberListAction.me");
		}
		// 실패, 로그인 실패 alert띄우고 로그인 페이지로 다시 이동.
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('로그인 실패')");
			out.println("location.href='./memberLogin.me' </script>"); // 로그인 페이지로 이동.

		}

		return forward;
	}
}
