<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"  href="assets/css/registStyle.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일반 회원가입</title>
<script type="text/javascript" src="assets/js/check.js"></script>
</head>
<body>
<div id="registForm">
	<div id="logo"> <h1>회원가입</h1> </div>
	<center>
	<form action="regist" method="post" name="frm">
		<table>
			<tr>
				<td width="100">
				<font color="blue">아이디</font>
				</td>
				<td width="100" size="50">
				<input type="text" id="user_id" name="id">
				<input type="button" value="중복확인" class="myButton"><br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				<font color="blue">비밀번호</font>
				</td>
				<td width="100">
				<input type="password" size="50" id="password" name="password"/><br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				<font color="blue">비밀번호학인</font>
				</td>
				<td width="100">
				<input type="password" size="50" id="repassword" name="repassword"/><br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				<font color="blue">이름</font>
				</td>
				<td width="100">
				<input type="text" size="50" name="name"/><br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				<font color="blue">이메일</font>
				</td>
				<td>
				<input type="text" size="30" name="emailHead"/>
				<select name="emailTail">
					<option>naver.com</option>
					<option>daum.net</option>
					<option>gmail.com</option>
					<option>nate.com</option>                        
				</select>
				<br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				<font color="blue">전화번호</font>
				</td>
				<td>
				<input type="text" placeholder="000-0000-0000" size="50" maxlength="13" id="phone" name="phone"/>
				<br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				<font color="blue">주소</font>
				</td>
				<td>
				<input type="text" size="40" name="addr"/><br/>
				</td>
			</tr>
		</table>
		
		<div id="btn">
			<input type="submit" value="회원가입" id="sign">
			<input type="reset" name="cancel" value="다시 쓰기">
			<button type="button" onclick="location.href='select'">취소</button><br/>
		</div>
	</form>
	</center>
</div>
</body>
</html>