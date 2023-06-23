<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용 보기</title>
</head>
<body>
	<h2>글 내용 보기</h2>
	<hr>
	<form action="modify">
	<input type="hidden" value="${boardDto.bnum }"name="bnum"> 
	글번호 : ${boardDto.bnum }<br><br>
	글쓴이 : ${boardDto.bid }<br><br>
	글제목 : <input type="text" name="btitle" value="${boardDto.btitle }"><br><br>
	글내용 : <textarea rows="5" cols="45" name="bcontent">${boardDto.bcontent }</textarea><br><br>
	조회수 : ${boardDto.bhit }<br><br>
	<input type="submit" value="수정완료">	
	<input type="button" value="취소" onclick="javascript:window.location.href='javascript:history.go(-1)'">
	</form> 
</body>
</html>