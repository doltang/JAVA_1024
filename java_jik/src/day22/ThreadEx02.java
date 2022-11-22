package day22;

public class ThreadEx02 {

	public static void main(String[] args) {
		// 클래스 이름으로 호출되는 메소드는 클래스 메소드 static이 붙었다.
		Thread t = Thread.currentThread();
		System.out.println("현재 쓰레드 명 : " + t.getName()); // main
		
		//Thread t2 = new Thread (new Thread02());//객체가 runnable인터페이스의 메소드를 가져감
		// 클래스를 만들지 않고 람다식을 이용해 바로 메소드를 이용할 수 있다
		Thread t2 = new Thread(() -> {
			for(int i = 0; i<10000; i++)
				System.out.print("-");
		});
		t2.start(); // run을 직접 실행하는게 아니라 start라는 메소드를 실행
		for(int i = 0; i < 10000; i++) {
			System.out.print("|"); // 스레드가 동시에 왔다갔다 실행된다. (기준은 일정치 않음)
		}
	}

}

//class Thread02 implements Runnable{
//	@Override
//	public void run() {
//		for(int i = 0; i < 10000; i++) {
//			System.out.print("-"); // - 가 만개 찍히는 메소드
//		}
//	}
//}