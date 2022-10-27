package day04;

public class BreakPrimeNumberEx01 {

	public static void main(String[] args) {
		// break문을 이용하여 소수를 판별하는 예제
		// 6 => 5, 4, 3 (처음만나는 약수를 파악해서 소수를 판별)
		// 7 => 6, 5, 4, 3, 2, 1
		
		int num = 6;
		int i;
		for(i = num - 1; i >= 1; i--) {
			if(num % i == 0) {
				break;
			}
		}
		if(i == 1) {
			System.out.println(num + "는 소수");
		}else {
			System.out.println(num + "는 소수 아님");
		}
	}

}
