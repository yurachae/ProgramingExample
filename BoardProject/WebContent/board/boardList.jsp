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
	<h1>게시판 리스트(boardList.jsp)</h1>
	<table border=1 align="center">
		<tr>
			<td>글 번호</td>
			<td>글 제목</td>
			<td>글쓴이</td>
			<td>날 짜</td>
			<td>조회수</td>
		</tr>

		<c:forEach var="board" items="${boardList }">
			<tr>
				<td>${board.BOARD_NUM }</td>
				<!-- 해당 글의 대한 글 번호에 링크를 걸어야 함. 글 번호는 primary key 이므로. -->
				<td><a href="boardDetail.bo?boardNum=${board.BOARD_NUM}">${board.BOARD_SUBJECT }</a></td>
				<td>${board.BOARD_NAME }</td>
				<td>${board.BOARD_DATE }</td>
				<td>${board.BOARD_READCOUNT }</td>
			</tr>
		</c:forEach>

	</table>

	<a href="boardWriteForm.bo">글 쓰기</a>


</body>
</html>