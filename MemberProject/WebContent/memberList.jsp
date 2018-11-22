<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="vo.Member"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head> 
<body align="center">
	<h1>memberList.jsp 페이지</h1>

	
	<table align="center">
		<tr>
			<td colspan=2>회원목록 </td>
		</tr>
		<c:forEach var="member" items="${memberList}">
			<tr>
				<td><a href="memberViewAction.me?id=${member.id }">${member.id }</a></td>
				<td><a href="memberDeleteAction.me?id=${member.id }">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

