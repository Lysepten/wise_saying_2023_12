package com.ws.wiseSaying.entity;

public class WiseSaying { // 정보들이 저장되는 공간으로 객체와 연결된 외부에서 들어온 값들을 조립하고 관리한다.(저장 X)
	// 외부에서 쉽게 접근하지 못하도록 private로 접근을 제한했다.
	private int id;
	private String content;
	private String author;

	public WiseSaying(int id, String content, String author) {
		this.id = id;
		this.content = content;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}