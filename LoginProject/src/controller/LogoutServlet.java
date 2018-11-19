package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	//session 영역 close
    	HttpSession session = request.getSession();	//세션 객체 만듬. 정보가 유지되는. 
		session.invalidate();
    	
		// loginform.jsp로 넘김.
		response.sendRedirect("loginform.jsp");
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
