package day05;

import java.util.Scanner;

public class ForUpDownEx01 {

	public static void main(String[] args) {
		// 랜덤한 수를 생성하여 해당 수를 맞추는 코드를 작성하라
		// 1~100 사이의 랜덤한 수를 맞추세요

		int min = 1, max = 100, i, a;
		int r = (int)(Math.random() * (max - min + 1) + min);
		System.out.println(r);
		
		Scanner sc = new Scanner(System.in);
		
		a = min - 1; // 랜덤값과 처음부터 일치하지 않기 위해
		
		// 랜덤 수를 맞추기
		// 반복 횟수 : 맞출때까지 => 랜덤 수 r과 입력한 수가 일치할때 까지
		// 규칙성 :
		for (; r != a ; ) {
			//- 1. 숫자를 입력하세요 : 안내문구출력
			System.out.print("숫자를 입력하세요 : ");
			//- 2. 정수를 입력 받음
			a = sc.nextInt();
			// -3. 입력받은 정수가 r과 같으면 정답입니다. 라고 출력
			if(a == r) {
				System.out.println("정답입니다");
			// 		입력받은 정수가 r보다 작으면 UP이라고 출력
			}else if (a < r){
				System.out.println("UP");
			// 		아니면 DOWN 이라 출력
			}else{
				System.out.println("DOWN");
			}
		}
		
		sc.close();


	}

}
