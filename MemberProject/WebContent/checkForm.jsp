<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<h1>ID 중복 체크하기</h1>
	<!--./memberCheckAction.me Controller를 거쳐서 memberCheckAction으로 이동-->
	<form action="./memberCheckAction.me" method="POST">
		<input type="text" name="id" id="id" placeholder="Id"> 
		<input type="submit" value="중복체크">
	</form>
</body>
</html>