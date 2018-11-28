<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script>
		$(function() {
			$('#password').keyup(function() {
				$('font[name=check]').text('');
			}); //#password.keyup

			$('#passwordCheck').keyup(function() {
				if ($('#password').val() == $('#passwordCheck').val()) {
					$('font[name=check]').text('');
					$('font[name=check]').html("비밀번호가 일치하지 않습니다.");
				} else if($('#password').val() != $('#passwordCheck').val()){
					$('font[name=check1]').text('');
					$('font[name=check1]').html("비밀번호가 일치합니다.");
				}
			}); //#passwordCheck.keyup
		});
		function showPopup() {/* memberCheck.me 는 checkForm.jsp로 넘어감 */
			window.open('./memberCheck.me', '중복체크', 'width=300,height=200');
		}
	</script>
	<h1 align="center">회원가입 페이지(joinForm.jsp)</h1>
	<form name="joinform" action="memberJoinAction.me" method="POST">
		<table align="center">
			<tr>
				<td><input type="text" name="id" placeholder="Id" required /></td>
				<td><input type="button" value="중복체크" onclick='showPopup()' />
				</td>
			</tr>
			<tr>
				<td><input type="password" id="passoword" name="password"	placeholder="Password" required /></td>
					
			</tr>
			<tr>
				<td><input type="password" id="passwordCheck"	name="passwordCheck" placeholder="passwordCheck" required /> </td>
				<td><font name="check" size="2" color="red"></font> </td>
				<td><font name="check1" size="2" color ="blue"></font></td>
				 

			</tr>
			<tr>
				<td><input type="text" name="name" placeholder="Name" required /></td>
			</tr>
			<tr>
				<td><input type="text" name="age" placeholder="Age" /></td>
			</tr>
			<tr>
				<!-- radio/checkbox 는 name이 둘다 동일해야 함. -->
				<td><input type="radio" name="gender" value="남"
					checked="checked" />남자 <input type="radio" name="gender" value="여" />여자</td>
			</tr>
			<tr>
				<td><input type="email" name="email"
					placeholder="Email Address" /></td>
			</tr>
			<tr>
				<td><a href="javascript:joinform.submit()">회원가입</a>&nbsp;&nbsp;
					<a href="javascript:joinform.reset()">다시작성</a>
					<a href="javascript:history.go(-1)">뒤로</a></td>
			</tr>

		</table>
		
	</form>
</body>
</html>