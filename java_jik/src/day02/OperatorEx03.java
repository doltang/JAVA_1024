package day02;

public class OperatorEx03 {

	public static void main(String[] args) {
		/* 산술 연산자: + - * / %
		 * 정수 산술연산자 정수 => 정수
		 * 실수 산술연산자 정수 => 실수
		 * 정수 산술연산자 실수 => 실수
		 * 실수 산술연산자 정수 => 실수 
		 * */
		int num1= 1, num2 = 2;
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
		System.out.println(num1 + " / " + num2 + " = " + ((double)num1 / num2));// 0으로 나옴. (0.5가 정답)-> 형변환 필요
		System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
	}

}
