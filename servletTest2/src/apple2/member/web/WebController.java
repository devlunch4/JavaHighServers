package apple2.member.web;

import java.io.IOException;
import java.util.List;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apple2.member.action.MemberListAction;
import apple2.member.service.IMemberService;
import apple2.member.service.MemberServiceImpl;
import apple2.member.vo.MemberVO;
import apple2.member.web.IAction;

/**
 * Servlet implementation class TestController
 */
@WebServlet("/webController.do")
public class WebController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		// URL ==> http://localhost/servletTest2/member/memberList.do
		// URI ==> /servletTest2/member/memberList.do
		// ContextPath ==> /servletTest2 ==>13글자

		// 원격 요청 URI => /member/memberList.do

		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length());

		String viewPage = null;
		IAction action = null;
		
		//요청 URI를 이용하여 실행할 Action 객체를 구한다.
		action = URIActionMapper.getAction(uri);

		if(action == null) {
			//실행할 Action이  없다면 404에서 처리
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}else {
			//실행 작업 완료후 view 페이를 받는다.
			viewPage = action.process(request, response);
			if(viewPage!=null) {
				if(action.isredirect()) {//리다이렉트가 true인 경우
					response.sendRedirect(request.getContextPath() + viewPage);
					
				}else {//포워딩
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view" + viewPage);
					rd.forward(request, response);
				}
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
