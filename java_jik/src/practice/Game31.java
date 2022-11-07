package practice;

public class Game31 {
	
	public void tt() {
		System.out.println("바보");
	}
	/**
	 * 게임을 하는 메소드*/
	public void runGame (int min, int max, int size) {
		// 31이 나올때까지 게임 반복
		int [] num = makeArray(min, max, size);
		for(int tmp : num) {
			System.out.print(tmp + " ");
		}
		System.out.println(num);
		for(int i = 0; i < num.length;) {
			// 컴퓨터가 랜덤 1-3개 출력 (숫자는 순차적)
			// 랜덤으로 1-3개의 인덱스를 가지는 배열 만들기
			int r = random(1, 3);
			int [] com = new int [r];
			for(int j = 0; j < com.length; j++) {
				com[j] = num[j];
			}
			for(int tmp : com) {
				System.out.print(tmp + " ");
			}
		}
			// 사용자가 몇 개의 숫자를 부를지 입력
			// 마지막에 3을 부르는 사람이 진다
			// 게임을 더 할 건지 물어본다 (y/n) :y = 게임이 계속 된다 n = 메뉴로 돌아간
		
			// 총 세번 게임을 해서 사용자가 몇 번 이기고 컴퓨터가 몇 번 이기는지 기록
	}
	/**
	 * 배열을 생성하고 순차적으로 값을 채워넣는 메소드
	 * @param 최소값
	 * @param 최대값
	 * @param 사이즈*
	 * @return 배열 (게임할때 쓰는 숫자의 범위를 담은)*/
	public int [] makeArray (int min, int max, int size) {
		int [] arr = new int[size];
		for(; min <= max; min++) {
			arr[min] = min;
		}
		return arr;
	}
	/**
	 * 랜덤한 숫자를 생성하는 메소드
	 * @param 최소값
	 * @param 최대값*/
	private int random(int min, int max) {
		// 예외 처리 : min과 max의 값을 반대로 입력했을 경우, 제대로 돌려주기
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random() * (max - min + 1)+ min);
	}
}
