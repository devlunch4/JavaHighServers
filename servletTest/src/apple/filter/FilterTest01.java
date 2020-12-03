package apple.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FilterTest01
 */

// 서블릿 필터
// 1.사용 목적
// -클라이언트의 요청을 수행하기 전에 이 요청을 가로채서 필요한 작업을 수행할 수 있다.
// -클라이언트에 대한 응답 정보를 제공하기 전에 응답정보에 필요한 작업을 수행할 수 있다.

// 2. 사용예
// - 인증 작업용 필터
// - 데이터 압축용 필터
// - 인코딩용 필터ㅁ
// - 로깅 작업용 필터
// - 이미지 변환 작업용 필터 등등등...

/* @WebFilter("/*") */

// 필터 class 는 javax.servlet.Filter 인터페이스를 구현해서 작성해야 한다.
// 작성된 필터는 web.xml에 등록해서 작동시키거나
// @WebFilter 애노테이션을 이용해서 작동시키면 된다.
// (형식 : @WebFilter("url 매핑 정보")) ==> 모든 요청에 대하여 처리하라.
public class FilterTest01 implements Filter {

	/**
	 * @see Filter#init(FilterConfig)
	 */
	// 필터 초기화 부분
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("첫번째 Filter - init()메서드 실행...");
		
		// init()메서드에서 필터의 초기화 정보를 읽어올수 있다.
		// FilterConfig 객체의 getInitParameter()메서드를 이용한다.
		String initParam = fConfig.getInitParameter("tester");
		System.out.println("tester ==> " + initParam);
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	// 실제 처리되는 부분
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// chain.doFilter()메서드 앞쪽은 요청에 관련된 처리를 구현한다.
		System.out.println("첫번째 Filter - doFilter()메서드 호출 전...");
		chain.doFilter(request, response); // 다른 필터를 부르는 부분

		// chain.doFilter()메서드 뒤쪽은 응답에 관련된 처리를 구현한다.
		System.out.println("첫번째 Filter - doFilter()메서드 호출 후 ...");
	}

	/**
	 * @see Filter#destroy()
	 */
	
	public void destroy() {
		System.out.println("첫번째 Filter - destory() 메서드 실행...");
	}

}
