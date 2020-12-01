<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>

	<!-- "ID기억하기" 체크박스를 체크한 후 ;login;버튼을 클릭하면 입력했던 'id'를 쿠키에 저장하고
쿠키에 'ID'값이 저장되어 있으면 'id'입력 창에 쿠키에 저장되었던  'id'값이 나타나도록 하고,
체크박스도 체크가 된 상태로 유지되도록 한다.-->
	<!-- 체크박스를 해제한 후 로그인을 하면 쿠키에 저장된 'id'를 삭제하고 체크박스로 해제된 상태가 되도록 한다.-->
	<!-- 현재 등록된 로그인 할수 있는 id는 'test'이고 password '1234'이다.
로그인에 성공하면 'cookieMain.jsp' 문서로 자동으로 이동하고, 실패하면 'cookieLogin.jsp' 문서로 이동되로록 한다. 

처리하는 서블릿 패턴은 '/cookieLoginServletdo.do 로 한다 -->


<!-- 
	쿠키값을 확인해서 USERID라는 쿠키가 있으면 해당 쿠키값을 아래쪽'userid'의 text객체에 
	세팅하고 체크박스가 체크된 상태가 되도록 한다.
	
 -->
 
 
 <%String cookieUserid=""; // 쿠키값이 저장될 변수 
 String chk =""; //체크박스의 체크여부를 설정할 변수
 
 Cookie[] cookies = request.getCookies();
 
 if(cookies!=null){
	 for(int i = 0; i < cookies.length;i++){
		 if(cookies[i].getName().equals("USERID")){ //원하는 쿠키가 있으면
			 cookieUserid= cookies[i].getValue(); //쿠키값 구하기
			 chk = "checked";
			 
		 }
	 }
 }
 
 
 %>

	<form action="<%=request.getContextPath()%>/cookieLoginServlet.do">

		<table>

			<tr>
				<td>ID :</td>
				<td><input type="text" name="userid" placeholder="ID를 입력하세요"
					value="<%=cookieUserid%>"></td>
			</tr>
			<!-- 

 -->
			<tr>
				<td>PASSWORD :</td>
				<td><input type="password" name="pass"
					placeholder="PASSWORD를 입력하세요" value=""></td>
			</tr>
			<!-- 
			
			 -->
			<tr>
				<td colspan="2"><input type="checkbox" name="chkid"
					value="check" <%=chk %>>ID 기억하기</td>
			</tr>
			<!-- 
			
			 -->
			<tr>
				<td colspan="2" style="text-align: center"><input type="submit"
					value="LOGIN"></td>
			</tr>



		</table>

	</form>
</body>
</html>