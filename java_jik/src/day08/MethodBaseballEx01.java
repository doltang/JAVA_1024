package day08;

import java.util.Scanner;

public class MethodBaseballEx01 {

	public static void main(String[] args) {
		/* 1 ~ 9 사이 중복되지 않은 3개의 숫자가 랜덤으로 생성,
		 * 생성된 숫자를 맞추는 게임
		 * 규칙 
		 * - 숫자가 같은 자리에 있으면 Strike
		 * - 숫자가 있지만 다른 자리에 있으면 Ball
		 * - 일치하는 숫자가 하나도 없으면 Out
		 * 예시(랜덤 숫자 : 5, 9, 8)
		 * 입력 : 1 2 3
		 * out
		 * 입력 : 4 5 6
		 * 1B
		 * 입력 : 7 8 9
		 * 2B
		 * 입력 : 7 9 8
		 * 2S
		 * 입력 : 7 9 5
		 * 1S 1B
		 * 입력 : 5 9 8
		 * 3S
		 * 게임 종료
		 * */
		Scanner sc = new Scanner(System.in);
		int min = 1, max = 9, size = 3;

			//1.랜덤으로 세개의 수 생성
			// => createRandomArray
			int [] randomNum = createRandomArray(min, max, size);
			int []user = new int[size];
			printArray(randomNum);
		while(getStrike(randomNum, user) != 3) {
			//2.사용자가 숫자를 선택
			System.out.print("입력 번호 : ");
			for(int i = 0; i < user.length; i++) {
				user[i] = sc.nextInt();
			}

			//3.판별
			// => 스트라이크를 판별하는 기능
			// => countLotto를 이용하여 일차하는 개수 - 스트라이크 개수 => 볼의 개수
			int sRank = getStrike(randomNum, user);
			int bRank = getBall(randomNum, user);
			// 2~3을 반복(3S가 될때까지)
			// 결과 출력
			printStrike(sRank);
			printBall(bRank, sRank);
			printOut(bRank, sRank);
			
			System.out.println();
		}
		sc.close();

	}
	

	/* 기능 : sRank도 bRank도 0일때 Out을 출력하는 메소드
	 * 매개변수 : 볼 개수, 스트라이크 개수 int bRank, int sRank
	 * 리턴타입 : void
	 * 메소드명 : printOut
	 * */
	
	public static void printOut(int bRank, int sRank) {
		if(bRank == 0 && sRank == 0) {
			System.out.println("Out");
		}
	}
	
	
	/* 기능 :  sRank와 bRank이 주어졌을때 볼의 개수를 출력하는 메소드
	 * 매개변수 : 볼 개수, 스트라이크 개수 int bRank, int sRank
	 * 리턴타입 : void
	 * 메소드명 : printBall
	 * */
	
	public static void printBall(int bRank, int sRank) {
		int sMinusB = (bRank-sRank);
		switch(bRank) {
		case 3 : 
			if(sRank > 0 ) {
				if(sMinusB != 0) {
				System.out.print(sMinusB + "B");
				}
			}else {
				System.out.print("3B");
			}
			break;
		case 2 :
			if(sRank > 0 ) {
				if(sMinusB != 0) {
					System.out.print(sMinusB + "B");
					}
				System.out.print(sMinusB + "B");
			}else {
				System.out.print("3B");
			}
			System.out.print("2B");
			break;
		case 1 :
			if(sRank > 0 ) {

			}else {
				System.out.print("3B");
			}
			System.out.print("1B");
			break;
		case 0 :

		}
	}
	/* 기능 : 등수가 주어지면 등수를 콘솔에 출력하는 메소드
	 * 매개변수 : 등수
	 * 리턴타입 : 일치하는 숫자의 개수 => 정수 => int
	 * 메소드명 : printRank
	 * */
	
	public static void printStrike(int sRank) {
		switch(sRank) {
		case 3 : 
			System.out.print("3S ");
			break;
		case 2 :
			System.out.print("2S ");
			break;
		case 1 :
			System.out.print("1S ");
			break;
		case 0 :

		}
	}
	/* 기능 : 랜덤 번호와 입력번호가 주어지면 Strike 결과를 알려주는 메소드
	 * 매개변수 : 로또 번호, 입력 번호 => int []lotto, int bonus, int[]user
	 * 리턴타입 : 등수 => 정수 => int
	 * 메소드명 : getStrikeRank
	 * */
	public static int getStrike(int randomNum[], int user[]) {
		int count = countStrike(randomNum, user);
		switch(count) {
		case 3 : 
			return 3;
		case 2 :	
			return 2;
		case 1 :
			return 1;
		default :
			return 0;			
		}

	}
	/* 기능 : 랜덤 번호와 입력번호가 주어지면 Ball 결과를 알려주는 메소드
	 * 매개변수 : 로또 번호, 입력 번호 => int []lotto, int bonus, int[]user
	 * 리턴타입 : 등수 => 정수 => int
	 * 메소드명 : getBallRank
	 * */
	public static int getBall(int randomNum[], int user[]) {
		int count = countBall(randomNum, user);
		switch(count) {
		case 3 : 
			return 3;
		case 2 :	
			return 2;
		case 1 :
			return 1;
		default :
			return 0;			
		}
		

	}
	
	/* 기능 : 주어진 두 배열에서 일치하는 숫자의 개수를 알려주는 메소드
	 * 매개변수 : 두 배열 => int randomNum[], int user[]
	 * 리턴타입 : 일치하는 숫자의 개수 => 정수 => int
	 * 메소드명 : countStrike
	 * */
	public static int countStrike(int randomNum[], int user[]) {
		// 예외 처리
		if(randomNum == null || user == null) {
			return 0;
		}
		int strikeCount = 0;
		for(int i = 0; i < randomNum.length; i++) {
			if(randomNum[i] == user[i]) {
				strikeCount++;
			}
		}
		return strikeCount;
	}
	/* 기능 : 주어진 두 배열에서 일치하는 숫자의 개수를 알려주는 메소드
	 * 매개변수 : 두 배열 => int randomNum[], int user[]
	 * 리턴타입 : 일치하는 숫자의 개수 => 정수 => int
	 * 메소드명 : countBall
	 * */
	public static int countBall(int randomNum[], int user[]) {
		// 예외 처리
		if(randomNum == null || user == null) {
			return 0;
		}
		int ballCount = 0;
		for(int tmp : randomNum) {
			if(contains(user, tmp)) {
				ballCount++;
			}
		}
		return ballCount;
		
	}
	/* 기능 : 배열 출력
	 * */
	public static void printArray(int arr[]) {
		// 예외 처리 : 배열의 기본값은 null, null이 들어왔을 경우 예외처리
		if(arr == null) {
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	/* 기능 : 최소값과 최대값 사이의 랜덤한 수를 size개 만들어 배열에 저장한 후, 
	 * 	저장된 배열을 반환하는 메소드
	 * 매개변수 : 최소값, 최대값, 만들 개수 => int min, int max, int size
	 * 리턴타입 : 랜덤한 수가 저장된 배열 => int []
	 * 메소드명 : createRandomArray
	 * */
	public static int [] createRandomArray (int min, int max, int size) {
		// 예외 처리 : 정해진 범위 밖의 숫자가 왔을때 배열에 넣는 걸 거부하는 예외 처리
		if(max - min + 1 <= size) {
			return null;
		}
		int arr[] = new int[size];
		for(int i = 0; i < arr.length; ) {		
			int r = random(min, max);
			if(!contains(arr, r)) {
				arr[i] = r;
				i++;
			}
		}
		return arr;
	}
	
	/* 기능 : 최소값과 최대값 사이의 랜덤한 수를 생성하여 알려주는 메소드
	 * 매개변수 : 최소값, 최대값, 만들 개수 => int min, int max
	 * 리턴타입 : 랜덤한 정수 => int 
	 * 메소드명 : random
	 * */
	public static int random (int min, int max) {
		// 예외 처리 : min의 값이 max의 값보다 높을때 예외처리
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random() * (max - min + 1) + min);			
	}
	/* 기능: 중복 발견
	 * */
	public static boolean contains (int []arr, int num) {
		// 예외 처리 : 배열이 비어있거나 배열에 길이가 0과 같을때 예외처리
		if(arr == null || arr.length == 0) {
			return false;
		}
		for(int tmp : arr) {
			if(num == tmp) {
				return true;
			}
		}
		return false;
	}

}
