package day22;

public class ThreadEx01 {

	public static void main(String[] args) {
		// 클래스 이름으로 호출되는 메소드는 클래스 메소드 static이 붙었다.
		Thread t = Thread.currentThread();
		System.out.println("현재 쓰레드 명 : " + t.getName()); // main
		
		Thread01 t1 = new Thread01();
		t1.start(); // run을 직접 실행하는게 아니라 start라는 메소드를 실행
		for(int i = 0; i < 10000; i++) {
			System.out.print("|"); // 스레드가 동시에 왔다갔다 실행된다. (기준은 일정치 않음)
		}
	}

}

class Thread01 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.print("-"); // - 가 만개 찍히는 메소드
		}
	}
}