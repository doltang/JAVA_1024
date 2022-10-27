package day04;

public class NestingForStarEx01 {

	public static void main(String[] args) {
		/* *****
		 * *****
		 * *****
		 * *****
		 * *****
		 * */
		int col, row;
		
		// 반복문 하나로 하는 방법
		for(row = 1; row <= 5; row++) {
			System.out.println("*****"); // 갯수가 바뀌면 일일이 바꿔야 한다
		}
		
		System.out.println("------");
		
		// 이중 반복문으로 하는 방법
		for (row = 1; row <= 5; row++) { // row가 먼저 col이 나중에
			for (col = 1; col <= 5; col++) { // 갯수를 자유자재로 바꿀 수 있다
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
