<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="vo.Board.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">

	<h1>boardCheck.jsp 파일입니다.</h1>
	<b>${sessionScope.boardDetail.BOARD_NAME }</b>님의 비밀번호를 입력하세요.
	
	<form action="boardDeleteCheck.bo" method="post">
		<input type="hidden" name="BOARD_NUM" value="${sessionScope.boardDetail.BOARD_NUM }">
		<input type="password" name="BOARD_PASS" autofocus="autofocus"> <br>
		
		<input type="submit" value="확인"> 
		<input type="reset" value="다시쓰기">
	</form>
</body>
</html>