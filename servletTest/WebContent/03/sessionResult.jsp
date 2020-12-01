
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 연습</title>
</head>
<body>


	<%
		HttpSession session2 = request.getSession();
		String contextPath = request.getContextPath();
		String sessionValue = (String) session2.getAttribute("saveid");

		if (sessionValue == null) {
	%>
	<script>
		alert("로그인 실패");
		location.href = "./sessionMain.jsp";
	</script>

	<%
		} else {
	%>

	<h3>
		saveid 세션값 :
		<%=sessionValue%></h3>
	<h3><%=sessionValue%> 
		님 반갑습니다. 어서오세요
	</h3>
	<a href="<%=request.getContextPath()%>/sessionLogoutServlet.do"> 로그
		아웃</a>
	<%
		}
	%>

</body>
</html>