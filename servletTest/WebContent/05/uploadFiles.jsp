<%@page import="apple.upload.FileDetailVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=request.getAttribute("memId") %>
		님이 방금 업로드한 파일 목록들
	</h1>
	<table border="1">

		<tread>
		<tr>
			<th>파일이름</th>
			<th>파일크기</th>
			<th>업로드상태</th>
			<th>비고</th>
		</tr>
		</tread>

		<tbody>
			<%
List<FileDetailVO> fileList = (List<FileDetailVO>) request.getAttribute("uploadFiles");
if(fileList!= null){
	for(int i = 0 ; i < fileList.size(); i++){
		%>


			<tr>
				<td><%=fileList.get(i).getFileName() %></td>
				<td><%=fileList.get(i).getFileSize() %>KB</td>
				<td><%=fileList.get(i).getUploadStatus() %></td>
				<td><a
					href="<%=request.getContextPath()%>/downloadServlet.do?fileName<%=fileList.get(i).getFileName() %>">DownLoad</a>
					</td>


			</tr>



			<%
	}
}

%>
		</tbody>




	</table>
</body>
</html>