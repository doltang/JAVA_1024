package day06;

public class ArrayRandomEX01 {

	public static void main(String[] args) {
		// 랜덤으로 1~9 사이의 숫자를 3개 생성하여 배열에 저장하는 코드를 작성하라
		
		int min = 1, max = 9;
		int r = (int)(Math.random() * (max - min + 1) + min); // 랜덤수가 다 동일..
		int rarr[] = {r, r, r};

		
		int arr [] = new int [3];
		for(int i = 0; i < arr.length; i++) {
			arr[i] += rarr[i];
		}
		
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
	}

}
