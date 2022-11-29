package day27;

public class ThreadEx04 {

	public static void main(String[] args) {
//		Thread t = new Thread(new Runnable(){
//
//			@Override
//			public void run() {
//				for(int i = 0; i < 10; i++) {
//					System.out.println("쓰레드 실행");
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}	
//			}
//			}
//			
//		});
		
		// 위에걸 람다식으로 구현
		Thread t = new Thread(() -> {
			for(int i = 0; i < 10; i++) {
				System.out.println("쓰레드 실행");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
		}
		});
		
		t.start();
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
