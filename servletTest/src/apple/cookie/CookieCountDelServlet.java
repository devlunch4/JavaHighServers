package apple.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCountDelServlet
 */
@WebServlet("/cookieCountDelServlet.do")
public class CookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {

			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if ("count".equals(name)) {
					Cookie newCount = new Cookie("count", "0");
					newCount.setMaxAge(0);
					response.addCookie(newCount);
				}
			}

			out.println("<html><head><meta charset=utf-8>");
			out.println("<title>Cookie Count DEL연습</title></head>");
			out.println("<body>");
			out.println("<h2> 초기화 되었습니다 </h2>");
			
			out.println("<a href='" + request.getContextPath() + "/02/cookieTest02.jsp'>시작 문서로 이동하기 </a>");
			
			out.println("</body>");
			out.println("</html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
