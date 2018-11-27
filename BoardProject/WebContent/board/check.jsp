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
	<h1>수정/삭제 하시겠습니까?</h1>
	<a href = "boardDelete.bo?boardNum=${sessionScope.boardDetail.BOARD_NUM }">삭제</a>
	<a href ="boardUpdateView.bo?boardNum=${sessionScope.boardDetail.BOARD_NUM }">수정</a>
</body>
</html>