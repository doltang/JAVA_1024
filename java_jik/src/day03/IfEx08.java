package day03;

import java.util.Scanner;

public class IfEx08 {

	public static void main(String[] args) {
		/* 점수를 정수로 입력받아 입력받은 성적에 맞는 학점으 출력하는 코드를 작성하라
		 * A : 90 ~ 100
		 * B : 80 ~ 89
		 * C : 70 ~ 79
		 * D : 60 ~ 69
		 * F : 0 ~ 59
		 * 잘못된 성적 : 그 외*/
		
		Scanner scan = new Scanner(System.in);
		System.out.print("성적을 입력하세요 : ");
		int score = scan.nextInt();
		
		if (score >= 90 && score <= 100) {
			System.out.println(score + "는 A 입니다");
		}else if (score >= 80 && score < 90) {
			System.out.println(score + "는 B 입니다");
		}else if (score >= 70 && score < 80) {
			System.out.println(score + "는 C 입니다");
		}else if (score >= 60 && score < 70) {
			System.out.println(score + "는 D 입니다");
		}else if (score >= 0 && score < 60) {
			System.out.println(score + "는 F 입니다");
		}else {
			System.out.println("잘못된 성적입니다");
		}
		
		// 순서를 바꿔서 조건식 간결하게 만들기
		if (score > 100 || score < 0) {
			System.out.println("잘못된 성적입니다");
		}else if (score >= 90) {
			System.out.println(score + "는 A 입니다");
		}else if (score >= 80) {
			System.out.println(score + "는 B 입니다");
		}else if (score >= 70) {
			System.out.println(score + "는 C 입니다");
		}else if (score >= 60) {
			System.out.println(score + "는 D 입니다");
		}else {
			System.out.println(score + "는 F 입니다");
		}
		scan.close();
		
		
		

	}

}
