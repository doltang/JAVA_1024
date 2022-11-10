package day14;

public class ThrowEx01 {

	public static void main(String[] args) {
		/* throws : 메소드가 실행됐을 때 발생할 수 있는 예외를 표시
		 * 			여러 개 가능
		 * 			RuntimeExceprion과 자식 예외 클래스들은 생략 가능
		 * 			그 외 예외 클래스들은 생략 불가능
		 * throw : 예외를 발생시킴. 조건에 따라 의도적으로 예외를 발생시킴
		 * 		   예외 객체를 던져줌. 
		 * 			throw를 통해 예외가 발생하면 메소드를 빠져 나옴
		 * */
		System.out.println(mod(1,0));
		// 메인에서 예외처리를 해줘야 호출했을때 빨간 줄이 안뜸
		try {			
			throwTest();
		}catch(Exception e) {
			System.out.println("예외 발생");
		}

	}
	public static int mod(int num1, int num2) throws ArithmeticException{ 
		return num1 % num2;
	}
	public static void throwTest() throws Exception { // 메인에게 예외처리하라고 던짐
		throw new Exception("예외발생"); // 메소드가 실행되자마자 예외 발생시킴 // 지금 이 클래스의 객체?
	}
}
