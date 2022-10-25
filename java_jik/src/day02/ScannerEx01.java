package day02;

import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // class들은 다 대문자로 시작
		// 스케너 설계    // 새로운 스캐너 (표준 입력)
		System.out.println("정수를 입력하세요 : ");// 콘솔 작업시 안내문자입력해주는것이 좋음
		int num = scan.nextInt();
		System.out.println(num);
		
		System.out.println("실수를 입력하세요 : ");
		double num2 = scan.nextDouble();
		System.out.println(num2);
		
		System.out.println("정수A와 정수B를 입력하세요 :");
		int A = scan.nextInt();
		int B = scan.nextInt();
		System.out.println(A);
		System.out.println(B);
		scan.close(); // 다 사용하면 닫아주기, 필수는 아니지만 해주는게 좋다
		 
	}

}
