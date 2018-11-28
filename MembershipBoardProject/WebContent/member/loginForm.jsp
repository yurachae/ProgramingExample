<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="memberLoginAction.me" name=loginform method="post">
		<table align="center">
			<tr>
				<td><input type="text" name="id" id="id" placeholder="Id" required></td>
			</tr>
			<tr>
				<td><input type="password" name="password" id="password"
					placeholder="password" required /></td>
			</tr>
			<tr>
				<td><a href="javascript:loginform.submit()">로그인</a>&nbsp;&nbsp;
					<a href="joinForm.jsp">회원가입</a>
					<a href="javascript:history.go(-1)">뒤로</a></td>

			</tr>
		</table>
	</form>

</body>
</html>