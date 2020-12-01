package apple.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionLoginServlet
 */
@WebServlet("/sessionLoginServlet.do")
public class SessionLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.session 객체 생성
		HttpSession session = request.getSession();

		// 아이디 객체 지정
		String loginid = request.getParameter("userid");
		String loginpw = request.getParameter("pass");

		// 경로 설정
		String contextPath = request.getContextPath();

		// 이프문 회원이면 세션에 회원 아이디를 저장 후 이동
		if (loginid.equals("admin") && loginpw.equals("1234")) {
			session.setAttribute("saveid", loginid);
			System.out.println(loginid + " 세션에 저장완료");
			response.sendRedirect(contextPath + "/03/sessionResult.jsp");
		} else {
			// 회원이 아니면 세션에 아무것도 저장하지 않고
			response.sendRedirect(contextPath + "/03/sessionResult.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
