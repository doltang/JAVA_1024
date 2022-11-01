package day07;

public class MethodEx05 {

	public static void main(String[] args) {
		// 1부터 10까지 합을 구하는 코드를 작성하라, 메소드로
		int start = 1, end = 10;
		System.out.println(sum(end, start));

	}
	/* 기능 : 시작숫자부터 끝숫자 사이의 모든 정수를 더하고, 더한 결과를 알려주는 메소드
	 * 매개변수 : 시작숫자, 끝숫자 => int start, int end
	 * 리턴타입 : 더한 결과 => 정수 => int
	 * 메소드명 : sum
	 * */
	public static int sum(int start, int end) {
		int sum = 0; // 메소드 명과 같아도 괜춘
		// 두 수를 바꾸는 코드 (내가 한 버전)
		if(start < end) {
			for(int i = start ; i <= end; i++) {
				sum += i;
			}
			return sum;
		}else {
			for(int i = end ; i <= start; i++) {
				sum += i;
			}
			return sum;
		}
	}
}
