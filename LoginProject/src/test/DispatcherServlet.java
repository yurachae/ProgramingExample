package test;

import java.io.IOException;import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * DispatcherServlet.java 페이지 이동 방식 
		 * 1. 포워딩( forwarding) : 넘긴다 (ex, 이메일 전달 fw) 
		 * 1) Dispatcher 방식 : 
		 * 주소 값이 바뀌지 않음. => 실제 보는 화면은 바뀜. 
		 * request 영역 공유 => request 영역의 값이 유지 됨.
		 * 
		 * 
		 * 2) Redirect 방식 : 
		 * 주소값이 바뀜. => 화면과 함께 같이 바뀜. 
		 * request 영역이 공유되지 않음. => 값이 사라짐.(null)
		 */
		
		//1) Dispatcher 방식 : 
		//dispatcher 객체 선언
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("dispatcher.jsp");
		
		//request 영역에 request 라는 이름의 속성에 requestValue를 담기
		//setAttribute는 속성값 정의
		//("속성명","속성값")
		request.setAttribute("request","requestValue");
		
		//dispatcher 방식으로 포워딩 실행 : requset에 값을 담아서 포워딩. 값 유지
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
