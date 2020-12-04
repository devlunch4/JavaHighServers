package apple.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//-Wrapper ==> 요청(requset) 객체나 응답(Response)객체를 포장하는 것
// ==> 요청객체나 응답객체의 메서드들을 재정의할 때 사용한다.

//- 요청 객체 포장 ==> HttpServletRequestWrapper 클래스를 상속받아서 작성한다.
//- 응답객체 포장 ==>  HttpServletResponeseWrapper 클래스를 상속 받아서 작성한다.

//-Wrapper 클래스를 작성한 후 작성된 Wrapper 클래스를 사용하려면 Filter를 사용해서
//wrapper 클래스를 등록한다.

//요청 객체 포장하기 연습
public class RequestWrapperTest extends HttpServletRequestWrapper {
	// 반드시 생성자가 있어야 한다.
	public RequestWrapperTest(HttpServletRequest request) {
		// 생성자에서는 HttpServletRequest 객체를 매개변수로 받아서 조상클래스의
		// 생성자를 호출할 때 넘겨 주어야 한다.
		super(request);
	}

	// HttpServletRequest 객체의 메서드 중에서 작업에 피룡한 메서드를 재 정의 한다.
	// 예) getRemoteAddr()메서드 재정의 하기

	@Override
	public String getRemoteAddr() {
		String ip = super.getRemoteAddr(); // 원래의 명령을 실행한다.
		if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
			return "반갑습니다";
		}
		return ip;
	}

	// 예 ) getParameter()메서드 재정의
	// 회원 ID는 admin은 사용불가 ==> 사용자가 admin을 입력하면 '사용불가'를 반환시킨다.
	// 회원 이름은 없거나 null이면 '아무개'로 반환
	// 패스워드는 모두 대문자로 변환해서 반환

	// request.getParameter("mem_id");
	@Override
	public String getParameter(String name) {
		// 매개변수 'name'에는 request객체에서 보내온 데이터의 '파라미터변수명'이 들어온다.
		String value = super.getParameter(name); // 원래 값 가져오기

		if ("mem_id".equals(name)) { // 회원 ID에 대한 처리
			if ("admin".equals(value)) {
				return "사용불가";
			}
		} else if ("mem_name".equals(name)) { // 회원 이름에 대한 처리
			if (value == null || "".equals(value.trim())) {
				return "아무개";
			}
		} else if ("mem_pass".equals(name)) {
			if (value != null) {
				return value.toUpperCase();
			}

		}

		return super.getParameter(name);
	}

}
