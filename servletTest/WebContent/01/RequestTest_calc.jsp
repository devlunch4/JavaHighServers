<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>20201127 만들어보기</title>
</head>
<body>

	<h2>Request 연습 Form</h2>
	<hr>


<form action="http://LocalHost/servletTest/RequestTest_calc.do" method="get">
	<input type="text" size="10" name="firsttext">
	<select name="pick"  style="width:50px;"><option value="+">+</option>
		<option value="-">-</option>
		<option value="*">*</option>
		<option value="/" selected>/</option>
		<option value="%">%</option>
	</select>
	<input type="text" size="10" name="secondtext">
	<input type="submit" value="확인">
	</form>



</body>
</html>
