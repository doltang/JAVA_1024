package day04;

public class ForPrimeNumberEx01 {

	public static void main(String[] args) {
		/* 정수 num가 소수인지 아닌지 판별하는 코드를 작성하세요
		 * 소수는 약수가 1과 자기 자신뿐인 수 => 약수의 개수가 2개인 수
		 * 1은 소수가 아님
		 * 반복횟수 : i는 1부터 num까지 1씩 증가
		 * 규칙성 : i가 num의 약수이면 약수(count)의 개수를 1 증가 시킨다
		 * 반복문 종료 후 count가 2이면 소수라고 출력하고, 2보다 크면 소수가 아님이라고 출력*/
		
		int num = 1235321;
		int count = 0;
		
		for(int i = 1; i <= num; i++) {
			if(num % i == 0) {
				count++;
			}
		}

		if(count == 2) {
			System.out.println(num + "은 소수다");
		}else {
			System.out.println(num + "은 소수가 아니다");
		}
	}

}
