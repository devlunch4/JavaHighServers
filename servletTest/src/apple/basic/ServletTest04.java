package apple.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest04
 */
@WebServlet(description = "자동으로 생성한 서블릿", urlPatterns = { "/servletTest04" })
public class ServletTest04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTest04() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// Servlet 클래스나 JSP 페이지의 환경에 관련된 정보는 javax.servlet.ServletContxt
		// 인터페이스 타입의 객체를 이용해서 얻을수 있다.
		// ServletContext 객체는 getServletContext() 메서드를 통해서 얻을수 있다.

		// - 제공하는 메서드
		// 1. getServerInfo() ==> Servlet이 속하는 웹서버의 종류
		// 2. getMajorVersion() ==> 웹 컨테이너가 지원하는 Servlet규격의 메이저 버전
		// 3. getMinorVersion() ==> 마이너버전

		// ServletContext 객체 얻기
		ServletContext context = getServletContext();

		String serverInfo = context.getServerInfo();
		int majorVersion = context.getMajorVersion();
		int minorVersion = context.getMinorVersion();

		String servletName = getServletName();
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>웹 서버의 정보 </title></head>");
		out.println("<body>");
		out.println("웹서버의 종류(ServerInfo) : " + serverInfo + "<br>");
		out.printf("Servlet Name : %s<br>", servletName);
		out.printf("지원하는 Servlet버전 : %d,%d<br><br>", majorVersion, minorVersion);
		out.println("</body></html>");

		//이클립스 콘솔창 확인
		System.out.println("ServletTest04.Class 실행 완료 확인");
		System.out.println();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// do get을 호출할떈 get/post를 상관없이 처리하기 때문에.get으로 호출해서 사용.
		// 공통적으로 같은일을 하는 경우.
		doGet(request, response);
	}

}
