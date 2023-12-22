package com.ws.wiseSaying.controller;

import java.util.List;

import com.ws.Container;
import com.ws.Rq;
import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.service.WiseSayingService;

public class WiseSayingController { // WiseSayingController 클래스

	private WiseSayingService wiseSayingService; // WiseSayingService 타입으로 선언된 변수.

	public WiseSayingController() { // 생성자로 외부에서 호출되었을때 wiseSayingService 객체 생성.
		wiseSayingService = new WiseSayingService();
	}
	
	public void write() {
		System.out.print("명언 : "); // 메서드가 호출되었을때 가장먼저 출력될 출력문
		String content = Container.getScanner().nextLine().trim(); // String 타입으로 선언된 content변수에 Scanner와 연결 후 입력받고 저장한다.
		System.out.print("작가 : "); // 두번째로 출력될 출력문
		String author = Container.getScanner().nextLine().trim(); // String 타입으로 선언된 author변수에 Scanner와 연결 후 입력받고 변수에 저장한다.

		int id = wiseSayingService.write(content, author); // int 타입으로 id변수를 선언하고 wiseSayingService의 write메서드를 호출한다. 돌아온 값을 변수에 저장.

		System.out.printf("%d번 명언이 등록되었습니다.\n", id); // id를 활용하여 몇번째 명언이 등록되었는지 보여줄 출력문.
	}	
		
	public void list() { 
		List<WiseSaying> wiseSayings = wiseSayingService.findAll(); // WiseSaying타입인 List와 연결될 wiseSayings변수에 wiseSayingService내부의 findAll()메서드 실행하고
		// 돌아온 값을 wiseSayings에 넘겨준다.
		
		System.out.println("번호  /  작가  /  명언  "); // 메서드가 호출되면 출력
		System.out.println("=".repeat(30)); // repeat으로 문자를 30번 복사한다.

		for (int i = wiseSayings.size() - 1; i >= 0; i--) { // wiseSayings의 list 갯수만큼 반복하고 list내부에 있는 값들을 가져와서 WiseSaying타입으로 된 ws변수에 넣어준다.
			WiseSaying ws = wiseSayings.get(i);

			System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent()); // list에서 가져온 값들을 접근이 제한된 필드들을 get메서드로 호출하여 출력한다.
		}
	}

	public void remove(Rq rq) {

		int id = rq.getIntParam("id", -1); // 인자로 넘겨받은 rq의 내부에 getIntParam메서드를 실행하여 돌려받은 값을 int타입으로 선언된 id 변수에 저장

		if (id == -1) {
			System.out.println("id(정수)를 제대로 입력해주세요"); // 만약 rq에서 넘겨받은 값이 id에 -1로 저장되어있다면 출력문을 실행하고 return으로 메서드를 종료한다.
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id); // WiseSaying 타입으로 선언하고 findById를 호출하여 id값을 넣어주고 돌려받는다.

		if (wiseSaying == null) {
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id); // 돌려받은 값이 null이라면 출력문을 실행하고 return으로 메서드를 종료한다.
			return;
		}
		
		// 찾은 명언 객체를 object기반으로 삭제
		wiseSayingService.remove(wiseSaying); // 실제로 삭제해야할 wiseSaying변수를 넘겨주고 wiseSayingService에게 전달한다.

		System.out.printf("%d번 명언이 삭제되었습니다.\n", id); // 삭제된 번호를 출력

	}

	public void modify(Rq rq) {
		int id = rq.getIntParam("id", -1); // 인자로 넘겨받은 rq의 내부에 getIntParam메서드를 실행하여 돌려받은 값을 int타입으로 선언된 id 변수에 저장

		if (id == -1) {
			System.out.println("id(정수)를 제대로 입력해주세요"); // 만약 rq에서 넘겨받은 값이 id에 -1로 저장되어있다면 출력문을 실행하고 return으로 메서드를 종료한다.
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기 
		WiseSaying wiseSaying = wiseSayingService.findById(id); // WiseSaying 타입으로 선언하고 findById를 호출하여 id값을 넣어주고 돌려받는다.

		if (wiseSaying == null) {
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id); // 돌려받은 값이 null이라면 출력문을 실행하고 return으로 메서드를 종료한다.
			return;
		}

		// 찾은 명언 객체를 object기반으로 수정
		System.out.println("명언(기존) :" + wiseSaying.getContent()); // 찾은 객체에 메서드를 호출하여 content값을 출력한다.
		System.out.println("작가(기존) :" + wiseSaying.getAuthor()); // 찾은 객체에 메서드를 호출하여 author값을 출력한다.

		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim(); // String 타입으로 content변수를 선언하고 Scanner를 실행하여 입력받고 값을 넣어준다
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim(); // String 타입으로 author변수를 선언하고 Scanner를 실행하여 입력받고 값을 넣어준다

		wiseSayingService.modify(wiseSaying, content, author); // 찾은 객체와 수정할 값들을 modif 메서드에게 전달해준다.

		System.out.printf("%d번 명언이 수정되었습니다.\n", id); // 찾은 객체의 id값을 출력하여 수정된 번호 출력.

	}

}