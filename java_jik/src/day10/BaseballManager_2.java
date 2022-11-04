package day10;

import java.util.Scanner;

import day08.MethodBaseballEx01_1;


public class BaseballManager_2 {

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
		// 반복문을 통해 메뉴를 출력
		int menu;
		Record [] records = new Record[5];
		do {
			// 메뉴를 출력
			printMenu(
					"메뉴",
					"1. 플레이",
					"2. 기록 확인",
					"3. 종료",
					"-------",
					"메뉴 선택 : "
					);
			
				// 메뉴 선택(입력)
				menu = selectMenu();
			
				// 선택한 메뉴에 맞는 기능 실행
				runMenu(menu, records);
			
			}while(menu != 3);
	}
	/** 
	 * 주어진 메뉴에 맞는 기능을 실행하는 메소드
	 * @param menu 실행할 메뉴 번호
	 * */
	private static void runMenu(int menu, Record [] records) {
		switch(menu) {
		case 1 : 
			// 플레이
			// 컴퓨터가 랜덤으로 숫자 생성
			int [] com = MethodBaseballEx01_1.createRandomArray(1, 9, 3);
			 MethodBaseballEx01_1.printArray(com);
			BaseballGame bg = new BaseballGame(com);
			int tryCount = 0;
			
			do {
			// 사용자가 숫자입력
				int []user = MethodBaseballEx01_1.scanArray(new Scanner(System.in),3);
				bg.setUser(user);
			// 판별
			bg.printResult();
			tryCount++;

			//	3S 종료
			} while(bg.getStrike() != 3);
			// 회수를 기록(최대 5등)
			// 5등 기준으로 회수가 동일한경우 머저 플레이한 사용자 기록을 유지
			// 기록된 최대 회수(꼴찌)를 찾는다
			int maxRecordCount = getMaxRecordCount(records);
			// 기록된 수를 찾음(꼴찌 순위)
			int maxRecordRank = getMaxRecordRank(records);
			//기록된 최대 회수가 내 내 횟수보다 크거나 기록된 수가 5보다 작으면 기록
			if(maxRecordCount > tryCount || maxRecordRank < 5) {
				addRecord(records,tryCount);
			}
			break;
		case 2 :
			//2. 기록 확인
			//등록된 5위까지의 기록을 확인
			printRecords(records);
			break;
		case 3 :
			break;
		default :
		}
		
	}
	private static void printRecords(Record[] records) {
		for(int i = 0; i<records.length; i++) {
			System.out.println(i+1+"위 ");
			if(records[i] != null) {
				records[i].print();
			}else {
				System.out.println();
			}
		}
		
	}
	private static void addRecord(Record[] records, int tryCount) {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력(예 : JIK) : ");
		String name = sc.next();
		Record r = new Record(tryCount, name);
		int index = 0;
		for(Record record : records) {
			if(record != null && record.getCount() <= tryCount){
				index++;
			}
		}
		for(int i = records.length-1; i > index; i--) {
			records[i] = records[i-1];
		}
		records[index] = r;
	}
	private static int getMaxRecordRank(Record[] records) {
		int rank = 0;
		for(Record record : records) {
			if(record !=null) {
				rank++;
			}
		}
		return rank;
	}
	private static int getMaxRecordCount(Record[] records) {
		int count = 9999999;
		for(Record record : records) {
			if(record !=null) {
				count = record.getCount();
			}
		}
		return count;
	}
	/**
	 * 기능 : 메뉴를 출력하는 메소드로, 마지막 메뉴는 엔터를 안침
	 * @param strs 콘솔에 출력할 메뉴들 
	 * */
	private static void printMenu(String ...strs) { // 가변인자
		for(int i = 0; i < strs.length; i++) {
//			System.out.println(strs[i]);
//			if(i != strs.length-1) { // strs가 마지막이 아니면 줄바꿈을 해줘라
//				System.out.println();
//			}
			// 조건선택 연산자를 쓰면 한줄로 끝낼 수 있다
			System.out.print(strs[i] + (i!= strs.length-1? "\n ":""));
		}
		
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
	 * 메뉴를 콘솔에서 입력받아 돌려주는 메소드
	 * @return 입력받은 메소드
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
	
}
