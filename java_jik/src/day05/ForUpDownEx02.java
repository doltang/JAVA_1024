package day05;

import java.util.Scanner;

public class ForUpDownEx02 {

	public static void main(String[] args) {
		/* 랜덤한 정수를 맞추는 up sown 게임
		 * 예시 : 1~100 사이의 랜덤한 수를 맞추세요
		 * 정답입니다.
		 * 더 하시겠습니까? (y / n) : n
		 * 프로그램을 종료합니다*/
		
		/* 반복횟수 : 없음
		 * 규칙성 : 
		 *  -1. 게임 한판 함
		 *  -2. 더 하시겠습니까?(y/n)를 출력
		 *  -3. 문자 하나를 입력
		 *  -4. 입력받은 문자가 n이면 종료*/
		
		int min = 1, max = 100, i, a;
		
		for ( ; ; ) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			System.out.println(r);		
			Scanner sc = new Scanner(System.in);		
			a = min - 1; // 이렇게 해주는 이유는 무조건 한번은 실행시키기 위해서!
			for ( ; r != a ; ) {
			System.out.print("숫자를 입력하세요 : ");
			a = sc.nextInt();
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
			System.out.println("더 하시겠습니까?(y / n)");
			char ch = sc.next().charAt(0);
			if(ch == 'y') {
				continue;
			}else if(ch == 'n') {
				System.out.println("프로그램을 종료합니다");
				break;
			}else {
				System.out.println("잘못된 입력입니다");//  더하시겠습니까? 로 올라가는 건 없는지?
			}
			
		}

		
	}
}


