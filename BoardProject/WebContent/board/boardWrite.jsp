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
<body align="center">
	<form action="boardWritePro.bo" method="Post">
		<h1>게시판 글 등록</h1>

		<table align="center" border="1">

			<tr>
				<td >글쓴이</td>
				<td><input type="text" name="BOARD_NAME" autofocus="autofocus"
					required></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="BOARD_PASS" required></td>
			</tr>
			<tr>
				<td>제 목</td>
				<td><input type="text" name="BOARD_SUBJECT" required></td>
			</tr>
			<tr>
				<td>내 용</td>
				<td><textarea name="BOARD_CONTENT" cols="40" rows="15" required ></textarea></td>
			</tr>
			<tr>
				<td>파일 첨부</td>
				<td><input type="file" name="BOARD_FILE"></td>
			</tr>
		</table>
		<div align="center">
			<input type="submit" value="제출" />&nbsp; &nbsp; <input type="reset"
				value="다시 쓰기">
	</form>
	</div>
	</form>
</body>
</html>