package apple.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieAddServlet
 */
@WebServlet("/cookieAddServlet.do")
public class CookieAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		// Cookie를 저장하는 방법 순서
		// 1. cookie 객체를 생성한다. ==> 쿠키변수와 쿠키값은 붐자열로 지정한다.
		// (형식)Cookie cookie 변수 ==> new Cookie("쿠키변수","쿠키값");
		///// ==> 쿠키값으로 한글로 자용할 경우에선 URLEncoder.encode() 메서드로 인코딩 한후에 사용한다.

		// 쿠키변수가 중복되면 나중에 저장한 값으로 변경된다.

		Cookie nameCookie = new Cookie("name", URLEncoder.encode("홍길동", "utf-8"));
		Cookie ageCookie = new Cookie("age", "27");
		Cookie addrCookie = new Cookie("addr", "daejeon");

		// 2. cookie의 속성을 설정한다.
		// cookie변수.setPath("경로"); ==> 쿠키가 적용될 경로를 지정한다.() 지정한 경로와 하위에서 사용가능
		// cookie변수.setMaxAge("유지시간"); ==> 단위 : 초
		// cookie변수.setDomain("도메인명"); ==> 적용할 도메인명을 지정한다.
		// cookie변수.setSecure("보안여부"); ==> 보안여뷰 (true: 적용 false: 미적용)

		// 3.responser 객체를 이용하여 쿠키를 웹브라이저에서 보내면
		// 웹브라우저가 이 쿠키를 받아서 저장한다.
		// 형식) response 객체.addCookie(1번에서 만든 cookie객체)

		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		response.addCookie(addrCookie);

		out.println("<html><head><meta charset = 'utf-8'>");
		out.println("<head>Cookie 연습 </head></head>");
		out.println("<body>");
		out.println("<h2>Cookie데이터가 저장되었습니다.</h2><br><br>");
		out.println("<a href='" + request.getContextPath() + "/02/cookieTest.jsp'>시작문서로 이동하기 </a>");
		out.println("</body>");
		out.println("</html>");

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
