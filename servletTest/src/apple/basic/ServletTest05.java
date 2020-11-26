package apple.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest05 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * // TODO Auto-generated method stub super.doGet(req, resp);
		 */

		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");

		PrintWriter out = resp.getWriter();

		// 초기화 파라미터
		// - 처음 WAS가 기동될 떄 읽어 오는 파라미터 값들을 초기화 파라미터라고 한다.
		// - '서블릿 초기화 파라미터'와 '컨텍스트 초기화 파라미터'가 있다.
		// '서블릿 초기화 파라미터'는 해당 서블릿에서만 사용가능하고
		// '컨텍스트 초기화 파라미터'는 전체 웹 어플리케이션 영역에서 사용 가능하다.

		// 2. 서블릿 초기화 파라미터 ==> web.xml에 설정하는 방법과애너테이션에 설정하는 방법 2가지가 있다.

		// 서블릿 초기화 파라미터 값을 구하기
		// 방법 1 ==> ServletConfig객체를 이용하기
		ServletConfig config = this.getServletConfig();

		// 형식) getInitParamether("파라미터 이름)
		// ==> 반환 값은 무조건 String 형으로 변환된다.
		String adminEmail = config.getInitParameter("AdminEmail");

		//////////////
		// 방법 2 ==> 현재 Servlet객체의 getInitParameter()메서드 이용하기
		String userName = getInitParameter("userName");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>초기화 파라미터 연습</title></head>");
		out.println("<body>");
		out.println("<h2>서블릿 초기화 파라미터</h2>");
		out.println("관리자 이메일 : " + adminEmail + "<br>");
		out.println("사용자 이름 : " + userName + "<br>");
		out.println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * // TODO Auto-generated method stub super.doPost(req, resp);
		 */

		//
	}
}
