package apple.reqres;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest
 */

// HttpServletRequset객체 관련 예제 {JSP문서에서는 request객체}
@WebServlet("/requestTest.do")
public class RequestTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// request는 요청 response은 응답.
	// jsp에선 post로 넘기나 아래 post메소드의 doPost에서 받아서 doGet으로 보낸후 doGet에서 실행이 된다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		// Post 방식일 떄의 데이터 encoding 설정
		// POST 방식의 데이터 인코딩 설정
		request.setCharacterEncoding("utf-8");

		// 요청할 때 넘어온 값을 가져오는 예제
		// request.getParameter("파라미터명") ==> 해당 파라미터에 설정될 '값'을 가져온다.
		// 가져온 값은 'String' 형이다.
		// 파라미터명은 jsp의 name 과 같다.
		String userName = request.getParameter("username");
		String job = request.getParameter("job");

		// reqiest.parameterValues("파라미터명)
		// ==> 전달되는 "파라미터명"이 여러개일 경우에 사용한다.
		// ==> 가져온 값은 'String[]'이다. (String 배열)

		// form에서 구성된 checkbox 중 선택된 값들을 모두 읽어온다.
		String[] hobbies = request.getParameterValues("hobby");

		out.println("<html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>Request객체 연습</title></head");
		out.println("<body>");
		out.println("<h2>request 테스트 결과</h2>");
		out.println("<hr>");
		out.println("<table border='1'>");
		out.println("<tr><td>이름</td>");
		out.println("<td>" + userName + "</td></tr>");

		out.println("<tr><td>직업</td>");
		out.println("<td>" + job + "</td></tr>");

		out.println("<tr><td>취미</td>");
		out.println("<td>");
		// 배열의 크기만큼 반복
		for (int i = 0; i < hobbies.length; i++) {
			out.println(hobbies[i] + "<br>");

		}
		out.println("</td></tr>");
		out.println("</table>");

		out.println("<hr>");
		out.println("<h2>request객체의 메서드들</h2>");
		out.println("<table border='1'><tr><td>");
		out.println("1. 클라이언트의 IP주소 : " + request.getRemoteAddr() + "<br>");
		out.println("2. 요청 method : " + request.getMethod() + "<br>");
		out.println("3. ContextPath : " + request.getContextPath() + "<br>");
		out.println("4. 프로토콜 : " + request.getProtocol() + "<br>");
		out.println("5. URL 정보 : " + request.getRequestURL() + "<br>");
		out.println("6. URI 정보 : " + request.getRequestURI() + "<br>");
		out.println("</td></tr></table>");

		// request.getParameterNames() ==> 전송된 모든 파라미터의 이름을
		// Enumeration<String>객체에 담아서 반환한다
		out.println("<hr>");
		out.println("<h2>request.getParameterNames()메서드 처리결과</h2>");
		out.println("<ul>");
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String name = (String) params.nextElement();
			out.println("<li>" + name + "</li>");
		}
		out.println("</ul>");

		// request.getParameterMap() ==> 전송된 모든 파라미터를 Map 객체에 담아서 반환한다.
		// 이 Map 객체의 key값은 '파라미터명'이며 자료형은 'String'형이고,
		// value값은 파라미터에 저장된 '값'이며 자료형은 'String[]'형이다.
		out.println("<hr>");
		out.println("<h2>request.getParameterMap()매서드 처리결과</h2>");
		out.println("<table border='1'> <tr><td>파라미터이름</td>");
		out.println("<td>파라미터 value값</td></tr>");
		Map<String, String[]> paramMap = request.getParameterMap();
		for (String paramName : paramMap.keySet()) {
			out.println("<tr><td>" + paramName + "</td>");
			out.println("<td>");

			// 파라미터 value 값 가져오기
			String[] paramValues = paramMap.get(paramName);
			if (paramValues == null || paramValues.length == 0) { // 파라미터가 없는 경우
				continue;
			} else if (paramValues.length == 1) {// 파라미터가 배열이 아닌경우
				out.println(paramValues[0] + "<br>");

			} else {// 파라미터가 배열인 경우
				for (int i = 0; i < paramValues.length; i++) {
					if (i > 0) {
						out.println(",");
						out.println(paramValues[i]);
					} // if
				} // for
			} // else
			out.println("</td></tr>");
		} // high for
		out.println("</table>");
		out.println("</body></html>");

		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
