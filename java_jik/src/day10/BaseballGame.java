package day10;

import java.util.Arrays;

public class BaseballGame {
	private int []com;
	private int []user;
	private int strike;
	private int ball;

	public BaseballGame(int []com) {
		this.com = Arrays.copyOf(com, com.length); 
	}
	public void setUser(int []user) {
		this.user = Arrays.copyOf(user, user.length);
		calResult(); // 입력될때마다 스트라이크와 볼을 계산
	}
	private void calResult() {
		calStrike();
		calBall();
	}
	private void calStrike() {
		int count = 0;
		int size = com.length < user.length ? com.length : user.length; //예외 처리
		for(int i = 0; i <com.length; i++) {
			if(com[i] == user[i]) {
				count++;
			}
		}
		strike = count;
	}
	private void calBall() {
		int count = 0;
		for(int i = 0; i <com.length; i++) {
			for(int j = 0; j <user.length; j++) {
				if(com[i] == user[j] && i!=j) {
					count++;
				}
			}
		}
		ball = count;
	}
	/**
	 * 결과 출력*/
	public void printResult() {
		if(strike != 0) {
			System.out.println(strike + "S ");
		}
		if(ball != 0) {
			System.out.println(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.println("OUT");
		}
	}
	public int getStrike() {
		return strike;
	}
}
