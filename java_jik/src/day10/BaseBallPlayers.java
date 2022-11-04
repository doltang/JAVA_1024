package day10;

import java.util.Scanner;

public class BaseBallPlayers {
	/* 필드 : 멤버변수
	 * ------------
	 * String name : 플레이어 이름
	 * int plyNum : 몇 번만에 맞췄는지?
	 * int score : 순위
	 */
	private String name;
	private int plyNum;
	private int score;
	
	/* 메소드
	 * -----------
	 * */
	
	/**
	 * 게임을 실행하는 메소드
	 * 기능 : 게임을 시작하고 진행하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음
	 * 메소드명 : runGame
	 * */
	public static void runGame(String[] args) {
		Scanner sc = new Scanner(System.in);
		int strike = 0, ball = 0;
		
		do{	// 1.랜덤으로 세개의 수 생성
			int min = 1; int max = 9; int size = 3;
			int [] com = createRandomArray(min, max, size);
			printArray(com);
			
			// 2. 사용자가 숫자를 입력
			System.out.println("입력 : ");
			int [] user = scanArray(sc, size);
			
			// 3. 판별
			// 	=> 스트라이크를 판별하는 기능
			strike = getStrike(com, user);
			
			//  => 볼을 판별하는 기능
			ball = getBall(com, user);
			
			printGame(strike, ball);
			// 2~3을 반복(3S가 될때까지)
			System.out.println("게임 종료");
			
			sc.close();
		}while(strike < 3);
		
	}
	/** 
	 * 기능 : 최소값과 최대값 사이의 숫자를 랜덤으로 생성하여 알려주는 메소드
	 * 매개변수 : 정수 => int min, max
	 * 리턴타입 : 정수 => int r
	 * 메소드명  random
	 * @param 최소값
	 * @param 최대값
	 * @return 랜덤 값
	 * */
	public static int random(int min, int max) {
		// 예외 처리 : min의 값이 max의 값보다 높을때 예외처리
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;			
		}
		return (int)(Math.random() * (max - min + 1) + min);	
	}
	
	
	/**
	 * 랜덤 수 배열
	 * 기능 : 최소값과 최대값 사이의 랜덤한 수를 size개 만들어 배열에 저장한 후,
	 * 저장된 배열을 반환하는 메소드
	 * 매개변수 : 정수 => int min, max, size
	 * 리턴타입 : 배열
	 * 메소드 명 : int [] createRandomArray
	 * @param 최소값
	 * @param 최대값
	 * @param 배열의 크기
	 * @return 정수 배열
	 * */
	public static int [] createRandomArray (int min, int max, int size) {
		// 예외 처리
		if(max - min + 1 <= size) {
			return null;
		}
		int arr [] = new int[size];
		for(int i = 0; i < size; i++) {
			int r = random(min, max);
			if(!contains(arr, r)) {
				arr[i] = r;
				i++;
			}
		}
		return arr;		
	}
	/** 랜덤값 중 중복 발견
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
	
	/** 
	 * 플레이어 측 배열 (숫자를 콘솔에 입력하는 배열)
	 * 기능 : Scanner가 주어지면 정수를 size개만큼 입력받아 배열에 저장하고, 
	 * 		 저장된 배열을 돌려주는 메소드
	 **/
	public static int[] scanArray(Scanner sc, int size) {
		if(size <= 0) {
			return null;
		}
		int [] arr = new int[size];
		for(int i = 0; i < size; i++){
			arr[i] = scan.nextInt();
		}
		return arr;
	}
	/** 
	 * 배열을 출력하는 메소드
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


	/** 
	 * strike 판별 
	 * 기능 : 두 배열을 비교해 일치하는 숫자(strike)의 개수를 알려주는 메소드
	 * 
	 * */

	/** 
	 * ball 판별
	 * 두 배열을 비교해 일치하는 숫자(ball)의 개수를 알려주는 메소드
	 * 
	 * 
	 * */

	/**
	 * 기능 : strike 와 ball의 개수가 주어지면 콘솔에 결과를 출력하는 메소드
	 * @param strike 스트라이크 개수
	 * @param ball 볼의 개수
	 * */
	/**
	 * 스코어를 (몇 회만에 3S를 만들었는지) 알려주는 메소드 */

	/** 플레이어의 정보(이름, 스코어)를 출력하는 메소드
	 * */

}