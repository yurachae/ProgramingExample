package controller;
//뷰에서 넘어온 요청을 가지고 서비스에 넘비는 역할을 함. (서비스는 판단 등)

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import vo.Member;

@WebServlet("/login") // 주소 요청 값을 받아주는 처리를 함. ("안에는 호출 조건 => form action 값")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();// 부모 생성자 호출.
	}

	// form action에서 method에서 넘어온 값에 따라서. (뷰에서 서블릿으로 오는 것을 요청(reqest)라고 함.)
	// ******* get인지, post인지 확인하기 힘드므로, doProcess를 만들어서 여기서 처리함.*******
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. loginForm.jsp로 부터 id, password를 받음.
		String  id = request.getParameter("id");
		//request로부터 id라는 속성을 가져옴. 로그인 입력 창에 입력된 값을 가져오가자는 의미.
		String password = request.getParameter("password");
		//마찬가지로 사용자가 입력한 값을 가져와서 변수에 저장.
		//로그인 버튼을 누르면 id, password 값이 넘어옴.
		//영역으로 나누어진 이유는 유지 기간이 다름을 뜻함.
		//request는 요청 받은 페이지, session은 웹브라우저 종료시(로그인 상태유지)
		System.out.println("사용자가 입력한 id: "+id);	//콘솔창에 출력
		System.out.println("사용자가 입력한 password: "+password);	//콘솔창에 출력
		
		// 2. 넘겨 받은 내용을 LoginService 클래스를 호출해서 전달
		LoginService loginService = new LoginService();	//LoginService 클래스 객체 생성.
		//멤버 클래스 타입의 변수에 LoginService의 memberLogin 메소드를 호출(매개변수는 id, password)를 저장.
		Member loginMember = loginService.memberLogin(id,password);
		
		
		// 3. 호출 결과를 통해 로그인 성공, 실패 여부 판단.(실패하면 값이 없음)
		if(loginMember != null) {//아이디와 패스워드가 db에 존재함을 의미.
			HttpSession session = request.getSession();	//세션 객체 만듬. 정보가 유지되는. 
			session.setAttribute("id", id);	//세션 영역의 속성 값으로 저장. "id"는 속성 명(변수이름), id는 로그인할 때 사용한 값. 
			response.sendRedirect("index.jsp");	//"index.jsp" 로 이동해라 라는 의미. 화면을 전환시켜라.
		}else {//로그인 실패시
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter(); //태그를 쓸 수 있는 PrintWriter 객체.
			out.println("<script> alert('로그인 실패')");
			out.println("history.back() </script>");
			
		}
		
		// 4. 로그인 성공하면 index.jsp 페이지로 이동 처리 , 세션 영역 아이디 저장.
		// 5. 로그인 실패하면 로그인 실패라는 alert 창 띄움.
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	// 메소드 :
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
