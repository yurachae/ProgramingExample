<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<h1>boardUpdateForm.jsp 페이지 입니다</h1>
	<h1>${requestScope.boardUpdateView.BOARD_NAME }님정보를수정합니다.</h1>

	<form name="updateForm" action="boardUpdate.bo" method="post">
		<input type="hidden" name="BOARD_NUM"
			value="${requestScope.boardUpdateView.BOARD_NUM }">
		<table border=1 align="center">

			<tr>
				<td>번호</td>
				<td>${requestScope.boardUpdateView.BOARD_NUM }</td>

			</tr>
			<tr>
				<td>글쓴이</td>
				<td>${requestScope.boardUpdateView.BOARD_NAME }</td>
			</tr>
			<tr>
				<td>제 목</td>
				<td>${requestScope.boardUpdateView.BOARD_SUBJECT }</td>
			</tr>
			<tr>
				<td>내 용</td>
				<td><textarea name="BOARD_CONTENT" cols="40" rows="15">${requestScope.boardUpdateView.BOARD_CONTENT }</textarea></td>
			</tr>

			<tr>
				<td>파일 첨부</td>
				<td><input type="file" name="BOARD_FILE"></td>
			</tr>
			<tr>
				<td>작성 일자</td>
				<td>${requestScope.boardUpdateView.BOARD_DATE }</td>
			</tr>
			
		</table>
		<a href="javascript:updateForm.submit()">저장</a> 
		<a href="javascript:updateForm.reset()">다시 작성</a>
	</form>
</body>
</html>