package com.ws.wiseSaying.entity;

public class WiseSaying { // 정보들이 저장되는 공간으로 객체와 연결된 외부에서 들어온 값들을 조립하고 관리한다.(저장 X)
	// 외부에서 쉽게 접근하지 못하도록 private로 접근을 제한했다.
	private int id; // 외부접근을 제한한 int타입의 id변수
	private String content; // 외부접근을 제한한 String 타입의 content변수
	private String author; // 외부접근을 제한한 String타입의 author변수
	
	public WiseSaying(int id, String content, String author) { // 생성자로 외부에서 들어온 값들을 this를 이용하여 필드에 넣어준다.
		this.id = id;
		this.content = content;
		this.author = author;
	}

	public int getId() { // 호출되면 저장된 id값을 리턴해준다.
		return id;
	}

	public void setId(int id) { // 외부에서 들어온 인자값으로 id의 값을 변경해준다.
		this.id = id;
	}

	public String getContent() { // 호출되면 content값을 리턴해준다.
		return content;
	}

	public void setContent(String content) { // 외부에서 들어온 인자값으로 content의 값을 변경해준다.
		this.content = content;
	}

	public String getAuthor() { // 호출되면 author값을 리턴해준다.
		return author;
	}

	public void setAuthor(String author) { // 외부에서 들어온 인자값으로 author의 값을 변경해준다.
		this.author = author;
	}

}