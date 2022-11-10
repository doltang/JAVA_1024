package day14;

public class WrapperEx01 {

	public static void main(String[] args) {
		int num1 = 1;
		Integer num2 = num1; // boxing : int => integer
		// num2 = null; // classdls integer는 null을 저장할 수 있음, 기본 자료형은 불가능하기 때문
		int num3 = num2; // unboxing : integer => int (null 조심!)
		// num2인 Integer 객체를 int로 언박싱하는 경우, num2가 null일 수 있어서 조심해야 함
		System.out.println(num3);
		
		// 문자열을 정수로
		String str = "1234";
		System.out.println(str + 1); // "12341"
		int num4 = Integer.parseInt(str);
		System.out.println(num4 + 1); // 1235
		
		// 정수를 문자열로 1
		int num5 = 123;
		String str2 = Integer.valueOf(num5).toString(); // int -> Integer -> toString(오브젝트 메소드)
		System.out.println(str2 + 1); //1231
		// 정수를 문자열로 2
		String str3 = ""+ num5; // 문자열 + 정수 = 문자열 // 이 방법이 더 쉽다
		System.out.println(str3 + 1); //1231
	}

}
