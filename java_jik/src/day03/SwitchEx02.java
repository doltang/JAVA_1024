package day03;

import java.util.Scanner;

public class SwitchEx02 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력 받아 산술 연산 결과를 도출하는 코드를 switch문으로 작성하라
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("두 정수와 문자를 입력하세요 (예: 1 + 2) : ");
		int num1 = scan.nextInt();
		char ch = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		switch(ch) {
		case '+':
			System.out.println("" + num1 + ch + num2 + " = " + (num1 + num2));
			break;
		case '-':
			System.out.println("" + num1 + ch + num2 + " = " + (num1 - num2));
			break;
		case '*':
			System.out.println("" + num1 + ch + num2 + " = " + (num1 * num2));
			break;
		case '/':
			System.out.println("" + num1 + ch + num2 + " = " + ((double)num1 / num2));
			break;
		case '%':
			System.out.println("" + num1 + ch + num2 + " = " + (num1 % num2));
			break;
		default:
			System.out.println("잘못된 입력입니다");
		}
		
		
		
		
		
		
		
		scan.close();
		

	}

}
