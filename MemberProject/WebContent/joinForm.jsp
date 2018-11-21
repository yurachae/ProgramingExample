<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 새창 -->
<script>
function showPopup(){
	window.open('./memberCheck.me','중복체크','width=200',height='100');
}
</script>
	<!-- 아이디, 비밀번호, 이름, 나이, 성별, 이메일 주소를 입력. -->
	<!-- ./ 앞 주소를 동일하게 유지하기 위해서 사용  //	.me :도메인처럼 주소값을 통일, 일관되게 하기 위해서	 -->
	<h1 align="center">회원가입 페이지(joinForm.jsp)</h1>
	<form name="joinform" action="./memberJoinAction.me" method="POST">
		<table align="center">
			<tr>
				<td>
					<input type="text" name="id" placeholder="Id" required />
				</td>
				<td>				
					<input type="button" value="중복체크" class=".check" onclick='showPopup()' />
				</td>
			</tr>

			<tr>
				<td><input type="password" name="password" placeholder="Password" required />
			<tr>
				<td><input type="text" name="name" placeholder="Name" required /></td>
			</tr>
			<tr>
				<td><input type="text" name="age" placeholder="Age" /></td>
			</tr>
			<tr>
				<!-- radio/checkbox 는 name이 둘다 동일해야 함. -->
				<td><input type="radio" name="gender" value="남" checked="checked" />남자
				 <input type="radio" name="gender" value="여" />여자</td>
			</tr>
			<tr>
				<td><input type="email" name="email"
					placeholder="Email address" /></td>
			</tr>
			<tr>
				<td><a href="javascript:joinform.submit()">회원가입</a>&nbsp;&nbsp;
					<a href="javascript:joinform.reset()">다시작성</a></td>
			</tr>

		</table>
	</form>
</body>
</html>