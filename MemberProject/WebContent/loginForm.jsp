<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./memberLoginAction.me" name=loginform method="post">
		<table align="center">
			<tr>
				<td>아이디 :</td>
				<td><input type="text" name="id" id="id"></td>
			</tr>
			<tr>
				<td>비밀번호 :</td>
				<td><input type="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td>
				<a href="javascript:loginform.submit()">로그인</a>&nbsp;&nbsp;
				<a href="memberJoin.me">회원가입</a>
			</tr>
		</table>
	</form>
</body>
</html>