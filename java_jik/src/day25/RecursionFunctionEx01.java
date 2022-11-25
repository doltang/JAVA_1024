package day25;

public class RecursionFunctionEx01 {

	/* 재귀함수 : 함수의 실행문으로 자신을 다시 호출하는 함수
	 * - 잘못 작성하면 스택 오버 플로우가 발생할 수 있음*/
	public static void main(String[] args) {
		//print(10);// 스택 오버 플로우 발생
		/* 양수 정수 n!(엔 팩토리얼)을 구하는 코드를 작성하라
		 * n! = 1*2*3* ...*n 누적 곱 
		 * n*(n-1)!
		 * n*(n-1)*(n-2)!
		 * 0!은 1이다
		 * */
		System.out.println(factorial(5));
	}
	public static long factorial(int num) {
		if(num < 0) {
			throw new RuntimeException("음수는 팩토리얼을 구할 수 없습니다.");
		}
		if(num == 1 || num == 0) { // 탈출 조건
			return 1;
		}
		return num * factorial(num - 1);
	}
	public static void print (int num) {
		System.out.println(num);
		print(num); // 자신을 호출
	}
}
