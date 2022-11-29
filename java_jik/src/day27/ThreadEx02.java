package day27;

public class ThreadEx02 {

	public static void main(String[] args) {
		//Runnable runnable = new NewThread2();
		//Runnable의 구현클래스의 객체를 스레드 생성자의 매개변수로 받았다.
		Thread t = new Thread(new NewThread2());
		t.start(); // 아무것도 일어나지 않았다.. 동작은 되었지만
		Thread thisThread = Thread.currentThread();
		for(int i = 0; i < 20; i++) {
			System.out.println(thisThread.getName()+"쓰레드 실행");
			try {
				Thread.sleep(400);//스레드 실행을 1초(400밀리세컨드)마다 찍어줌
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}//main

}//class
class NewThread2 implements Runnable{//runnable 인터페이스
	@Override 
	public void run() {
		for(int i = 0; i < 10; i++) {
		System.out.println("쓰레드 실행");//this.getName은 못씀. 오로지 Run메소드만 있기 때문
		try {
			Thread.sleep(1000);//스레드 실행을 1초(1000밀리세컨드)마다 찍어줌
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
}