package day05;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		/* 학생 5명의 국어 성적을 정수로 입력받고 출력하는 코드를 작성하라 
		 * 반복횟수 : i는 0부터 배열의 크기보다 작을때까지 1씩 증가
		 * 규칙성 : 콘솔에서 입력받은 정수를 배열 i번지에 저장 후 배열 i 번지에 있는 값을 출력
		 * */
		Scanner sc = new Scanner(System.in);
		int i, sum = 0;
		int [] arr = new int[5];
		
		for( i = 0; i < arr.length ; i++) {	
			System.out.print("학생" + (i+1) + "의 국어 점수를 입력하세요 : ");
				arr[i] = sc.nextInt();	
		}
		
		System.out.println();
		
		for(i = 0; i < arr.length ; i++) {
			System.out.println("학생" + (i+1) + "의 국어 점수는 : " + arr[i]);
		}
		
		/* 학생 성적의 평균을 구하는 코드를 작성하라
		 * 반복 횟수 : i는 0부터 배열이 크기가 작을떄 까지 1씩 증가(향상된 for문 이용 가능)
		 * 규칙성: sum에 배열 i번지에 있는 값을 누적
		 * 반복문 종료 후 : sum을 배열의 크기로 나눈 값을 출력(나누기 조심)*/
		
		for(i = 0; i < arr.length ; i++) {
			sum += arr[i];
		}
		
		System.out.println();
		System.out.println("학생들의 평균 점수는 : " + (double)sum / arr.length);
		
		//향상된 for문으로도 평균값을 낼 수 있다
		sum = 0;
		for(int tmp : arr) {
			sum += tmp;
		}
		System.out.println("학생들의 평균 점수는 : " + (double)sum / arr.length);
		sc.close();
	}
}
