package day26;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain_Ex03 {

	/* 클라이언트가 연결을 요청하면 연결을 하고, 
	 * 연결이 종료되기 전까지
	 * 클라이언트가 전송한 문자열을 계속 출력한다 
	 * */
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		final String encode = "UTF-8";
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(5001));
			while(true) {
				System.out.println("[연결 대기 중]");
				Socket socket = serverSocket.accept();
				read(socket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// data 읽어오는 부분 메소드로 만들기
	public static void read(Socket socket) {
		// 여러 명이 동시접속 가능한 스레드
		Thread t = new Thread(()-> {
			try {
				//연결 주소 출력
				System.out.println("[연결 완료] : " + socket.getRemoteSocketAddress());
				
				//작업
				//클라에서 데이터 받아오기
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
}
