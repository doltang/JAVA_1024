package day07;

public class MethodEx02 {

	public static void main(String[] args) {
		// 7단을 출력하는 코드를 작성하라. 단, 메소드를 이용할 것
		int dan = 7;
		printMultiTable1(dan);
		System.out.println("------------");
		printMultiTable2(dan, 1, 5);
		System.out.println("------------");
		for(int i = 1; i <= 5; i++) {
			System.out.println(dan + " x " + i + " = " + multi(dan, i));
		}
	}
	
	/* 기능 	  : 단이 주어지면 해당하는 단을 콘솔에 출력하는 메소드
	 * 매개변수 : 단 => int num (항상 자료형을 앞에 붙어줘야함!)
	 * 리턴타입 : void
	 * 메소드명 : printMultiTable1
	 * */
	public static void printMultiTable1(int num) {
		//구현;
		for(int i = 1; i <= 9; i++) {
			System.out.println(num + " x " + i + " = " + num*i);
		}
	}
	/* 기능 	  : 단과 시작정수, 끝정수가 주어지면 해당하는 단을 
	 * 			단 X 사작숫자에서 단 x 끝숫자까지 콘솔에 출력하는 메소드
	 * 매개변수 : 단, 시작숫자, 끝 숫자 => int num, int start, int end (항상 자료형을 앞에 붙어줘야함!)
	 * 리턴타입 : void
	 * 메소드명 : printMultiTable2
	 * */
	public static void printMultiTable2(int num, int start, int end) {
		//구현;
		for(int i = start; i <= end; i++) {
			System.out.println(num + " x " + i + " = " + num*i);
		}
	}
	/* 기능 	  : 두 정수가 주어지면 두 정수의 곱을 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2 (항상 자료형을 앞에 붙어줘야함!)
	 * 리턴타입 : 두 정수의 곱
	 * 메소드명 : multi
	 * */
	public static int multi(int num1, int num2) {
		//구현;
		return num1*num2;
	}
}
