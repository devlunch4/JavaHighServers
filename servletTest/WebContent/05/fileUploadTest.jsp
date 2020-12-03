<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>File Upload 용 폼페이지</title>
</head>
<body>
	<h1>File UPLOAD 연습</h1>
	<h3>파일 선택창에서 ctrl키나 shift 키를 누를 상태에서 클릭을 하면 <br>
	여러개의 파일을 한꺼번에 선택할 수 있다.</h3>

	<!-- enctype="multipart/form-data" ==> 파일 전송용 Form이라는 의미이다. -->
	<!-- multiple 여러개 선택이 가능 시프트나 알트키를 통한 여러개 선택 -->
	<!--  파일 업로드는 post 방식만 사용가능-->
	<form action="<%=request.getContextPath()%>/fileUploadServlet.do"
		enctype="multipart/form-data" method="post">
		ID : <input type="text" name="memId"><br>
		<br> Upload File1 : <input type="file" name="file1" multiple><br>
		<br> Upload File2 : <input type="file" name="file2" multiple><br>
		<br> <input type="submit" value="파일 업로드">

	</form>
</body>
</html>