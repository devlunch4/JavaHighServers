package apple2.member.action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apple2.member.service.IMemberService;
import apple2.member.service.MemberServiceImpl;
import apple2.member.vo.MemberVO;
import apple2.member.web.IAction;

public class MemberViewAction implements IAction {

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mem_id = request.getParameter("mem_id");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		MemberVO memVo = service.getMember(mem_id);
		
		request.setAttribute("memberVo", memVo);
		
		return "/member/memberView.jsp";
	}

}
