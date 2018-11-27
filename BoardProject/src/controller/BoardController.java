package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.BoardDeleteCheckAction;
import action.BoardDeleteAction;
import action.BoardDetailAction;
import action.BoardListAction;
import action.BoardUpdateAction;
import action.BoardUpdateCheckAction;
import action.BoardUpdateViewAction;
import action.BoardWriteAction;
import vo.ActionForward;

@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardController() {
		super();
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String ContextPath = request.getContextPath();
		String command = RequestURI.substring(ContextPath.length());
		System.out.println(command);

		Action action = null;
		ActionForward forward = null;

		// boardWrite.jsp 파일에서 boardWritePro.bo로 넘어옴.
		if (command.equals("/board/boardWritePro.bo")) {
			action = new BoardWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("boardWritePro 컨트롤러에서 생긴 예외 :" + e);
			}
		}
		// BoardWriteAction 클래스에서 성공하면 boardList.bo로 넘어옴.
		else if (command.equals("/board/boardList.bo")) {
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("boardList 컨트롤러에서 생긴 예외 :" + e);
			}

		} else if (command.equals("/board/boardWriteForm.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/board/boardWrite.jsp");
			
		} else if(command.equals("/board/boardDetail.bo")){
			action = new BoardDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("boardDetail 컨트롤러에서 생긴 예외 :" + e);
			}			
	
		} else if(command.equals("/boardDetailForm.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/board/boardDetail.jsp");
		
		}else if(command.equals("/board/boardUpdateView.bo")) {
			action = new BoardUpdateViewAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				System.out.println("boardUpdateView 컨트롤러에서 생긴 예외 :"+e);
			}
	
		}else if(command.equals("/board/boardUpdate.bo")) {
			action = new BoardUpdateAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				System.out.println("boardUpdate 컨트롤러에서 생긴 예외 :"+e);
			}
	
		}else if(command.equals("/board/boardDelete.bo")) {
			action = new BoardDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				System.out.println("boardDelete 컨트롤러에서 생긴 예외 :"+e);
			}
			
		}else if(command.equals("/board/boardDeleteCheck.bo")) {
			action = new BoardDeleteCheckAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				System.out.println("boardCheck 컨트롤러에서 생긴 예외 :"+e);
			}
			
		}else if(command.equals("/board/boardDeleteCheckForm.bo")) {
			forward = new ActionForward();
			forward.setPath("/board/boardDeleteCheck.jsp");
		
		}else if(command.equals("/board/boardUpdateViewCheckForm.bo")) {
			forward = new ActionForward();
			forward.setPath("/board/boardUpdateCheck.jsp");
		
		}else if(command.equals("/board/boardUpdateViewCheck.bo")) {
			action = new BoardUpdateCheckAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				System.out.println("boardCheck 컨트롤러에서 생긴 예외 :"+e);
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
