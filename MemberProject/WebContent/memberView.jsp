<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="vo.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<h1>memberView.jsp</h1>
	<h2>멤버 리스트</h2>
	<%
		Member member = (Member) request.getAttribute("memberView");
	%>

	<table align="center" border="1">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>나이</td>
			<td>성별</td>
			<td>주소</td>
		</tr>
		<tr>
			<td><%=member.getId()%></td>
			<td><%=member.getPassword()%></td>
			<td><%=member.getName()%></td>
			<td><%=member.getAge()%></td>
			<td><%=member.getGender()%></td>
			<td><%=member.getEmail()%></td>
		</tr>
	</table>
	${memberView.getId }

	<a href="memberListAction.me">리스트로 돌아가기</a>
</body>
</html>