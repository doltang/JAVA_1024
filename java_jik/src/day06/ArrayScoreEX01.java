package day06;

import java.util.Scanner;

public class ArrayScoreEX01 {

	public static void main(String[] args) {
		/* 5명 학생의 국어, 영어, 수학 성적을 저장하기 위한 배열을 만들고, 
		 * Scanner를 이용하여 입력받아, 국어평균, 영어평균, 수학 평균을 구하는 코드를 작성하라
		 * */
		
		Scanner sc = new Scanner(System.in);
		int kor[] = new int [5];
		int eng[] = new int [5];
		int math[] = new int [5];
		int i = 0, sum1 = 0, sum2 = 0, sum3 = 0;
		
		System.out.println("----국어----");
		//국어 점수
		for(i = 0; i < kor.length; i++) {
			System.out.print("학생" + i + "의 국어 점수를 입력 하세요 : ");
			kor[i] = sc.nextInt();
		}
		
		for(i = 0; i < kor.length ; i++) {
			sum1 += kor[i];
		}
		
		System.out.println("----영어----");
		
		//영어 점수
		for(i = 0; i < eng.length; i++) {
			System.out.print("학생" + i + "의 영어 점수를 입력 하세요 : ");
			eng[i] = sc.nextInt();
		}
		
		for(i = 0; i < eng.length ; i++) {
			sum2 += eng[i];
		}
		
		System.out.println("----수학----");
		//수학 점수
		for(i = 0; i < math.length; i++) {
			System.out.print("학생" + i + "의 수학 점수를 입력 하세요 : ");
			math[i] = sc.nextInt();
		}
		
		for(i = 0; i < math.length ; i++) {
			sum3 += math[i];
		}
		
		System.out.println();
		System.out.println("학생들의 평균 국어점수는 : " + (double)sum1 / kor.length);
		System.out.println("학생들의 평균 영어점수는 : " + (double)sum2 / eng.length);
		System.out.println("학생들의 평균 수학점수는 : " + (double)sum3 / math.length);
		
	}

}
