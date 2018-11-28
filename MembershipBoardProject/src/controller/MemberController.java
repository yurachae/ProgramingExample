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
import action.MemberListProAction;
import action.MemberLoginAction;
import vo.ActionForward;

@WebServlet("*.me")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String ContextPath = request.getContextPath();
		String command = RequestURI.substring(ContextPath.length()); // substring()메소드는 잘라낸 문자의 길이 값.
		System.out.println("command 값 :" + command);

		ActionForward forward = null;
		Action action = null; // Action은 인터페이스.

		// 로그인 결과 처리 하는 부분.
		if (command.equals("/member/memberLoginAction.me")) {
			System.out.println("memberLoginAction.me 실행");
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("MemberController-memberLoginAction 예외 :" + e);
			}

			// 로그인 화면.jsp 로 보내는 부분.
		} else if (command.equals("/member/memberLoginForm.me")) {
			System.out.println("memberLoginForm.me 실행");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("loginForm.jsp");

			// 회원가입 form 화면 .jsp로 보내는 부분
		} else if (command.equals("/member/memberJoin.me")) {
			System.out.println("memberJoin.me 실행");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("/member/joinForm.jsp");

			//회원 가입 결과를 처리하는 부분.
		} else if (command.equals("/member/memberJoinAction.me")) {
			System.out.println("memberJoinAction.me 실행");
			action = new MemberJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("Controller-memberJoinAction 예외 :" + e);
			}

		//관리자 페이지에서 회원관리를 누르면 실행됨.
		} else if (command.equals("/member/MemberListProAction.me")) {
			System.out.println("memberListProAction.me 실행");
			action = new MemberListProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("Controller-memberListProAction 예외 :" + e);
			}

		}
			
		// 각 Action 클래스 호출 결과인 forward 객체 처리
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
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
