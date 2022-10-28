package day05;

import java.util.Scanner;

public class WhileCharEx01 {

	public static void main(String[] args) {
		// 문자를 입력받아 q이면 종료하고, 아니면 반복하는 코드를 작성하라
		char ch;
		Scanner sc = new Scanner(System.in);
		// break를 이용하여 무한루프를 이용해서 만들기
		while(true) {
			System.out.println("문자를 입력하세요(종료 q) : ");
			ch = sc.next().charAt(0);
			if(ch == 'q') {
				break;
			}
		}
		//ch의 초기값을 잘 설정하여 while문 조건식을 이용
		ch = 'a';
		while(ch != 'q') {
			System.out.println("문자를 입력하세요(종료 q) : ");
			ch = sc.next().charAt(0);
		}
		sc.close();

	}

}
