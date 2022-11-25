package day25;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex04_3_1 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// 열거형을 적용한 가위바위보 게임
		int count = 0;
		do { 
			try {
				RPS com = randomRPS();
				System.out.println("컴퓨터 : " + com);
				System.out.print("사용자 : ");
				RPS user = RPS.valueOf(sc.next());
				State state = resultState(user, com);
				printState(state);
				count = state == State.WIN ? count+1 : 0;
			}catch(IllegalArgumentException e) {
				System.out.println("입력이 잘못됐습니다.");
			}
		}while(count != 3);
		sc.close();
		
	}
	private static void printState(State state) {
		switch(state) {
		case WIN :
			System.out.println("사용자가 이겼습니다.");
			break;
		case LOSE :
			System.out.println("컴퓨터가 이겼습니다.");
			break;
		default: 
			System.out.println("비겼습니다.");
		}
		
	}
	private static State resultState(RPS user, RPS com) {
		if(user == com)
			return State.DRAW;
		switch(user) {
		case 가위 :
			return com == RPS.보 ? State.WIN : State.LOSE;
		case 바위 :
			return com == RPS.가위 ? State.WIN : State.LOSE;
		default :
			return com == RPS.바위 ? State.WIN : State.LOSE;
		}
	}
	private static RPS randomRPS() {
		RPS [] rpss = RPS.values(); // 가위바위보를 배열에 번지에 넣고 객체로 만들어 줌
		int r = (int)(Math.random()*3);
		return rpss[r];
	}
	
	
}
