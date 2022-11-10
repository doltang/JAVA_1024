package day14;

public class TryCatchEx01 {

	public static void main(String[] args) {
		/* try{
		 *		예외가 발생할 수 있는 코드
		 *}catch(예외클래스1 e) { // 타입 변환이 가능하면 실행 // 항상 부모를 아래 쪽에다가
		 *		예외 처리;
		 *}catch(예외클래스2 e) {
		 *		예외 처리;
		 *}finally{
		 *		실행문;
		 *}
		 *- try, catch는 필수
		 *- catch는 1개 이상
		 *- catch가 여러 개인 경우 위에 있는 예외 클래스는 아래 클래스의 조상 클래스가 오면 안된다
		 *	예 : 예외 클래스 1에 RuntimeExceprion(부모 클래스)이 오고,
		 *		 예외 클래스 2에 ArithmeticException(자식 클래스)이 오면 안됨
		 *- finally는 선택(없거나 1개 있거나)
		 **/
		exception();
	

	}
	// exception method
	public static void exception() {
		try {
			System.out.println(1/0); // 예외 발생!
		}catch(ArithmeticException e) {
			System.out.println("0으로 나누면 안됩니다.");
			return; // 메소드를 빠져나가려다가..
		}catch(RuntimeException e) {
			System.out.println("실행 시 예외가 발생했습니다");	
		}finally {
			System.out.println("메소드 종료"); // return이 실행되도 출력이 
		}
		System.out.println("안녕!"); // return이 실행되면 출력 안함
	}
}
