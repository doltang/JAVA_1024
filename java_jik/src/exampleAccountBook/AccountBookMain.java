package exampleAccountBook;

import java.util.Scanner;

public class AccountBookMain {
	/* <객체지향 프로그램 방식으로 만들기>
	 * 가계부가 필요
	 * 가계부는 내역들로 구성
	 * 가계부 클래스
	 * 내역(항목) 클래스
	 * 가계부는 내역들을 가지고 있다(포함관계) => 가계부 클래스에 내역 객체가 필드
	 * 내역 추가, 확인, 수정, 삭제 기능을 인터페이스로 묶을 수 있다
	 * */
	public static void main(String[] args) {
		// 메인은 실행만 하는 역할을 한다
		AccountBook ab = new AccountBook(new Scanner(System.in));
		ab.run();

	}

}
