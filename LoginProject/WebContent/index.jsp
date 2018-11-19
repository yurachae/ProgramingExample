<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<H1>index.jsp</H1>
	<!--"id"는 파라미터 이름.  -->
	<h1><%=session.getAttribute("id")%>님 로그인 	</h1>	<br>
	
	<h1>${sessionScope.id}님 로그인</h1>
	
	<% String id = (String)session.getAttribute("id");
	if(id == null) {%>
	<a href = "loginform.jsp">로그인</a>
	<%}else { %>
	<a href = "logout">로그아웃</a>
	<%} %>




</body>
</html>
