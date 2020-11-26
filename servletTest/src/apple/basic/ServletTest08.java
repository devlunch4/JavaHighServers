package apple.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest08
 */
@WebServlet("/servletTest08.do")
public class ServletTest08 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 이 서블릿의 매핑URL은 "/servletTest08.do' 로 하고
	// 이 서블릿에 초기화 파라미터로 'start'에는 1, 'end'에는 50을 설정한 후
	// 이 초기화 파라미터 값을 읽어와 start값 부터 end 값까지의 합계를 출력하는 서블릿을 작성하시오
	// 설정은 web.xml을 이용한다.

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * // TODO Auto-generated method stub
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		ServletContext context = getServletContext();
		String startx = context.getInitParameter("start");
		String endx = context.getInitParameter("end");
		
//		String startx = getInitParameter("start");
//		String endx = getInitParameter("end");


		int istart = Integer.parseInt(startx);
		int iend = Integer.parseInt(endx);
		int sum = 0;
		for (int i = istart; i <= iend; i++) {
			sum += i;
		}
		//
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>파라미터 연습</title></head>");
		out.println("<body>");
		out.println("<h2>CONTEXT : start~end 파라미터 활용 : 합구하기</h2>");
		out.println("start : " + startx + "<br>");
		out.println("end : " + endx + "<br>");
		out.println("sum : " + sum + "<br>");
		out.println("</body></html>");
	
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
