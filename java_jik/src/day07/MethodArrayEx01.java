package day07;

public class MethodArrayEx01 {

	public static void main(String[] args) {
		// 배열에 있는 값을 출력하는 코드를 작성하라 메소드 이용
		int arr[] = {1, 3, 5, 10, 20};
		printArray(arr);

	}
	/* 기능 : 정수 배열이 주어지면 배열의 값을 한 줄에 출력하는 메소드
	 * 배개변수 : 정수 배열 => int arr[]
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printArray
	 * */
	public static void printArray(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
