package day05;

import java.util.Scanner;

public class ArrayEx06 {

	public static void main(String[] args) {
		/* 정수 4개짜리 배열을 생성한 후, 4자리 숫자를 입력받아 배열에 저장하는 코드를 작성하라
		 * 1234
		 * 0번지에 1
		 * 1번지에 2
		 * 2번지에 3
		 * 3번지에 4
		 * */
		
		// 4자리 정수를 입력
		Scanner sc = new Scanner(System.in);
		int size = 4;
		System.out.println(size + "자리 정수를 입력하세요 : ");
		int num = sc.nextInt();
		int num2 = sc.nextInt();
		/*반복횟수 : 4번 => 
		 * num에서 1의 자리를 추출 				1234에서 4를 추출
		 * 추출된 1의 자리를 배열에 저장			arr[3] = 4
		 * => % 10
		 * num에서 1의 자리를 제거하여 num에 저장  1234에서 123을 num에 저장
		 * => / 10
		 * 반복문 종료 후 : 배열에 있는 값을 출력
		 * */
		
		int [] arr = new int[size];
		
		for(int i = size - 1; i >= 0; i--) {
			arr[i] = num % 10; // 4, 3, 2, 1
			num = num / 10; // num /=  10; // num = 1234, 123, 12
		}
		for(int tmp : arr) {
			System.out.print(tmp);
		}
		System.out.println();
		// while문을 활용한 버전 
		int i = size - 1;
		while(num2 > 0) {
			arr[i--] = num2 % 10;
			num2 = num2 / 10;
		}
		for(int tmp : arr) {
			System.out.print(tmp);
		}
		
		
		

	}

}
