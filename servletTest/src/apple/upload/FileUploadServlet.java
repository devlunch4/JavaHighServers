package apple.upload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//Servlet 3.0이상에서 파일 업로드를 사용하려면 서블릿에 @MultipartConfig 애노테이션을
// 설정해야한다.

//@MultipartConfig 애노테이션을 설정할 변수들
//1. fileSizeThreshold ==> 업로드 파일을 서버에서 처리할 떄 임시 기억장소(버퍼)를 사용하는데 
//==>이 속성에서 지정한 파일 크기 이하의 파일은 메모리를 사용하고 초과되는 파일은 디스크에 직접 사용한다.

//2. maxFileSize ==> 업로드 파일의 최대 크기를 설정한다.
//3. maxRequstSize ==> 업로드 파일 데이터가 포함된 multipart/form-data 요청의 최대 크기를 설정한다.
//4. location ==> 파일이 저장될 디렉토리 경로를 설정한다. (생략가능)

//-- 위의 변수에 설정하는 파일크기는 byte 단위로 설정한다

@WebServlet("/fileUploadServlet.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1027 * 1027 * 30, maxRequestSize = 1024 * 1024
		* 50)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String UPLOAD_DIR = "uploadFiles"; // 업로드된 파일이 저장될 폴더명

	// 파일 업로드는 POST 방식만 가능
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 사용자가 업로드한 파일이 저장될 서버쪽의 폴더 경로 설정
		String applicationPath = "D:/D_Other";

		// 같은 결과 두가지 방법
		String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
		// String uploadPath2 = "D:/D_Other/uploadFiles";

		// 저장될 폴더가 없으면 새로 생성한다.
		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		// 파일이 아닌 데이터는 getParameter() 메서드나 getParameterValues()메서드를
		// 이용해서 구한다.
		request.setCharacterEncoding("utf-8");
		String memId = request.getParameter("memId");
		System.out.println("파일이 아닌 데이터 : " + memId);

		// ------------------------------------------------
		String fileName = ""; // 파일명이 저장될 변수
		List<FileDetailVO> fileList = new ArrayList<>(); // 업로드한 파일 정보가 저장될 리스트 변수 생성

		// Servlet 3.0이상에 새롭게 추가된 파일이 Upload 용 메서드들
		// 1.request.getParts(); ==> Part객체의 컬렉션을 반환한다.
		// 2. request.getPart("Part이름") ==> 지정된 이름을 가진 개별 part객체를 반환한다.

		// -- part 객체의 구조 --
		// 1.파일이 아닐경우 (ex 앞선 코드의 ID)
		// -----------sdfsdfsdfsdf ==> Part를 구분하는 구분선
		// Content-Disposition: from-data; name="memId" ==>파라미터명
		// // / // // /// ==> 빈줄
		// a001 // // // /==> 파라미터값

		//
		// 2. 파일일 경우
		// -----------sdfsdfsdfsdf ==> Part를 구분하는 구분선
		// Content-Disposition: from-data; name="file1"; filename="파일명" ==>파라미터명
		// Content-Type: text/plain ==> 파일 종류
		// // / // // /// ==> 빈줄
		// asdfasdfasdf1234 // // // /==> 파일내용(파일내용의 값. 텍스트. 또는 그림의 경우 특수값)

		for (Part part : request.getParts()) {
			fileName = extractFileName(part);// 파일명 구하기
			// 파일명이 공백이면("")이면 이것은 파일이 아닌 일반 파라미터라는 의미이다.
			if (!"".equals(fileName)) {
				// 1개의 업로드 파일 정보를 저장할 객체 생성
				FileDetailVO detail = new FileDetailVO();
				detail.setFileName(fileName);
				detail.setFileSize((long) Math.ceil(part.getSize() / 1024.0));
				try {

					part.write(uploadPath + File.separator + fileName); // 파일을 저장
					detail.setUploadStatus("Sussess");
				} catch (IOException e) {
					detail.setUploadStatus("Fail : " + e.getMessage());
				}
				fileList.add(detail); // 파일 정보를 저장한 객체 1개를 List에 추가
			} // if끝
		} // for끝
		request.setAttribute("memId", memId);
		request.setAttribute("uploadFiles", fileList);
		RequestDispatcher rd = request.getRequestDispatcher("/05/uploadFiles.jsp");
		rd.forward(request, response);

	} // getPost 메서드 끝.
		// Part 객체에서 파일명을 찾는 메서드 ==> 파일이 아닌 Part 일 경우에는 빈문자열("")을 반환한다.

	private String extractFileName(Part part) {
		String fileName = "";
		String contentDisposition = part.getHeader("content-Disposition");

		String[] items = contentDisposition.split(";");
		for (String item : items) {
			if (item.trim().startsWith("filename")) {
				// filename="test.txt"
				// 0123456789
				// '='까지의 인덱스 번호부터 최종말단 '"'전까지를 추출
				fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
			} // if끝
		} // for 끝

		return fileName;

	}

}
