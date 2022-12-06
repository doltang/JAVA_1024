package day27;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Ex01_Client {

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket();
			System.out.println("[연결 시도 중]");
			socket.connect(new InetSocketAddress("localhost",5001));//내부 호스트 확인
			// socket.connect(new InetSocketAddress("서버 IP 주소",5001)); // 주소가 없으면 내 pc와 연결
			System.out.println("[연결 성공]");
			send(socket, "Student");
			recieve(socket);
		}catch(Exception e) {
			System.out.println("[연결 실패]");
		}

	}
	public static void recieve(Socket socket) {
		Thread t = new Thread(()-> {
			InputStream is = null;
			try {
				byte [] bytes = new byte[1024]; // 한번에 1키로바이트, 한번에 500자 정도 가져오겠다.
				is = socket.getInputStream();
				while(true) {
					int readCount = is.read(bytes);// 읽어온 개수
					if(readCount == -1) { //읽어온 문자가 없을때(클라가 안보냈을때, 연결이 끊겼을때)
						break;
					}
					String str = new String(bytes, 0, readCount, "UTF-8");
					int index = str.indexOf(",");
					if(index == -1)
						continue;
					String name = str.substring(0,index);
					String message = str.substring(index + 1);
					//받아서 내꺼에만 찍으면 되는 클라
					//내가 입력한 채팅 표시
					System.out.println(name + ">" + message);
				}
				is.close();
			}catch(Exception e) {
				
			}finally {
				// 읽기 위해서 대기하다 예외가 발생하면 socket을 닫아줌
				//=> 클라에서 접속을 종료 함
				try {
					if(socket != null && !socket.isClosed())
						socket.close();
					System.out.println("[클라이언트 종료]");
				} catch (IOException e1) {
					System.out.println("클라이언트 소켓 닫기 실패");
				} 					
			}
		});
		t.start(); //스레드 시작
	}
	public static void send(Socket socket, String name) {
		Scanner sc = new Scanner(System.in);
		Thread t = new Thread(() -> {
			try {
				OutputStream os = socket.getOutputStream();
				while(true) {
					String str = sc.nextLine();
					if(str.equals("exit")) {
						break;
					}
					str = name + "," + str;
					byte [] bytes = str.getBytes("UTF-8");
					os.write(bytes);
					os.flush();
				}
			}catch(Exception e) {
				
			}finally {
				System.out.println("종료");
				try {
					if(socket != null && !socket.isClosed())
						socket.close();					
				}catch(Exception e) {
					System.out.println("클라이언트 소켓 종료 실패");
				}
			}
		});
		t.start();
	}
}
