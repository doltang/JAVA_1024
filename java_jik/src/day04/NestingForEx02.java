package day04;

public class NestingForEx02 {

	public static void main(String[] args) {
		/* 2부터 100 사이의 소수를 출력하는 코드를 작성하라 
		 * 반복회수 : num를 2부터 100까지 1씩 증가
		 * 규칙성 : num가 소수이면 num를 출력
		 * 		반복횟수 : i는 1부터 num까지 1씩 증가
		 * 		규칙성 : num를 i로 나누었을 때 나머지가 0과 같다면 count를 1 증가
		 * 		반복문 종료 후 : count가 2이면 num를 출력
		 * 반복문 종료 후 : 없음*/
		
		int num, i;
		int count = 0;
		
		for(num = 2; num <= 100; num++) { // 2 부터 100까지의 숫자가 1씩 증가
			// 2부터 100까지의 숫자(num)를 1부터 100(i)을 대입해
			// 하나하나 계산하여 약수(나누었을때 0이 되게하는 수)를 구한다
			for(i = 1, count = 0; i <= num; i++) { // count를 초기화 해주지 않으면 결과가 2밖에 안나옴
				if(num % i == 0) {
					count++; // 
				}
			}if(count == 2) {
				System.out.print(num + " ");
			}
		}
		



	}

}
