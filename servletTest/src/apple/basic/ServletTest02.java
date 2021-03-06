package apple.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//이 예제는 애노테이션(@WebServlet)을 이용해서 Servlet을 설정하여 처리하는 예제
//애노테이션(@WebServlet)은 Servlet 버전 3.0이상에서 사용할수 있다.

//
// @WebServlet애너테이션의 속성들
// 1. name : 서블릿의 이름을 설정한다.(기본값 : 빈문자열(""))
// 2. urlPatterns : 서블릿의 URL패턴의 목록을 설정한다.(기본값 : 빈배열({}))
// // // 예)urlPatterns="url1" 또는 urlPatterns={"/url1"} ==> 패턴이 1개일 경우
// // // 예) urlPartterns={"/url1","/url2"} ==> 패턴이 2개 이상일 경우
// 3. value : urlPatterns와 동일한 기능을 한다.
//4. description : 주석(설명글을 설정한다.

@WebServlet(description = "애노테이션을 이용한 서블릿", urlPatterns = { "/servletTest02.do" })
public class ServletTest02 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);

		// 응답 문서의 인코딩방식지정
		resp.setCharacterEncoding("UTF-8");
		// 응답 문서의 ContentType 지정
		resp.setContentType("text/html; charset=UTF-8");

		// 처리한 내용을 응답으로 보내기 위해 PrintWriter객체 생성
		PrintWriter out = resp.getWriter();

		// 처리한 내용을 출력한다. ==> 방법2 println()메서드 이용하기
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charchet='UTF-8'>");
		out.println("<title>두번쨰 Servlet 연습 </title>");
		out.println("</head>");

		out.println("<body>");
		out.println("<h1 style='text-align:center;'>");
		out.println("안녕하세요. 두번쨰 Servlet 프로그램입니다. <br>");
		out.println("servlet at : " + req.getContextPath() + "<br>");
		out.println("@WebServlet 애너테이션을 이용한 예제입니다.");
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
