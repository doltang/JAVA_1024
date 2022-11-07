package day03;

public class ForEx01 {

	public static void main(String[] args) {
		/* for(1. 초기화; 2.5.8.조건식; 4.7.증감식){
		 * 	   3.6.실행문;
		 * }
		 * 1. 초기화 : 조건식 또는 실행문에서 사용하는 변수를 초기화
		 * 			  for문 시작 시 1번만 실행, 생략 가능
		 * 2. 조건식 : 거짓이면 반복문을 종료, 참이면 반복문을 실행
		 * 			  생략 가능, 생략하면 무조건 참
		 * 4. 증감식 : 조건식에서 사용하는 변수를 증가/감소시켜서 반복문 횟수를 결정
		 * 			  생략 가능
		 * - 초기화 + 조건식 + 증감식 => 반복 횟수를 결정
		 * - 실행문 : 규칙적인 작업
		 * 코드의 길이를 줄이기 위해 반복문을 씀
		 * 특별한 상황이 아니면 증가식으로 규칙을 활용하는것이 일반적
		 * */
		int i = 1;
		for(i = 1; i <= 5; i++) {
			System.out.println("Hello world");
		}
		// while로 변경
		while(i <= 5) {
			System.out.println("Hello world");
			i++;
		}

	}

}
