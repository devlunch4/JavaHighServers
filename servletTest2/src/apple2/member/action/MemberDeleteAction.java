package apple2.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apple2.member.service.IMemberService;
import apple2.member.service.MemberServiceImpl;
import apple2.member.web.IAction;

public class MemberDeleteAction implements IAction {

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String mem_id = request.getParameter("mem_id");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		service.deleteMember(mem_id);
		
		return "/member/memberList.do";
	}

}
