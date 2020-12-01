<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 연습</title>
</head>
<body>
<a herf="<%= request.getContextPath() %>/sessionAddServlet.do">Session 정보 저장하기</a>
<a herf="<%= request.getContextPath() %>/sessionAddServlet.do">Session 정보 확인하기</a>
<a herf="<%= request.getContextPath() %>/sessionAddServlet.do">Session 정보 삭제하기</a>
</body>
</html>
