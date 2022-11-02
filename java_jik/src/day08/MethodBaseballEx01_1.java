package day08;

import java.util.Scanner;

public class MethodBaseballEx01_1 {

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


		//1.랜덤으로 세개의 수 생성
		// => createRandomArray
		int min = 1, max = 9, size = 3;
		int [] com = createRandomArray(min, max, size);
		printArray(com);
		Scanner scan = new Scanner(System.in);

		int strike = 0, ball;
		do {
			//2.사용자가 숫자를 선택
			System.out.println("입력 : ");
			int [] user = scanArray(scan, size);
			//3.판별
			// => 스트라이크를 판별하는 기능
			// => countLotto를 이용하여 일차하는 개수 - 스트라이크 개수 => 볼의 개수
			strike = getStrike(com, user);
			ball = getBall(com, user);
			
			printGame(strike, ball);
			// 2~3을 반복(3S가 될때까지)
			System.out.println("게임 종료");
			scan.close();
		}while(strike < 3);
			// 결과 출력

	}
	/**
	 * 기능 : strike 와 ball의 개수가 주어지면 콘솔에결과를 풀력하는 메소드
	 * @param strike 스트라이크 개수
	 * @param ball 볼의 개수*/
	public static void printGame(int strike, int ball) {
		if(strike != 0) {
			System.out.println(strike + "S ");
		}
		if(ball != 0) {
			System.out.println(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.println("OUT");
		}
	}
	/**
	 * 기능 : 두 배열이 주어지면 같은 번지에 있는 수를 비교하여 일치하는 숫자들이 몇개 있는지
	 * 알려주는 메소드
	 * @param arr1 int [] : 첫번째 배열 
	 * @param arr2 int [] : 두번째 배열
	 * @return 같은 번지에서 일치하는 숫자들의 개수
	 * */
	public static int getStrike(int []arr1, int arr2[]) {
		// 예외 처리
		if(arr1 == null || arr2 == null) {
				return 0;
		}
		// 예외 처리
		int size = arr1.length < arr2.length ? arr1.length : arr2.length;
		
		int strike = 0;
		for(int i = 0; i < size; i++) {
				if(arr1[i] == arr2[i]) {
					strike++;
				}
		}
		return strike;
	}
	
	/**
	 * 기능 : 두 정수 배열이 주어지면 같은 숫자들중에서 번지가 서로 다른 숫자들의 개수를 
	 * 알려주는 메소드
	 * @param arr1 int [] : 첫번째 배열 
	 * @param arr2 int [] : 두번째 배열
	 * @return 같은 숫자들 중에서 번지가 서로 다른 숫자들의 개수
	 * */
	public static int getBall(int []arr1, int []arr2) {
		// 예외 처리
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		int ball = 0;
		int strike = getStrike(arr1, arr2);
		for(int num : arr1) {
			if(contains(arr2, num)) {
					ball++;
			}
		}
		return ball - strike;
	}
	
	/**
	 * 기능 : Scanner가 주어지면 정수를 size개만큼 입력받아 배열에 저장하고, 
	 * 		 저장된 배열을 돌려주는 메소드
	 * 매개변수 : Scanner, size개 => Scanner scan, int size
	 * 리턴타입 : 정수 배열 => int []
	 * 메소드명 : scanArray
	 * @param scan Scanner
	 * @param 입력받을 정수의 개수
	 * @return 입력받은 값들이 저장된 배열 
	 * */
	public static int[] scanArray(Scanner scan, int size) {
		if(size <= 0) {
			return null;
		}
		int [] arr = new int[size];
		for(int i = 0; i < size; i++){
			arr[i] = scan.nextInt();
		}
		return arr;
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
