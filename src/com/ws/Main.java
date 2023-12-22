package com.ws;

public class Main {
	public static void main(String[] args) { 
		
		Container.init(); // 공유 자원으로 쓸 Scanner가 Container클래스에 저장되어 있어서 Scanner와 연결되어있는 변수를 건네줄 init()메서드를 호출.
		
		new App().run(); // App 객체를 생성하고 클래스 내부의 run()메서드를 호출한다.

		Container.close(); // Scanner가 모두 쓰이고 run()메서드가 종료되었을때 스캐너를 종료한다.
	}
}

// Main은 처음 실행되는 곳으로 메인 클래스와 메인 메서드를 다루고 있다.

// 처음과 끝을 다루고 있으며 현재 진행하고 있는 명언 앱을 호출한다.

// App에서 모든 과정이 끝나면 스캐너를 종료해준다.