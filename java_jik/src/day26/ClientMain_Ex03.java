package day26;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain_Ex03 {

	/* 서버에 연결을 요청하고, 
	 * 연결이 되면 exit를 입력하기 
	 * 전까지 문자열을 서버에
	 * 전송함*/
	public static void main(String[] args) {
		Socket socket = null;
		
		final String encode = "UTF-8";
		
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(5001));
			System.out.println("[연결 완료]");
			send(socket);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// data 보내는거 메소드로 만들기
	public static void send(Socket socket) {
		Scanner sc = new Scanner(System.in);
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
	}
}
