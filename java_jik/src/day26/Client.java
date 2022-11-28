package day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	private Socket socket;

	// 밖에서 소켓을 주면 해당하는 소켓을 필드와 연결
	public Client(Socket socket) {
		this.socket = socket;
	}
	
	public void read() { // 필드로 갖고 있으므로 매개변수 소켓을 지워준다
		// 여러 명이 동시접속 가능한 스레드
		Thread t = new Thread(()-> {
			try {	
				InputStream is = socket.getInputStream();
				while(true) {
						byte [] bytes = new byte[1024];
						int readCount = is.read(bytes);
						if(readCount == -1)
							break;
						String str = new String(bytes, 0 , readCount, "UTF-8");	
						System.out.println(str);
					}					
					is.close();
				} catch (Exception e) {
					System.out.println("[클라이언트가 접속을 종료했습니다]");
				}					
			});
			t.start();
	}
	public void send () {
		Scanner sc = new Scanner(System.in);
		Thread t = new Thread(()-> {
			try {
				OutputStream os = socket.getOutputStream();
				while(true) {
					System.out.print("입력하세요 : ");
					String str = sc.nextLine();
					if(str.equals("exit"))
						break;
					byte [] bytes = str.getBytes("UTF-8");
					os.write(bytes);
					os.flush();
				}
				os.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
		t.start();
	}
}
