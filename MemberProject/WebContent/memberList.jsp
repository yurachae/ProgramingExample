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
	<%
		ArrayList<Member> memberList = (ArrayList<Member>) session.getAttribute("memberList");
	%><table>
		<tr>
			<td colspan=2>회원목록</td>
			<%
				for (int i = 0; i < memberList.size(); i++) {
			%>

		</tr>
		<tr>
			<td><a
				href="memberViewAction.me?id=
            <%=memberList.get(i).getId()%>">
					<%=memberList.get(i).getId()%></a></td>
			<td><a
				href="memberDeleteAction.me?id=
            <%=memberList.get(i).getId()%>">
					삭제</a></td>
		</tr>
		<%
			}
		%>
	</table>



	<table>
		<tr>
			<td colspan=2>회원목록 (EL, jstl사용)</td>
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

