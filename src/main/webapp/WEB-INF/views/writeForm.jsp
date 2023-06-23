<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 쓰기</title>
</head>
<body>
	<%
		String sessionId = (String)session.getAttribute("sessionId");
		if(sessionId == null) {	
	%>
		<script type="text/javascript">
			alert('로그인한 회원만 글쓰기가 가능합니다! 로그인해 주세요');
			window.location.href='login';
		</script>
	<%
		}
	%>	

	<h2>게시판 글 쓰기</h2>
	<hr>
	<form action="write">
		글쓴이 : <input type="text" name="bid" value="${sessionId }" size="60" readonly="readonly"><br><br>
		글제목 : <input type="text" name="btitle" size="60"><br><br>
		글내용 : <textarea rows="5" cols="50" name="bcontent"></textarea><br><br>
		<input type="submit" value="글입력">
		<input type="button" value="글목록" onclick="javascript:window.location.href='list'">
	</form>
</body>
</html>