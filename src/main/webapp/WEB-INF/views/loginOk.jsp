<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<%
		String loginCheck = request.getAttribute("loginCheck").toString();
		if(loginCheck.equals("0")) {
	%>
		<script type="text/javascript">
			alert('아이디 또는 비밀번호가 틀립니다. 다시 확인해주세요!');
			history.go(-1);//로그인 페이지로 다시 돌려보냄
		</script>
	<%
		}	
	%>
	
	<h2>${memberID }님 로그인 성공하셨습니다.</h2>
</body>
</html>