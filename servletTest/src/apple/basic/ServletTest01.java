package apple.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿이란 ==> 컨테이너(서블릿엔진)에 의해 관리되는 자바기반 웹 컴포넌트로서,
// /////////동적인 웹 컨텐츠 생성을 가능하게 해준다.

// http://localhost:80/servletTest/servletTest01.do
// - http ==> 프로토콜
// - localhost ==> 컴퓨터 이름 또는 도메인명 또는 IP주소
// - 80 ==> 포트번호
// - /servletTest ==> 켄텍스트패스(보통'프로젝트이름'으로 지정된다.)
// - /servletTest01.do ==> 서블릿 요청 URL 패턴

//이 예제는 배포서술자(DD, Depolyment Descriptor ==> web.xml)를 이용해서
// 실행할 Servlet을 설정하여 처리하는 예제이다.
public class ServletTest01 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// - 이영역에는 대부분 service()메서드 또는 deGet()메서드나 doPost()메서드르 ㄹ재정의해서 작성한다.

	// - doGet()메서드는 doPost()메서드는 service()메서드를 통해서 호출된다.
	// - HttpServletRequest객체 ==> 서비스 요청에 관련된정보 및 메서드를 관리하는 객체
	// - HttpServletResponse객체 ==> 서비스 응답에 관련된 정보 및 메서드를 관리하는 객체

	//
	// 자동완성 doGet
	// doGet 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);

		// 응답 문서의 인코딩방식지정
		resp.setCharacterEncoding("UTF-8");
		// 응답 문서의 ContentType 지정
		resp.setContentType("text/html; charset=UTF-8");

		// 처리한 내용을 응답으로 보내기 위해 PrintWriter객체 생성
		PrintWriter out = resp.getWriter();

		// 각객체 생성 완료 콘솔로 확인
		System.out.println("printWriter 객체 생성 완료 확인");
		System.out.println();

		// 처리한 내용을 출력한다. ==> 방법1) append() 메서드 이용하기
		out.append("<html>");
		out.append("<head>");
		out.append("<meta charchet='UTF-8'>");
		out.append("<title>첫번쨰 Servlet 연습 </title>");
		out.append("</head>");
		// --
		out.append("<body>");
		out.append("<h1 style='text-align:center;'>");
		out.append("안녕하세요. 첫번째 Servlet 프로그램입니다.<br>");
		out.append("servlet at : " + req.getContextPath() + "<br>");
		out.append("</h1>");
		out.append("</body>");
		out.append("</html>");
		
		System.out.println("HTML 생성 완료 확인");
		System.out.println();
		
	}

	//
	//
	// doPost() 메서드 ==> POST방식의 요청을 처리하는 메서드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
