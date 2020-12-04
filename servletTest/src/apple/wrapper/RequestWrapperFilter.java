package apple.wrapper;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestWrapperFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		RequestWrapperTest requestWrapper = new RequestWrapperTest((HttpServletRequest)request); 
		
		//망약에 ResponseWapper 객체도 등록하려면 이곳에서 같이 생성한다.
		
		
		//필터의 체이닝에서 원래의 Request객체 대신 RequestWrapper 객체를 인수로 넣어준다.
		
		//chain.doFilter(request,response);
		chain.doFilter(requestWrapper,response);

	}

	@Override
	public void destroy() {

	}

}
