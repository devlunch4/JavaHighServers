package apple.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessionAddServlet
 */
@WebServlet("/sessionAddServlet.do")
public class SessionAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Session 저장하는 방법 및 순서

		// 1.session 객체 생성
		// 형식1) request.getSession(); 또는 request.getSession(true);
		// ==> 현재 세션이 존재하면 현재 세션 객체를 반환하고, 세션이 없으면 새로운 세션을 생성한다.
		// 형식2) request.getSession(false);
		// ==> 현재 세션이 존재하면 현재 세션 객체를 반환하고, 세션이 없으면 null을 반환한다.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
