package day25;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/* 컴퓨터와 가위, 바위, 보를 하는 프로그램을 작성하라
 * - 사용자가 연속 3번 이길때까지 반복(비기거나 지면 다시)
 * 예 : 
 * 사용자 : 가위
 * 컴퓨터 : 보
 * 사용자가 이겼습니다.
 * 사용자 : 가위
 * 컴퓨터 : 주먹
 * 컴퓨터가 이겼습니다.*/
public class Ex04_3 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int win = 0;
		do { 
			System.out.print("사용자 : ");
			String user = sc.nextLine();
			String com = randomRPS();
			System.out.println("컴퓨터 : " + com);
			int res = compare(user, com);
			switch(res) {
			case 1 : 
				win++;
				System.out.println("사용자가 " + win + "번 이겼습니다.");
				break;
			case -1 :
				System.out.println("컴퓨터가 이겼습니다.");
				break;
			default :
				System.out.println("비겼습니다.");
			}
		}while(win != 3);
		System.out.println("3번 이겼습니다. 게임을 종료합니다.");
		sc.close();
		
	}
	private static int compare(String a, String b) {
		//비김을 처리
		if(a.equals(b)) 
			return 0;
		// a가 이기거나(1) 지거나(-1)
		switch(a) {
		case "가위" :
			return b.equals("보") ? 1 : -1;
		case "바위" :
			return b.equals("가위") ? 1 : -1;
		default : 
			return b.equals("바위") ? 1 : -1;
		}
	}
	private static String randomRPS() {
		List<String>list = Arrays.asList("가위", "바위", "보");
		int r = (int)(Math.random()*3);
		return list.get(r);
	}


	
	
}
