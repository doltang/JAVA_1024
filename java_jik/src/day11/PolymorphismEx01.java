package day11;

public class PolymorphismEx01 {

	public static void main(String[] args) {
//		connectToComputer(nMouse());
//		connectToComputer(new KeyBoard());
//		connectToComputer(new Speaker());
	}
	/* 매개변수의 다형성 => 메소드 오버로딩을 줄여줌
	 * 매개변수로 부모 클래스의 객체를 전달하여, 같은 부모를 가진 자식 클래스 객체를 매개변수로
	 * 활용할 수 있게 하는 것*/
	
	// 기기가 여러가지, 메소드 오버로딩이 여러 개로 불편.. -> 다형성 필요! 상속
//	public static void connectToComputer(Mouse obj) {
//		System.out.println("마우스와 연결 되었습니다");
//	}
//	public static void connectToComputer(KeyBoard obj) { 
//		System.out.println("키보드와 연결 되었습니다");
//	}
//	public static void connectToComputer(Speaker obj) { 
//		System.out.println("스피커와 연결 되었습니다");
//	}
	// 메소드
	public static void connectToComputer(UsbProduct obj) { // 부모 클래스의 객체를 매개 변수로!
		System.out.println(obj.type + "와 연결 되었습니다");
	}

}
// 부모 클래스
class UsbProduct{
	public String type;
}

//자식 클래스들
class Mouse extends UsbProduct{
	{	// 초기화 블럭
		type = "마우스";
	}
}
class KeyBoard extends UsbProduct{
	{	// 초기화 블럭
		type = "키보드";
	}
}
class Speaker extends UsbProduct{
	{	// 초기화 블럭
		type = "스피커";
	}
}