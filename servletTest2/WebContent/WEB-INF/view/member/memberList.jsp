<%@page import="apple2.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Test Controller사용 결과 페이지</h1>
	주소창 입력후 결과 >>> http://localhost/servletTest2/member/memberList.do
	<br>
	<br>
	<hr>
	<%
		//controller에서 보내온 데이터를 받는다. ==> request객체.getAttribute()메서드이용

		List<MemberVO> memList = (List<MemberVO>) request.getAttribute("memList");

		for (MemberVO memVo : memList) {
	%>

	<%=memVo.getMem_id()%>,
	<br>
	<%=memVo.getMem_name()%>,
	<br>
	<%=memVo.getMem_tel()%>,
	<br><%=memVo.getMem_addr()%>


	<%
		}
	%>

</body>
</html>