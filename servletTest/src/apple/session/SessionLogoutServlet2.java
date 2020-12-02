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
@WebServlet("/sessionLogoutServlett.do")
public class SessionLogoutServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//세션을 삭제한후 sessionMain.jsp로 이동한다
	
		HttpSession session = request.getSession();
		
		//session.removeAttribute("USERID");//방법1
		session.invalidate();//방법2

		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/03/sessionMain2.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
