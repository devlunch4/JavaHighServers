
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 로그인 결과 페이지</title>
</head>
<body>

	<%
		//JSP 문서에서는 세션은 'session'이라는 이름으로 저장되어있다.
		String userId = (String) session.getAttribute("USERID");

		if (userId == null) { //세션이 없으면
	%>

	<script>
	alert("로그인 실패~~~~~~~~");
	
	//location.href = "이동할 페이지의  URL 주소"; // 방법1
	
	<%-- location.href = "<%= request.getContextPath()%>/03/sessionLogin2.jsp"; --%>
	location.href = "<%=request.getContextPath()%>/sessionLoginServlett.do";
	
	//history.go(-1);// 전페이지 이동
	
	
	</script>

	<%
		} else { //세션이 있으면
	%>

	<h3><%=userId%>님 반갑습니다 22 .
	</h3>
	<a href="<%=request.getContextPath()%>/sessionLogoutServlett.do">로그아웃</a>

	<%
		}
	%>
</body>
</html>