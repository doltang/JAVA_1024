package day10;

import java.util.Scanner;

public class BaseballManager_1 {

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
		int menu, plyerNum = 0;
		// 반복문을 통해 메뉴를 출력
		do{
			// 메뉴를 출력
			printMenu();
			// 메뉴를 선택(입력)
			menu = selectMenu();
			//선택한 메뉴에 맞는 기능 실행
			plyerNum = runMenu(menu, plyerList, plyerNum);
			
		}while(menu != 3);
	
		
	}
	// 메뉴 메소드 모음 -----------------------------
	/**
	 * 메뉴를 출력하는 메소드
	 * 기능 : 메뉴 출력
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 :printMenu
	 * */
	public static void printMenu() {
		System.out.println("-----메뉴-----");
		System.out.println("1. 플레이"); 
		System.out.println("2. 기록확인");
		System.out.println("3. 종료");
		System.out.println("-------------");
		System.out.print("메뉴를 선택하세요 : ");
	}
	
	/**
	 * 메뉴를 선택(입력)하는 메소드
	 * 기능 : 콘솔에서 정수(메뉴)를 입력받고 알려주는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 정수 => int sc.next
	 * 메소드명 : selectMenu
	 * @return 입력받은 정수(메뉴)
	 * */
	public static int selectMenu() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	/**
	 * 선택한 메뉴에 맞는 기능을 실행하는 메소드
	 * 기능 : 선택한 메뉴에 맞는 기능을 실행
	 * 매개변수 : int menu, BaseBallPlayers [] plyerList, int PlyerNum
	 * 리턴타입 : 
	 * @param 선택한 메뉴, 이름과 스코어 정보가 들어있는 플레이어 리스트, 현재까지 플레이한 사람들의 수와 순서
	 * */
	public static int runMenu(int menu,  BaseBallPlayers [] plyerList, int PlyerNum) {
		
	}
}
