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
	<h1>boardDetail.jsp 페이지 입니다</h1>
	<h1>${sessionScope.boardDetail.BOARD_NAME }님 정보입니다.</h1>
	<table border=1 align="center">

		<tr>
			<td>번호</td>
			<td>${sessionScope.boardDetail.BOARD_NUM }</td>

		</tr>
		<tr>
			<td>글쓴이</td>
			<td>${sessionScope.boardDetail.BOARD_NAME }</td>
		</tr>
		<tr>
			<td>제 목</td>
			<td>${sessionScope.boardDetail.BOARD_SUBJECT }</td>
		</tr>
		<tr>
			<td>내 용</td>
			<td><textarea cols="40" rows="15" readonly="readonly">${sessionScope.boardDetail.BOARD_CONTENT }</textarea></td>
		</tr>

		<tr>
			<td>파일 첨부</td>
			<td>${sessionScope.boardDetail.BOARD_FILE }</td>
		</tr>
		<tr>
			<td>작성 일자</td>
			<td>${sessionScope.boardDetail.BOARD_DATE }</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${sessionScope.boardDetail.BOARD_READCOUNT }</td>
		</tr>
	</table>
	<a href ="boardList.bo">[목록] </a>
	<a href ="boardDeleteCheckForm.bo?boardNum=${sessionScope.boardDetail.BOARD_NUM }">[삭제]</a>&nbsp; 
	<a href ="boardUpdateViewCheckForm.bo?boardNum=${sessionScope.boardDetail.BOARD_NUM }">[수정]</a>&nbsp; 
	<a href ="boardReplyForm.bo?boardNum=${sessionScope.boardDetail.BOARD_NUM }">[답글]</a>&nbsp; 
	

</body>
</html>