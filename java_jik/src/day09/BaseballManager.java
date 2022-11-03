package day09;

import java.util.Scanner;

import day08.MethodBaseballEx01_1;


public class BaseballManager {

	public static void main(String[] args) {
		/* 숫자 야구게임을 플레이 한 후, 기록을 저장하는 프로그램을 작성하라
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * 1. 홍길동 2회
		 * 2. 임꺽정 3회
		 * 3. 이몽룡 3회
		 * 4. 춘향이 4회
		 * */
		Scanner scan = new Scanner(System.in);
		Players [] list = new Players [5];
		// 반복문을 통해 메뉴를 출력
		int menu;
		int count = 0;
		
		do {
			// 메뉴를 출력
			printMenu();
			
			// 메뉴 선택(입력)
			menu = selectMenu();
			
			// 선택한 메뉴에 맞는 기능 실행
			count = runMenu(menu, list, count);
						
					
				// 2. 기록확인
					// 등록된 5위까지의 기록을 확인
				// 3. 종료
			
		}while(menu != 3);
	}
	/**
	 * 메뉴를 출력하는 메소드
	 * */
	public static void printMenu() {
		System.out.println("-----메뉴-----");
		System.out.println("1. 플레이"); 
		System.out.println("2. 기록확인");
		System.out.println("3. 종료");
		System.out.println("-------------");
		System.out.print("메뉴를 선택하세요 : ");
	}
	// 메뉴
	/**
	 * 콘솔에서 입력받은 정수(메뉴)를 알려주는 메소드
	 * @return 입력받은 정수(메뉴)
	 * */
	public static int selectMenu() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	/**
	 * 메뉴에 맞는 기능을 실행하는 메소드
	 * @param menu 선택한 메뉴
	 * @param list 플레이어 정보가 들어있는 리스트
	 * @return 현재 저장된 플레이어의 수 
	 * */
	public static int runMenu(int menu, Players [] list, int count) {
		int grade, classNum, num;
		String name;
		Scanner sc = new Scanner(System.in);
		switch(menu) {
		case 1 : 			
			// 게임을 플레이 
			
			// 1. 플레이
			// 컴퓨터가 랜덤으로 숫자 생성
			int min = 1, max = 9, size = 3;
			int [] com = MethodBaseballEx01_1.createRandomArray(min, max, size);
			MethodBaseballEx01_1.printArray(com);
			
				int strike = 0, ball;
				do {
					// 사용자가 숫자 입력
					System.out.println("입력 : ");
					int [] user = MethodBaseballEx01_1.scanArray(sc, size);
					
					// 판별
					strike = MethodBaseballEx01_1.getStrike(com, user);
					ball = MethodBaseballEx01_1.getBall(com, user);
					
					// 결과 출력
					MethodBaseballEx01_1.printGame(strike, ball);
					
					//[new] 회수를 기록(최대 5등까지), 
					// 5등 기준 회수가 동일한 경우 먼저 플레이한 사용자 기록을 유지
					// 3S 종료
					System.out.println("게임 종료");
					sc.close();
				}while(strike < 3);
				
		case 2 : 
			// // 플레이어의 기록을 가장 빨리 맞힌 순으로 출력
			// 저장된 플레이어 수 만 볼 것이기 때문에 향상된 for문 사용 안함
			for(int i = 0; i < count; i++) {
				list[i].print();
			}
			break;
		case 3 : 
			System.out.println("게임을 종료합니다!");
			break;
		default:
			System.out.println("잘못된 메뉴입니다");
			
		}
		return count;
	}

}
