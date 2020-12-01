package apple.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionLogoutServlet
 */
@WebServlet("/sessionLogoutServlet.do")
public class SessionLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// session 삭제하기
		// 1. 세션 객체 구하기
		HttpSession session = request.getSession();

		// 2.세션값을 개별적으로 삭제하기
		// 형식) session객체.removeAttribute("삭제할 key값);
		// ==> 세션에 저장된 데이터들 중에서 지정할 'key'값과 같은 Session값이 삭제된다.
		// session.removeAttribute("testSession");

		// 3.세션 전체 삭제하기
		// 형식) session 객체.invalidate(); ==> 세션 자체가 삭제된다.

		session.invalidate();

		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/03/sessionLogin.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
