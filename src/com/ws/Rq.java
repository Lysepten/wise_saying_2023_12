package com.ws;

import java.util.HashMap;
import java.util.Map;

// Rq == Request(요청)
public class Rq { // Rq클래스는 외부에서 요청되는 요구사항에 알맞는 역할을 수행하고 값을 리턴하거나 올바른 값이 들어오지 못했을때 그대로 건너뛰어 오류를 막는다.
	// Rq생성자는 App의 삭제 swicth에서 외부로 rq값을 전달하기 때문에 Rq생성자에서 테스트를 하고 알맞는 값을 저장한다.
	private String actionCode; // 접근이 제한된 String 타입 변수 선언
	private Map<String, String> params; // 접근이 제한된 Map과 연결될 변수 선언
	public Rq(String cmd) { // Rq클래스에 생성자로 외부에서 스캐너와 연결된 cmd에게 전달받아 내부에서 String형태로 호출된다
		String[] cmdBits = cmd.split("\\?", 2); // 명령어로 전달받은 cmd의 String 값을 "?"를 기준으로 잘라내어 cmdBits 배열에 각각 하나씩 넣어준다.
		
		actionCode = cmdBits[0]; // 잘라낸 0번째의 인덱스에 접근하여 미리 선언했던 actionCode의 변수에 값을 넣어준다.

		params = new HashMap<>(); // HashMap객체를 생성하고 params와 연결

		if (cmdBits.length == 1) { // 만약 "?"기준으로 잘라낸 cmdBits의 배열의 길이가 1과 같다면 리턴해주어 Rq를 종료한다.
			return;
		}

		String[] paramBits = cmdBits[1].split("&"); // cmdbits 배열의 1번째 인덱스에 접근하여 "&"를 기준으로 잘라내고 paramBits 배열에 각각 넣어준다.

		for (String paramStr : paramBits) { // for each로 paramBits 배열에 접근하여 paramStrBits 배열을 만들고 "=" 기준으로 잘라내어 각각 넣어준다.
			String[] paramStrBits = paramStr.split("=", 2);

			if (paramStrBits.length == 1) { // paramStrBits의 배열의 길이가 1과 같다면 밑의 코드들은 보지않고 건너뛴다.
				continue;
			}

			String key = paramStrBits[0]; // for each에서 잘라낸 0번째 인덱스에 접근하여 key 변수에 넣어준다.
			String value = paramStrBits[1]; // for each에서 잘라낸 1번째 인덱스에 접근하여 value 변수에 넣어준다.
			params.put(key, value); // HashMap객체와 연결된 params에 각각 키와 밸류값을 넣어준다.
		}

	}

	public String getActionCode() { // 호출되었을때 보유하고있는 actionCode 반환.
		return actionCode;
	}

	public String getParam(String name) { // 호출되었을때 현재 params가 보유하고 있는 key를 전달.
		return params.get(name);
	}

	public int getIntParam(String name, int defaultValue) { // 외부에서 들어온 인자들을 String에서 int타입으로 변환해주고 오류가 난다면 defaultValue(-1)를 리턴한다.
		try {
			return Integer.parseInt(getParam(name));
		} catch (NumberFormatException e) {

		}
		return defaultValue;
	}

}