package day10;

import java.util.Scanner;

public class UpDownGameManager {

	public static void main(String[] args) {
		/* UP DOWN 게임을 구현하세요
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료*/
		int menu;
		Record [] records = new Record[5];
		// 반복
			// 메뉴 출력
			printMenu(
					"메뉴",
					"1. 플레이",
					"2. 기록 확인",
					"3. 종료",
					"-----------",
					"메뉴 선택 : "
					);
			// 메뉴 선택(입력)
			menu = selectMenu();
			
			// 선택한 메뉴에 맞는 기능 실행
			runMenu(menu, records);
				// 플레이
					// 랜덤 수 생성
			
					// 반복
						// 사용자 입력
						
						// UP DOWN 판별
					// 기존 기록보다 좋으면 기록을 추가
						
				// 기록확인
					// 기록된 순위를 출력
			
				// 종료
		

	}
	/** 
	 * 기능 : 선택한 메뉴에 맞는 기능 실행
	 * @param menu, Records [] records 입력받은 메뉴*/
	private static void runMenu(int menu,  Record [] records) {
		switch(menu) {
		case 1 :
			// 1. 플레이
			// 컴퓨터가 랜덤으로 숫자 생성
			UpDownGame udG = new UpDownGame();
			int r = udG.random(1, 100);
			System.out.println(r);
			int tryCount = 0;
			
			// 사용자가 숫자 입력
			System.out.println("숫자를 입력하세요 : ");
			int user = udG.scanNum(new Scanner(System.in));
			udG.setUser(user);
			// 판별
			udG.runGame(r, user);
			udG.printResult();
			tryCount++;
			// 종료
			// 횟수를 기록(최대 5등)
			//5등을 기준으로 횟수가 동일한 경우 먼저 플레이한 사용자 기록을 유지
			// 기록된 최대 횟수(꼴찌)를 찾는다
			// 기록된 수를 찾음(꼴찌 순위)
			// 기록된 최새 횟수가 내 횟수보다 크거나 기록된 수가 5보다 작으면 기록
			break;
		case 2 : 
			// 2. 기록 확인
			break;
		case 3 :
			// 3. 종료
			break;
		default :
			
		}
		
	}
	/**
	 * 기능 : 메뉴를 선택(입력)하는 기능
	 * @return sc.nextInt() 입력받은 메소드
	 * */
	private static int selectMenu() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	/** 
	 * 기능 : 메뉴를 출력하는 메소드, 마지막 메뉴는 엔터를 안침
	 * @para strs 콘솔에 출력할 메뉴들
	 * */
	private static void printMenu(String ...strs) {
		for(int i = 0; i < strs.length; i++) {
			// strs의 마지막 번지가 아니라면 ? 줄바꿈을 해줘라 : ""
			System.out.println(strs[i] + (i != strs.length-1 ? "\n" : ""));
		}
		
	}

}
