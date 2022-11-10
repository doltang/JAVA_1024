package day14;

import java.util.Scanner;

public class ExceptionEx02 {

	public static void main(String[] args) {
		/* Scanner를 통해 정수를 입력 받아 입력받은 정수를 출력하는 코드를 작성
		 * 정수 대신 문자열을입력하면 예외가 발생하는데, 이 예외를 처리하는 코드를 작성하라
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = 0; // try catch문 바깥에서도 num쓰고 싶으면 바깥에서 선언을 해준다
		
		try {			
			num = sc.nextInt();
			System.out.println(num);
		}catch(Exception e) { // 잘모르면 걍 Exception 쓰셈모든 예외클래스의 조상
			System.out.println("정수를 입력하세요");
		}
		sc.close();
	}


}
