package apple.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieLoginServlet
 */
@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		// 입력값 가져오기
		String chkid = request.getParameter("chkid");

		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");

		Cookie cookieid = new Cookie("id", "test");
		Cookie cookiepass = new Cookie("pass", "1234");

		if (userid.equals(cookieid.getValue()) && pass.equals(cookiepass.getValue())) {

			// 디스페쳐사용
			// RequestDispatcher re = request.getRequestDispatcher("/02/cookieMain.jsp");
			// re.forward(request, response);

			// 리다이렉트 사용
			response.sendRedirect("/servletTest/02/cookieMain.jsp");

		} else {
			// 출력

			out.println("<html><head><meta charset=utf-8>");
			out.println("<title>Cookie ID 기억하기연습</title></head>");
			out.println("<body>");
			out.println("<h2> Cookie ID 기억하기연습 </h2>");
			out.println("<h2> 잘못된 입력 로그인 불가창 진입되었습니다. </h2>");
			out.println("<h2> 해당정보는 없습니다. 아이디 또는 비밀번호를 확인해주세요 </h2>");
			out.print("사용자아이디 : " + userid);
			out.print("<br>비밀번호 : " + pass);
			out.println(
					"<br><a href='" + request.getContextPath() + "/02/cookieLogin.jsp'>" + "이전 화면(로그인 입력) 이동하기 </a>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
