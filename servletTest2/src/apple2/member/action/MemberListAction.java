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

public class MemberListAction implements IAction {

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 실제 처리할 내용을 기술하고
		// 처리가 끝난 후에 보여줄 View페이지를 반환하면 된다.
		IMemberService memService = MemberServiceImpl.getInstance();
		List<MemberVO> memList = memService.getAllMemberList();
		
		request.setAttribute("memList", memList);
		return "/member/memberList.jsp";
	}

}
