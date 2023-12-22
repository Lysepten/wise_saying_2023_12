package com.ws;

import java.util.Scanner;

public class Container { // 모든 곳에서 공유될 자원을 모아두는 클래스이다.
	private static Scanner sc; // 스캐너와 연결될 변수 선언

	// 공통적으로 사용되는 자원들을 모아두는 공간 초기화
	public static void init() {
		sc = new Scanner(System.in);
	}

	// 공통적으로 사용되는 자원들을 모아두는 공간 자원 해제
	public static void close() {
		sc.close();
	}

	public static Scanner getScanner() {
		return sc;
	}
}