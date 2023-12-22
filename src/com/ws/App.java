package com.ws;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App { // App 클래스 설계도

	private byte system_status = 1; // run()메서드가 while반복문에서 정상적으로 종료될 수 있도록 해주는 변수.

	public App() { // App생성자

	}

	public void run() { //  Main에서 호출된 메서드로 명언 앱이 실행되었을때 가장 먼저 실행될 메서드.
		System.out.println("== 명언 앱 실행 =="); // 가장 먼저 출력될 출력문

		SystemController systemController = new SystemController(); // SystemController 객체를 생성하고 객체와 연결될 변수
		WiseSayingController wiseSayingController = new WiseSayingController(); // WiseSayingController 객체를 생성하고 객체와 연결될 변수

		while (system_status == 1) { // 명언 앱이 실행되었을때 명령어를 반복해서 출력해줄 반복문이고 명령어가 한번 실행되었을때 종료되지 않고 유지될수 있도록 해주는 장치.
			System.out.print("명령어 ) "); // 유저가 명령어를 입력할수 있도록 보여주는 출력문
			String cmd = Container.getScanner().nextLine().trim(); // 명령어를 담을 Scanner를 활용할 변수
			Rq rq = new Rq(cmd); // Rq객체를 생성하고 동시에 생성자를 호출하여 받은 명령어를 넣고 받은 명령어를 자르고 테스트하여 명령어의 오류를 막는다.

			switch (rq.getActionCode()) { // 조건문으로 rq에서 전달받은 getActionCode()로 알맞는 case에 위치시켜서 그곳으로 보내주는 역할.
			case "종료": // 종료를 담당하는 case로 systemController에 접근하여 출력문을 보여준다.
				systemController.exit(); 
				system_status = 0; // 전역변수로 존재하는 system_status의 값을 0으로 바꿔주고 반복문을 종료하여 run()메서드가 종료될수 있도록 한다.
				break;
			case "등록": 
				wiseSayingController.write(); // 등록을 담당하는 case로 wiseSayingController에 접근하여 write()메서드를 실행한다.
				break;
			case "목록":
				wiseSayingController.list(); // 목록을 담당하는 case로 wiseSayingController에 접근하여 list()메서드를 실행한다.
				break;
			case "삭제":
				wiseSayingController.remove(rq); // 삭제을 담당하는 case로 wiseSayingController에 접근하여 remove(rq)메서드를 실행하고 rq를 인자로 보내준다.
				break;
			case "수정":
				wiseSayingController.modify(rq); // 수정을 담당하는 case로 wiseSayingController에 접근하여 modify(rq)메서드를 실행하고 rq를 인자로 보내준다.
				break;
			default:
				System.out.println("존재하지 않는 명령어입니다"); // case에 존재하는 명령어가 없을때 출력된다.
				break;
			}
		}

	}
}