package apple.reqres;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseTest02
 */
@WebServlet("/responseTest02.do")
public class ResponseTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// -redirect
		// 다른 페이지로 넘어가도록 한다.(직접 파라미터를 넘길수 없다.)
		// redirect명령은 넘어갈 URL 주소를 클라이언트에게 전달하고, 클라이언트(웹브라우저)가
		// 넘어갈 URL 주소로 새로운 요청을 하고 그에 따른 응답을 하는 과정으로 처리된다.

		// URL 주소로 넘어가기 떄문에 주소의 길이에 제한이 있다.
		// 이것은 성격이 서로 다른 페이지 서블릿이 그 길을 알려주고 브라우저가 받아오게 하는 것이다.

		// redirect 명령으 ㄴHttpServletResponse 객체의 sendRedirect() 메서드이다.
		// 이 메서드에 이동할 페이지의 URL 주소를 넣어서 호출한다.

		// request.setAttribute("tel", "010-2222-2222");
		// response.sendRedirect("/servletTest/responseRedirectTest.do");

		String userName = request.getParameter("username");
		response.sendRedirect("/servletTest/responseRedirectTest.do?username=" + userName + "&tel=070-7777-7777");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
