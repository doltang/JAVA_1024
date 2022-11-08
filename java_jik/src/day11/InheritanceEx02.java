package day11;

public class InheritanceEx02 {

	public static void main(String[] args) {
		KiaCar kcar = new KiaCar(4, "K5", 0xff000, "134가1234"); 
		kcar.powerOn();
		kcar.changeGear('D');
		for(int i = 0; i <30; i++) {
			kcar.accelerator();
		}
		// 자동차 상태 확인
		kcar.print();
		for(int i = 0; i <30; i++) {
			kcar.breaker();
		}
		kcar.changeGear('P');
		kcar.powerOff();
		
		HyundaiCar hcar = new HyundaiCar(4, "쏘나타", 0xff000, "134가1234");
		kcar.powerOn();
		kcar.changeGear('D');
		for(int i = 0; i <30; i++) {
			kcar.accelerator();
		}
		// 자동차 상태 확인
		hcar.print();
		for(int i = 0; i <30; i++) {
			hcar.breaker();
		}
		hcar.changeGear('P');
		hcar.powerOff();
	}

}
/* 자동차(Car) 클래스, 타이어(Tire)클래스, 기아 자동차(KiaCar) 클래스, 현대자동차(HyundaiCar) 클래스를 만들라
 * 자동차
 * 	- 타이어, 타이어 수, 차종, 색상, 번호, 전원(시동), 속력, 기어, 제조사
 * 	- 전원 켜기/끄기, 기어 변경, 속력업/다운
 * 타이어
 * 	- 제조사, 크기, 종류(스노우/일반), 상태
 * 	- 상태 출력 (굴러간다, 멈춘다)
 * 기아자동차
 * 	-제조사 : 기아, 자동차 상속
 * 현대자동차
 * 	-제조사가 현대, 자동차 상속
 * 
 * */

class Tire{
	public String company;
	public int size;
	public boolean isSnow;
	public boolean isStop;
	public void print() {
		if(isStop) {
			System.out.println("정지해있습니다");
		}else {
			System.out.println("굴러가는 중입니다");
		}
	}	
}

class Car{
	public Tire[] tires; // 자료형이 Tire클래스인 배열
	public int tireCount;
	public String type;
	public int color;
	public String carNum;
	public boolean power;
	public int speed;
	public char gear;
	public String company;
	
	public Car(int tireCount, String type, int color, String carNum, String company) {
		this.tireCount = tireCount <= 0 ? 4 : tireCount;
		this.type = type;
		this.color = color;
		this.carNum = carNum;
		this.company = company;
		this.gear = 'P';
		tires = new Tire[tireCount];
	}
	// 전원 켜기/끄기
	public void powerOn() { power = true;}
	public void powerOff() { power = false;}
	
	// 기어 변경
	public void changeGear(char gear) {
		if(gear == 'P' && speed == 0) {
			return;
		}
		this.gear = gear;
		
	}
	// 속력 업 다운
	public void accelerator() {
		speed += 1;
	}
	public void breaker() {
		speed = speed <= 0 ? 0 : speed - 1; 
	}
	// 상태 출력
	public void print() {
		System.out.println("전원 : " + (power ? "on" : "off"));
		System.out.println("속력 : " + speed);
		System.out.println("기어 : " + gear);
		System.out.println("차종 : " + type);
	}
}
// 부모 클래스의 생성자가 기본 생성자이면 자식 클래스에 부모 생성자 생략해도 되는데 
// 기본 생성자가 아니기 때문에 자식 클래스에 직접 부모생성자를 올려줘야 한다 (super이용)
class KiaCar extends Car{

	public KiaCar(int tireCount, String type, int color, String carNum) {
		super(tireCount, type, color, carNum, "기아");
	}
	public void hand() {
		System.out.println("트렁크가 수동입니다");
	}
	
}

class HyundaiCar extends Car{

	public HyundaiCar(int tireCount, String type, int color, String carNum) {
		super(tireCount, type, color, carNum, "현대");
	}
	public void auto() {
		System.out.println("트렁크가 자동입니다");
	}
}
	 
 