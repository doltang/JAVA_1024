package day06;

import java.util.Scanner;

public class ArrayScoreEX01_1 {

	public static void main(String[] args) {
		/* 5명 학생의 국어, 영어, 수학 성적을 저장하기 위한 배열을 만들고, 
		 * Scanner를 이용하여 입력받아, 국어평균, 영어평균, 수학 평균을 구하는 코드를 작성하라
		 * */
		
		int stdCount = 5;
		int kor[] = new int[stdCount];
		int eng[] = new int[stdCount];
		int math[] = new int[stdCount];
		
		// 학생 별 국어, 영어, 수학 성적을 입력
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < stdCount; i++) {
			System.out.print("학생" + (i + 1) + "의  국어, 영어 수학 성적을 입력 : ");
			kor[i] = sc.nextInt();
			eng[i] = sc.nextInt();
			math[i] = sc.nextInt();
		}

		// 과목별 합(총점)
		double korSum = 0, engSum = 0, mathSum = 0;
		for(int i = 0; i < stdCount; i++) {
			korSum += kor[i];
			engSum += eng[i];
			mathSum += math[i];
		}
		
		// 과목별 평균
		System.out.println("국어 성적의 평균 : " + korSum / stdCount);
		System.out.println("영어 성적의 평균 : " + engSum / stdCount);
		System.out.println("수학 성적의 평균 : " + mathSum / stdCount);
		
		// 학생별 평균
		double stuSum = 0;
		for(int i = 0; i < stdCount; i++) {
			stuSum = kor[i] + eng[i] + math[i];
			System.out.println("학생" + (i+1) + "의 평균은 : " + stuSum / 3);
		}
		
		
		
	}
}
