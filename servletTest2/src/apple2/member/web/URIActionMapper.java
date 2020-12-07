package apple2.member.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

//uri_mapping.properties파일에 설정된
//URI에 맞는 ACTION 객체를 구해와서 인스턴스를 생성해서 반환하는
//역할을 수행하는 클래스

public class URIActionMapper {
	// uri_mapping.properties파일의 내용을 읽어와
	// URI요청은 키값으로 Action 객체명은 Value값으로 저장될 Map 객체 생성
	private static Map<String, String> actionMap = new HashMap<String, String>();

	// static 초기화 블럭
	static {
		// properties파일을 읽어와 bundle객체를 생성한다.
		ResourceBundle rb = ResourceBundle.getBundle("apple2.member.web.uri_mapping");

		// Buncle객체의 key값 가져오기
		Enumeration<String> en = rb.getKeys();
		while (en.hasMoreElements()) { // 키 값 개수만큼 반복처리
			String key = en.nextElement(); // 키값 구하기 (URI요청값)
			String value = rb.getString(key); // value값(실행할 Action 클래스명)
			actionMap.put(key, value); // key 값과 value 값을 Map에 저장

		}
	}// static 초기화 블럭 끝

	// 매개 값으로 주어진 uri에 맞는 Action 객체를 인스턴스 화해서 반환하는 메서드
	public static IAction getAction(String uri) {
		IAction action = null;

		// 해당 URI 등록되어 있는 검사
		if (actionMap.containsKey(uri)) {
			try {
				// 객체 생성
				// 문자열로 된 Action클래스의 이름을 이용하여 해당 클래스를 메모리에 로딩한다.
				Class cls = Class.forName(actionMap.get(uri));

				// 메모리에 로딩된 Action 클래스를 '인스턴스화'한다==> 즉 객체를 생성한다.
				action = (IAction) cls.newInstance();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return action;
	}
}
