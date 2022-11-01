package day07;

public class MethodEx03 {

	public static void main(String[] args) {
		/* 주어진 정수 num가 소수인지 아닌지 판별하는 코드를 작성하라
		 * 단, 메소드 이용*/
		int num = 1235321;
		System.out.println(primeNumber(num));

		printPrimeNumber(5);
		System.out.println(isPrimeNumber(5));// 얘가 가장 활용도가 높음!
	}
	// 메소드
	public static String primeNumber(int num) {
		int count = 0;
		
		for(int i = 1; i <= num; i++) {
			if(num % i == 0) {
				count++;
			}
		}

		if(count == 2) {
			return(num + "은 소수다");
		}else {
			return(num + "은 소수가 아니다");
		}
		
	}
	/* 기능 : 정수가 주어지면 소수인지 아닌지 출력하는 메소드
	 * 매개변수 : 정수 => int num
	 * 리턴타입 : 출력 => 없음 => void
	 * 메소드명 : printPrimeNumber
	 * */
	public static void printPrimeNumber(int num) {
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
	/* 기능 : 정수가 주어지면 소수인지 아닌지 알려주는 메소드
	 * 매개변수 : 정수 => int num
	 * 리턴타입 : 소수인지 아닌지 => boolean(A or B)
	 * 메소드명 : isPrimeNumber
	 * */
	public static boolean isPrimeNumber(int num) { // boolean은 값이 없으면 에러가 뜸
		int count = 0;
		//소수는 약수가 1과 자기 자신뿐인 수 => 약수의 개수가 2개인 수
		for(int i = 2; i < num; i++) { 
			//1과 num을 제외한 약수가 존재하면 false
			if(num % i == 0) {
				return false;
			}
		}

		return num <= 1 ? false : true; // for문에도, if문에도 걸쳐지지 않았는데 어떻게 판별? => 위의 내용을 품고 있다

	}
	

}
