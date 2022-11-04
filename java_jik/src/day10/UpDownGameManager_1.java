package day10;

import java.util.Scanner;

public class UpDownGameManager_1 { // 오류, 다시수정

	public static void main(String[] args) {
		/* UP DOWN 게임을 구현하세요
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료*/
		int menu;
		Record [] records = new Record[5];
		// 반복
		do {	// (고정된) 메뉴 출력
				printFixMenu();
				// (주어진)메뉴 출력
//				printMenu(
//						"메뉴",
//						"1. 플레이",
//						"2. 기록 확인",
//						"3. 종료",
//						"-----------",
//						"메뉴 선택 : "
//						);
				// 메뉴 선택(입력)
				menu = inputNum();
				
				// 선택한 메뉴에 맞는 기능 실행 : 선택한 메뉴, 기록정보
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
		}while(menu != 3);

	}
	/** 
	 * 기능 : 주어진 기록 정보를 이용하여 선택한 메뉴에 따른 기능 실행하는 메소드.
	 * @param records 기록 정보
	 * @param menu 선택한 메뉴
	 * */
	private static void runMenu(int menu,  Record [] records) {
		switch(menu) {
		case 1 :
			// 1. 플레이
			// 플레이를 하고 나면 몇 번만에 맞췄는지 알아야 함
			int tryCount = playGame(); // 몇 번 만에 맞추는지 기록 
			// 기록 정보보다 사용자 기록이 좋으면 기록을 추가하는 메소드
			writeRecord(records, tryCount);

			break;
		case 2 : 
			// 2. 기록 확인
			printRecords(records);
			break;
		case 3 :
			// 3. 종료
			System.out.println("프로그램을 종료합니다");
			break;
		default :
			System.out.println("잘못된 입력 입니다");
		}
		
	}
	private static void printRecords(Record[] records) {
		for(int i = 0; i < records.length; i++) {
			System.out.println(i + 1 + "위 ");
			if(records[i] != null) {
				records[i].print();				
			}else {
				System.out.println();
			}
		}
		
	}
	/**
	 * 기록 정보보다 사용자 기록이 좋으면 기록을 추가하는 메소드
	 * @param records 기록 정보
	 * @param tryCount 사용자 기록*/
	private static void writeRecord(Record[] records, int tryCount) {
		int index = 0;
		for(int i = 0; i < records.length; i++) {
			// 1등부터 비교하여 나보다 기록이 좋으면내 순위가 밀림
			if(records[i] != null && tryCount > records[i].getCount()) {
				index++;
			// 기록이 없는 처음 순위를 내 기록으로 하기 위해 i를 index에 저장
			}else if(records[i] == null){ 
				index = i; // 처음 null이 있는 곳이 내가 있는 곳 // 처음에는 저장이 안될 수 있기 때문에
				break;
			}
			// 비교 순위보다 내가 기록이 좋으면 반복문 종료
			else {
				index = i;
				break;
			}
		}
		// 순위 안에 못들으면
		if(index == 5) {
			return;
		}
		System.arraycopy(records, index, records, tryCount + 1, 
				records.length - index - 1);
		System.out.println("이름 입력(예 : ABC) : ");
		Scanner sc = new Scanner (System.in);
		String name = sc.next();
		records[index] = new Record(tryCount, null);
	}
	private static int playGame() {
		// 랜덤 수 생성
		int num = random(1,100);
		System.out.println(num);
		int tryCount = 0;
		int user ;
		// 반복
		do {
			//사용자 입력
			System.out.println("정수 입력 : ");
			user = inputNum(); 
			if( user > num) {
				System.out.println("DOWN");
			}else if(user < num) {
				System.out.println("up");
			}else {
				System.out.println("정답");
			}
			tryCount++;
			// up down 판별
		}while(num != user);
		return tryCount;
	}
	public static int random(int min, int max) {
		return (int)(Math.random()*(max - min +1)+min);
	}
	/**
	 * 기능 : 콘솔에서 정수를 입력받아 입력받은 정수를 알려주는 메소드
	 * @return 입력받은 정수, 메뉴
	 * */
	private static int inputNum () { // selectMenu를 더 많은 곳에 활용하기 위해 이름 수정
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	// 메뉴를 출력하는 두가지 메소드
	/** 
	 * 기능 : 고정된 메뉴를 출력하는 메소드, 마지막 메뉴는 엔터를 안침
	 * @para strs 콘솔에 출력할 메뉴들
	 * */
	private static void printFixMenu() {
		System.out.println("--------");	
		System.out.println(" 1. 플레이");
		System.out.println(" 2. 기록 확인");
		System.out.println(" 3. 종료");
		System.out.println("--------");
		System.out.print("메뉴 선택 : ");
	}
	/** 
	 * 기능 : 주어진 메뉴를 출력하는 메소드, 마지막 메뉴는 엔터를 안침
	 * @para strs 콘솔에 출력할 메뉴들
	 * */
//	private static void printMenu(String ...strs) {
//		for(int i = 0; i < strs.length; i++) {
//			// strs의 마지막 번지가 아니라면 ? 줄바꿈을 해줘라 : ""
//			System.out.println(strs[i] + (i != strs.length-1 ? "\n" : ""));
//		}	
//	}

}
