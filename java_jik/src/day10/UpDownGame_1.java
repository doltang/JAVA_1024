package day10;

import java.util.Scanner;

public class UpDownGame_1 {
	private int com;
	private int user;
	
	public int getCom() {
		return com;
	}
	public void setCom(int com) {
		this.com = com;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	
	Scanner sc = new Scanner(System.in);
	
	/** 
	 * 기능 : 랜덤한 수를 생성하고 반환
	 * @param 최소값과 최대값*/
	public int random(int min, int max) {
		// 예외 처리
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		int r = (int)(Math.random() * (max - min + 1) + min);
		return r;
	}
	/**
	 * 기능 : 사용자의 숫자를 입력받고 반환한다
	 * @param 사용자에게 입력받을 정수
	 * @return 사용자에게 입력 받은 정수*/
	public int scanNum(Scanner sc) {
		int num = sc.nextInt();
		return num;
	}
	/**
	 *기능 : 랜덤 숫자와 입력한 숫자 판별하고 그에 따른 결과 출력하기 */
	public void runGame(int r, int user) {		
		do {
			if(r == user) {
				System.out.println("정답입니다");
			// 		입력받은 정수가 r보다 작으면 UP이라고 출력
				break;
			}else if (r > user ){
				System.out.println("UP");
			// 		아니면 DOWN 이라 출력
			}else{
				System.out.println("DOWN");
			}
		}while(true);
	}
	/**
	 * 기능 : 게임 결과를 출력한다 
	 * */
	public void printResult() {
		System.out.println();
	}
	
}
