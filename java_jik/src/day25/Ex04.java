package day25;

import java.util.Random;
import java.util.Scanner;

public class Ex04 {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/* 컴퓨터와 가위, 바위, 보를 하는 프로그램을 작성하라
		 * 예 : 
		 * 사용자 : 가위
		 * 컴퓨터 : 보
		 * 사용자가 이겼습니다. 더 하겠습니까? (y/n) : y
		 * 사용자 : 가위
		 * 컴퓨터 : 주먹
		 * 컴퓨터가 이겼습니다. 더 하겠습니까? (y/n) : n*/
		int min = 1, max = 3;
		runGame(min, max);
		
	}
	private static void runGame(int min, int max) {
		String answer = "a";
		String scissor = "가위";
		String rock = "바위";
		String paper = "보";
	
		do {
			System.out.print("사용자 : ");
			String user = sc.nextLine();
			String com = randomCom(min, max);
			 // 잘못된 입력 시
			if(!(user.equals(scissor) || user.equals(rock) || user.equals(paper))) {
				System.out.println("잘못된 입력입니다.(가위,바위,보 중 하나를 입력해주세요)");
				continue;
			}	
			
			System.out.println("컴퓨터 : " + com);
			
			if(user.equals(com)) {
				System.out.print("비겼습니다. 더 하시겠습니까? (y/n) : ");
				answer = sc.nextLine();
				moreGame(answer, min, max);
				
			}else if((user.equals("가위") && com.equals("바위")) 
					|| (user.equals("바위") && com.equals("보"))
					|| (user.equals("보") && com.equals("가위"))) {
				System.out.print("컴퓨터가 이겼습니다. 더 하시겠습니까? (y/n) : ");
				answer = sc.nextLine();
				moreGame(answer, min, max);
			}else {
				System.out.print("사용자가 이겼습니다. 더 하시겠습니까? (y/n) : ");
				answer = sc.nextLine();
				moreGame(answer, min, max);
			}
		}while(answer != "n");
			
		
	}

	private static void moreGame(String answer, int min, int max) {
		switch(answer) {
		case "y" :
			runGame(min, max);
			break;
		case "n" :
			System.out.println("게임을 종료합니다.");
			return ;
		default : 
			System.out.println("잘못된 입력입니다.");
			System.out.print("더 하시겠습니까? (y/n) : ");
			answer = sc.nextLine();
			moreGame(answer, min, max);
			
		}
		
	}
	public static String randomCom(int min, int max) {
		//예외 처리
		if(max < min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		
		Random r = new Random();
		int rNum = r.nextInt(max - min + 1) + min;
		
		if(rNum == 1) {
			return "가위";			
		}else if(rNum == 2) {
			return "바위";
		}else {
			return "보";
		}
	}
}
