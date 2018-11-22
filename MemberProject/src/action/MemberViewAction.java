package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberListService;
import service.MemberViewService;
import vo.ActionForward;
import vo.Member;

public class MemberViewAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		// getParameter : 주소창으로 값을 이동했을 때는 .
		// getAttribute : 다른 페이지에서 setAttribute를 했으면 .
		String id = request.getParameter("id");
		System.out.println("MemberViewAction로 넘어온 request 값 : " + id);

		forward = new ActionForward();
		MemberViewService memberViewService = new MemberViewService();
		Member member = memberViewService.memberView(id);

		// service로 부터 전달받은 리턴 값을 request에 저장.
		// 가져온 데이터가 있으면 request에 저장해서 dispatcher 방식으로 forwarding하기
		if (member != null) {
			request.setAttribute("memberView", member);
			System.out.println("request에 저장된 가져온 view :" + request.getAttribute("memberView"));
			forward.setPath("./memberView.jsp");
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('해당 하는 아이디가 없습니다.') history.back() </script>");
		}

		return forward;
	}

}
