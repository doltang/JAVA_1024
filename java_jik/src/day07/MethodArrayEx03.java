package day07;

public class MethodArrayEx03 {

	public static void main(String[] args) {
		// 배열에 정수 num이 있는지 없는지 확인하는 메소드
		int num = 2;
		int arr[] = {2, 3, 4, 10};
		if(contains(num, arr)) { // 중복을 발견할때 for 중첩 대신 쓰일 수 있음
			System.out.println(num + "는 배열에 있습니다");
		}else {
			System.out.println(num + "는 배열에 없습니다");
		}
	}
	/* 기능 : 배열에 정수 num이 있는지 없는지 알려주는 메소드
	 * 배개변수 : 정수, 배열 => int num, int [] arr
	 * 리턴타입 : 있는지 없는지 => boolean
	 * 메소드명 : contains
	 * */
	public static boolean contains (int num, int []arr) {
		for(int tmp : arr) {
			if(num == tmp) {
				return true;
			}
		}
		return false;
	}
}
