package apple.reqres;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/RequestTest_calc.do")
public class RequestTest_calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestTest_calc() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String ftext = request.getParameter("firsttext");
		String pick = request.getParameter("pick");
		String stext = request.getParameter("secondtext");

		int ft = Integer.parseInt(ftext);
		int st = Integer.parseInt(stext);

		double fx = 0;

		// if (pick.equals("+")) {
		// fx = ft + st;
		// } else if (pick.equals("-")) {
		// fx = ft - st;
		// } else if (pick.equals("*")) {
		// fx = ft * st;
		// } else if (pick.equals("/")) {
		// fx = (double) ft / st;
		// } else if (pick.equals("%")) {
		// fx = ft % st;
		// }

		String hidestr = "정상적으로 연산 되었습니다";
		switch (pick) {
		case "+":
			fx = ft + st;
			break;
		case "-":
			fx = ft - st;
			break;
		case "*":
			fx = ft * st;
			break;
		case "/":
			fx = (double) ft / st;
			if (st == 0) {
				hidestr = "분모값 : " + st + " 이므로 나누기 불가 <br>";
			}

			break;
		case "%":
			fx = ft % st;
			break;
		}

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>연습</title></head>");
		out.println("<body>");

		out.println("ftext(첫번째 숫자) : " + ftext + "<br>");
		out.println("operator(연산자) : " + pick + "<br>");
		out.println("stext(두번째 숫자) : " + stext + "<br>");
		out.println("fx(연산 값) : " + fx);
		out.println("<hr>");
		out.println("<h2>");
		out.println(ftext + " " + pick + " " + stext + " = " + fx + "<br>");
		out.println(hidestr);
		out.println("</h2></body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
