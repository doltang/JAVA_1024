package day27;

public class ThreadEx01 {

	public static void main(String[] args) {
		NewThread t = new NewThread();
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
class NewThread extends Thread{//스레드 클래스의 상속
	@Override //스레드의 run클래스를 오버라이드 해줘야만 동작이 유의미
	public void run() {
		for(int i = 0; i < 10; i++) {
		System.out.println(this.getName()+"쓰레드 실행");
		try {
			Thread.sleep(1000);//스레드 실행을 1초(1000밀리세컨드)마다 찍어줌
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
}