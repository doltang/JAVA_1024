package day11;

public class ClassUpCastingEx01 {

	public static void main(String[] args) {
		/* 자식 클래스인 kiaCar 객체를 부모 클래스인 Car 객체에 저장 : 업 캐스팅
		 * 업 캐스팅은 자동으로 동작
		 * */
		//Car car = new KiaCar(4, "K5", 0x00ff00, "123허1234");
		// car.print();
		// 하나의 객체로 여러 타입의 클래스를 관리할 수 있다 -> 다형성
		//Car 배열을 이용하여 여러 종류의 자동차들을 관리할 수 있다
		Car [] carList = new Car[5]; // 부모 클래스, 5대의 차를 주차할 수 있는 주차장
		carList[0] = new KiaCar(4, "K5", 0x00ff00, "123허1234"); // 자식 클래스
		carList[1] = new HyundaiCar(4, "쏘나타", 0x00ff00, "123허1234"); // 자식 클래스
		
		for(Car tmp : carList) { // 같은 자료형인 Car를 이용해 tmp 선언
			System.out.print(tmp + " "); // 값이 이상..
		}
	}

}
