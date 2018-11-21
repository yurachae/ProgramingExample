package action;

import java.io.PrintWriter;
import java.util.ArrayList;

//세션에 있는 아이디를 확인. 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberListService;
import vo.ActionForward;
import vo.Member;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그인 시 세션에 저장되어 있는 아이디가 admin인 경우에만 리스트를 출력할 수 있음.
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println("session에 저장되어 있는 id :" + id);
		
		ActionForward forward = null;

		if (id == null) {// 세션에 저장된 id가 없다면 로그인 창으로 이동
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> location.href='./memberLogin.me' </script>");
		} 
		
		else if (id.equals("admin")) {
			forward = new ActionForward();
			MemberListService memberListService = new MemberListService();
			ArrayList<Member> member = memberListService.memberList();
			
			//service로 부터 전달받은 리턴 값을 request에 저장.
			session.setAttribute("memberList", member);
			System.out.println("request에 저장된 list +"+session.getAttribute("memberList"));
			forward.setRedirect(true);
			forward.setPath("./memberList.jsp");					
		}
		
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('관리자가 아닙니다')");
			out.println("location.href='./memberLogin.me' </script>"); // 로그인 페이지로 이동.
		}
		
		return forward;
	}
}
