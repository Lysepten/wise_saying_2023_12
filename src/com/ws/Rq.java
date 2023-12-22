package com.ws;

import java.util.HashMap;
import java.util.Map;

// Rq == Request(요청)
public class Rq { // Rq클래스는 외부에서 요청되는 요구사항에 알맞는 역할을 수행하고 값을 리턴하거나 올바른 값이 들어오지 못했을때 그대로 건너뛰어 오류를 막는다.
	private String actionCode;
	private Map<String, String> params;
	// 요청에 맞게
	public Rq(String cmd) { // Rq클래스에 생성자로 외부에서 스캐너와 연결된 cmd에게 전달받아 내부에서 String형태로 호출된다
		String[] cmdBits = cmd.split("\\?", 2); // Rq생성자는 App의 삭제 swicth에서 외부로 rq값을 전달하기 때문에 Rq생성자에서 테스트를 하고 알맞는 값을 저장한다.
		
		actionCode = cmdBits[0];

		params = new HashMap<>();

		if (cmdBits.length == 1) {
			return;
		}

		String[] paramBits = cmdBits[1].split("&");

		for (String paramStr : paramBits) {
			String[] paramStrBits = paramStr.split("=", 2);

			if (paramStrBits.length == 1) {
				continue;
			}

			String key = paramStrBits[0];
			String value = paramStrBits[1];
			params.put(key, value);
		}

	}

	public String getActionCode() {
		return actionCode;
	}

	public String getParam(String name) {
		return params.get(name);
	}

	public int getIntParam(String name, int defaultValue) {
		try {
			return Integer.parseInt(getParam(name));
		} catch (NumberFormatException e) {

		}
		return defaultValue;
	}

}