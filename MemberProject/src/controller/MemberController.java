package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.MemberJoinAction;
import action.MemberLoginAction;
import vo.ActionForward;

//.me로 끝나는 모든 파일을 받음.
@WebServlet("*.me")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberController() {
		super();
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글에 대한 원활한 처리를 위한 설정.
		request.setCharacterEncoding("UTF-8");

		// 주소 값 추출 과정
		// 회원가입을 요청하면 : http://localhost:9090/MemberProject/memberJoinAction.me
		// 여기서 memberJoinAction.me만 추출하기 위한 코드가 아래 코드

		String RequestURI = request.getRequestURI();
		// RequestURI = MemberProject/memberJoinAction.me
		// getRequestURI()는 프로젝트 이하의 (이후) 모든 값을 가져옴.

		String ContextPath = request.getContextPath();
		// ContextPath = /MemberProject
		// getContextPath()는 프로젝트 이름

		String command = RequestURI.substring(ContextPath.length()); // substring()메소드는 잘라낸 문자의 길이 값.
		// command =/memberJoinAction.me

		// 일관성 있게 규정해서 하려고.
		ActionForward forward = null;
		Action action = null; // Action은 인터페이스.

		// command =/memberJoinAction.me : 회원 가입에 대한 요청이라면
		// 주소 값을 판단해서 액션 클래스에 대한 객체를 생성.

		if (command.equals("/memberJoinAction.me")) {
			// 액션을 생성해서
			action = new MemberJoinAction(); // new MemberJoinAction() 구현 클래스
			try {
				forward = action.execute(request, response); // 여기서 forward의 필드들이 셋팅됨.
				// action에 있는 excute() 메소드를 호출.
				// 회원 정보를 처리하기 위해서 request,response를 넘김.
				// 아이디,비밀번호를 넘겨서 처리하기 위해.
				// 그 결과를 다시 받아서 forward에 저장.
			} catch (Exception e) {
				System.out.println("회원 가입  Action 에러 : " + e);
			}
		} else if (command.equals("/memberLoginAction.me")) {
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("로그인  Action 에러 : " + e);
			}
			//MemberJoinAction에서 넘어옴
		} else if (command.equals("/memberLogin.me")) { // 회원가입이 정상적으로 처리 되면 loginForm.jsp로 이동함.
			// memberLogin.me인 주소 값이라면,
			// 리다이렉트 방식으로 loginForm.jsp로 이동시킴
			forward = new ActionForward();
			forward.setRedirect(true);
			//MemberJoinAction()에서 DB에서 성공하면 호출됨.
			forward.setPath("./loginForm.jsp");
			
			//MemberLoginAction에서 넘어옴
		} else if (command.equals("/memberJoin.me")) { // 로그인 화면에서 회원가입을 누르면 joinForm.jsp(회원가입 화면)으로 이동.
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./joinForm.jsp");
		}else if (command.equals("/memberListAction.me")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./loginList.jsp");
		}

		// 각 Action 클래스 호출 결과인 forward 객체 처리
		if (forward != null) {
			// redirect 필드 값으로 포워딩 방식을 결정
			if (forward.isRedirect()) {
				// ActionFoward의 redirect가 일어났는지 (isRedirect는 boolean 타입의 get을 의미)
				// true 라면 리다이렉트를 path에 저장된 위치로 이동함.
				// redirect 포워딩 방식
				response.sendRedirect(forward.getPath());
			} else {
				// dispatcher 포워딩 방식
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
