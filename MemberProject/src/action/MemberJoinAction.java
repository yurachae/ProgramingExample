package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberJoinService;
import vo.ActionForward;
import vo.Member;

//Action 구현 클래스 : 
public class MemberJoinAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 입력받은 값들을 Member 클래스 필드에 저장.
		// 1. joinForm.jsp 로부터 전송받은 데이터를 가져옴.
		// 2. 데이터를 Member 타입 객체에 필드값으로 저장.
		// 3. Service 클래스의 회원가입 메소드 호출.
		// 4. 호출 결과를 넘겨 받아 회원 가입 성공, 실패 여부 판단.
		// 4-1. 성공하면 loginForm으로
		// 4-2. 실패하면 회원가입 실패 alert 띄움. 뒤로가기 실행.
		// 5. 결과를 MemberController로 리턴.

		//Member 클래스의 객체 생성
		Member member = new Member();
		
		System.out.println(request.getAttribute("id"));
		//joinForm.jsp로 부터 입력된 값을 각각 변수에 저장
		String id  = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		//저장된 변수 값을 Member의 각 필드값으로 저장.
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setAge(age);
		member.setGender(gender);
		member.setEmail(email);
		
		//Member클래스의 변수 member의 필드를 출력.
		System.out.println(member.toString());
		
		
		
		// 3. Service 클래스의 회원가입 메소드 호출.
		boolean joinResult = false;
		MemberJoinService memberJoinService = new MemberJoinService();
		
		//service에서 DB의 INSERT이 되었으면 TRUE, 아니면 FALSE로 넘어옴.
		joinResult = memberJoinService.memberJoin(member);//DB에 제대로 저장됐는지를 판단해서
		
		ActionForward forward = null;
		
		if( !joinResult ) { //결과가 False면 DB 등록 실패
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입 실패')");
			out.println("history.back() </script>");
			
		}else {	//결과가 true면 DB 등록 성공
			//회원 가입이 성공하면 redircet 포워딩으로  memberLogin.me 주소로 이동
			//memberLogin.me 주소는 loginForm.jsp를 부름.
			
			forward = new ActionForward(); //객체 생성
			forward.setRedirect(true);		
			forward.setPath("./memberLogin.me");//주소 값으로 Redirect를 보냄. => MemberController가 호출 됨.
		}

		// 리턴은 ACtionForward 변수.
		return forward;
	}

}
