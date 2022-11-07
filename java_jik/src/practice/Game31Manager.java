package practice;

import java.util.Scanner;


public class Game31Manager {

	public static void main(String[] args) {
		/* 31 게임
		 * 사용자와 컴퓨터가 1부터 시작하여 돌아가면서 연속된 숫자를 부른다
		 * 한번에 최대 3개까지 부를 수 있으며 31을 부르는 사람이 지는 게림
		 * 기록은 사용자가 몇 번 이기고, 컴퓨터가 몇 번 이기는지 기록 */
		
		/* 메뉴
		 * 1. 플레이
		 * 	- 컴퓨터가 랜덤 1-3개의 숫자를 부름
		 * 	- 사용자가 몇 개의 숫자를 부를지 입력
		 * 2. 기록 확인
		 * 3. 종료*/
		
		int menu;
		// 3.종료 입력까지 메뉴 출력 반복
			do {
				// 메뉴 출력
				printMenu(
						"**** 메뉴 ****",
						"1. 플레이",
						"2. 기록 확인",
						"3. 종료",
						"-------------",
						"메뉴 선택 : ");
				
				// 메뉴 선택(입력)
				Scanner sc = new Scanner(System.in);
				menu = sc.nextInt();
				
				// 메뉴 실행
				runMenu(menu);
					
					// 1. 플레이
						// 컴퓨터가 랜덤 1-3개 출력 (숫자는 순차적)
						// 사용자가 몇 개의 숫자를 부를지 입력
						// 마지막에 3을 부르는 사람이 진다
						// 게임을 더 할 건지 물어본다 (y/n) :y = 게임이 계속 된다 n = 메뉴로 돌아간
						// 총 세번 게임을 해서 사용자가 몇 번 이기고 컴퓨터가 몇 번 이기는지 기록
				
					// 2. 기록 확인
						// 나의 점수 : 1, 컴퓨터의 점수 : 3  
					
					// 3. 종료
			}while(menu != 3);		

	}
	/**
	 * 메뉴를 출력하는 메소드*/
	public static void printMenu(String ...strs) {
		for(int i = 0; i < strs.length; i++) {
			System.out.print(strs[i] + (i != strs.length -1 ? "\n" : ""));
		}
	}
	/**
	 * 메뉴를 입력받아 메뉴를 실행하는 메소드
	 * @param 입력받은 메뉴*/
	public static void runMenu(int menu) {
		Game31 game = new Game31();
		switch(menu) {
		// 1. 플레이
		case 1 :
			// 게임 시작
			game.runGame(1, 31, 31);
				// 컴퓨터가 랜덤 1-3개 출력 (숫자는 순차적)
				
				// 사용자가 몇 개의 숫자를 부를지 입력
				// 마지막에 3을 부르는 사람이 진다
				// 게임을 더 할 건지 물어본다 (y/n) :y = 게임이 계속 된다 n = 메뉴로 돌아간
				// 총 세번 게임을 해서 사용자가 몇 번 이기고 컴퓨터가 몇 번 이기는지 기록
			System.out.println("플레이 준비 중입니다");
			System.out.println();
		break;
		// 2. 기록 확인
		case 2 :
			game.tt();
			// 나의 점수 : 1, 컴퓨터의 점수 : 3  
			System.out.println("기록확인 작업 중입니다");
			System.out.println();
		break;
		// 3. 종료
		case 3 : 
			System.out.println("프로그램을 종료합니다");
			System.out.println();
		break;
		default :
			System.out.println("잘못된 입력입니다");
			System.out.println();
		}
		
	}

}
