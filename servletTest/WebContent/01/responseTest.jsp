<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Response객체 - forward,sedRedirect 연습</title>
</head>
<body>
	<h2>forward,sendRedirect 연습</h2>
	<hr>
	<form method="post" action="/servletTest/responseTest01.do">
		forward로 처리하기 : <input type="text" name="username"> <input
			type="submit" value="확인">
	</form>
	<hr>
	<form method="post" action="/servletTest/responseTest02.do">
		sepnese.sendRedirect로 처리하기: <input type="text" name="username">
		<input type="submit" value="확인">
	</form>
</body>
</html>
