package day04;

public class ForSumEx01 {

	public static void main(String[] args) {
		/* 1부터 10사이의 짝수의 합을 구하는 코드를 작성하라 30 
		 * 반복횟수 : 
		 * 규칙성 :
		 * 반복문 종료 후 : */
		
		int i;
		int sum = 0;
		int sum2 = 0;
		int sum3 = 0;
		
		for(i = 2; i <= 10; i += 2) {
			sum += i;
		}
		System.out.println(sum);
		
		
		for(i = 1; 2 * i <= 10; i++) {
			sum2 += 2 * i;
		}
		System.out.println(sum2);
		
		
		for(i = 1; i <= 10; i++) {
			if(i % 2 == 0) {
				sum3 += i;
			}
		}
		System.out.println(sum3);
	}
	


}
