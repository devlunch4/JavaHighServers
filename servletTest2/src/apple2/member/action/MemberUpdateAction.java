package apple2.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apple2.member.service.IMemberService;
import apple2.member.service.MemberServiceImpl;
import apple2.member.vo.MemberVO;
import apple2.member.web.IAction;

public class MemberUpdateAction implements IAction {

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String mem_id = request.getParameter("mem_id");
		String mem_name = request.getParameter("mem_name");
		String mem_tel = request.getParameter("mem_tel");
		String mem_addr = request.getParameter("mem_addr");
		
		MemberVO memVo = new MemberVO();
		
		memVo.setMem_id(mem_id);
		memVo.setMem_name(mem_name);
		memVo.setMem_tel(mem_tel);
		memVo.setMem_addr(mem_addr);
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		service.updateMember(memVo);
		
		return "/member/memberList.do";
	}

}
