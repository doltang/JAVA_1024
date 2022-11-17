package day19;

public class ChaningEx01 {

	public static void main(String[] args) {
		/* 체이닝 : .이 연달아 나와 메소드를 연속해서 호출
		 * 앞에 있는 메소드 리턴 값에 이어서 메소드를 호출*/ 
		String str = "Hello";
		// 앞에서 작업한 리턴값에 기능을 붙이는 것이므로 앞에 객체가 와야 한다
		// .은 객체에 붙이는 것. charAt()은 객체가 아니라서 뒤에 .이 못붙는다
		/* 문자열 str에 2번지부터 부분 문자열을 추출한 후, 0번지 문자를 가져옴
		 * 0번지 문자를 가져왔기 때문에 charAt()다음에는 .을 통해 메소드를 호출할 수 없음*/
		System.out.println(str.substring(2).charAt(0));
		System.out.println(toString(100).charAt(0));
		// print()는 리턴타입이 없기 때문에 체이닝을 쓸 수 없다
		// 리턴타입이 일반 변수(int, char등)인 경우도 체이닝을 쓸 수 없다
		print(10); // void는 . 못붙임
	}
	
	public static String toString(int num) {
		return num + "";
	}
	public static void print(int num) {
		System.out.println(num);
	}
}
