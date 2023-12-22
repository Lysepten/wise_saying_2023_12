package com.ws;

public class Main {
	public static void main(String[] args) { 
		
		Container.init();
		
		new App().run();

		Container.close();
	}
}

// Main은 처음 실행되는 곳으로 메인 클래스와 메인 메서드를 다루고 있다.

// 처음과 끝을 다루고 있으며 현재 진행하고 있는 명언 앱을 호출한다.

// App에서 모든 과정이 끝나면 스캐너를 종료해준다.