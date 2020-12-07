package apple2.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apple2.member.action.MemberListAction;
import apple2.member.web.IAction;

/**
 * Servlet implementation class TestController
 */
//@WebServlet
//@WebServlet("/testController2.do")
public class TestController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		// URL ==> http://localhost/servletTest2/member/memberList.do
		// URI ==> /servletTest2/member/memberList.do
		// ContextPath ==> /servletTest2

		// 원격 요청 URI => /member/memberList.do

		// 사용차의 요청 정보 가져오기
		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length());
		System.out.println("uri ==> " + uri);

		String viewPage = null; // view페이지가 저장될 변수선언
		IAction action = null;
		// 서버를 실행후
		// 주소창에 입력해도됨 .http://localhost/servletTest2/member/memberList.do

		if (uri == null) {

		} else if ("/member/memberList.do".equals(uri)) {
			// URI에 맞는 작업을 한다.
			// IMemberService memService = MemberServiceImpl.getInstance();
			//
			// //서비스의 메소드 실행
			// List<MemberVO> memList = memService.getAllMemberList();
			//
			// // 가져온 정보를 request객체의 setAttribute()메서드를 이용해서 저장한다.
			// //==> view페이지로 전달할 데이터를 세팅한다.
			// request.setAttribute("memList", memList);

			
			
			 action = new MemberListAction();
			 viewPage = action.process(request, response); // view페이지 설정
			 
				// 서버를 실행후
				// 주소창에 입력해도됨 .http://localhost/servletTest2/member/memberList.do

		} else if ("/member/memberView.do".equals(uri)) {
			// 상세 정보
		} else {

		}

		// 해당 view페이지를 포워딩 또는 리다이렉트 한다.
		// ==> /WEB-INF/view/member/memberList.jsp
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view" + viewPage);
		rd.forward(request, response);

		// 서버실행
		// 주소창에 실행 >>> http://localhost/servletTest2/member/memberList.do

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
