package apple2.member.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apple2.member.service.IMemberService;
import apple2.member.service.MemberServiceImpl;
import apple2.member.vo.MemberVO;
import apple2.member.web.IAction;

public class MemberListAction2 implements IAction {

	@Override
	public boolean isRedirect() {
		// redirect일 경우에는 true, forward일 경우에는 false를 반환한다.
		return false;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 실제로 처리할 내용을 기술하고, 처리가 끝난후 보여줄 View페이지를 반환하면된다.

		// URI에 맞는 작업을 한다.
		IMemberService memService = MemberServiceImpl.getInstance();

		// 서비스의 메소드 실행
		List<MemberVO> memList = memService.getAllMemberList();

		// 가져온 정보를 request객체의 setAttribute()메서드를 이용해서 저장한다.
		//==> view페이지로 전달할 데이터를 세팅한다.
		request.setAttribute("memList", memList);

		return "/member/memberList.jsp"; // view페이지 설정;
	}

}
