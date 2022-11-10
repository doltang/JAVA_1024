package day14;

import java.util.Scanner;

public class ExceptionEx03 {

	public static void main(String[] args) {
		/* 다음과 같은 메뉴를 출력하고 정수를 입력받는 코드를 작성하라
		 * 단, 종료를 선택하면 프로그램이 종료되고, 예외처리를 적용하여 정수가 아닌 문자열이 입력되도
		 * 프로그램이 계속 진행되도록 하라.
		 * 메뉴 
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴 선택 : */
		Scanner sc = new Scanner(System.in);
		int menu = 0; // 예외처리가 쓰이므로 꼭 초기화를 해주어야 함
		do {
			printMenu();
			
			try {			
				menu = selectMenu();
				System.out.println(menu);
			}catch(Exception e) { // 잘모르면 걍 Exception 쓰셈. 모든 예외클래스의 조상임
				System.out.println("입력을 잘못했습니다. 정수를 입력하세요.");
				sc.nextLine(); // 입력된 문자열을 빼내는 역할
			}
			
			
		}while(menu != 3);

	}

	private static int selectMenu() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 플레이");
		System.out.println("2. 기록확인");
		System.out.println("3. 종료");
		System.out.println("------------");
		System.out.print("메뉴 선택 : ");
		
	}

}
