package day26;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMainEx01 {

	public static void main(String[] args) {		
		ServerSocket serverSocket = null; // 예외처리때문에 일단 null로 초기화
		Scanner sc = new Scanner(System.in);
		final String encode = "UTF-8"; //서버는 모든 인코딩을 UTF-8로 하겠다
		
		try {
			serverSocket  =  new ServerSocket();
			serverSocket.bind(new InetSocketAddress(5001));
			while(true) {
				System.out.println("[연결 대기 중]");
				Socket socket =serverSocket.accept();
				InetSocketAddress isa 
					= (InetSocketAddress)socket.getRemoteSocketAddress();//연결 확인용(생략가능)
				System.out.println("[연결 수락 함]" + isa.getAddress());
				// 클라에서 데이터 받아오기
				InputStream is = socket.getInputStream();
				byte [] bytes = new byte[1024]; // 1024는 최대 바이트 배열 크기
				// 몇 개를 읽어와서 저장된 갯수를 확인용
				int readCount = is.read(bytes); // 읽어온 데이터를 bytes에 저장
				//0번지부터 내가 읽은 개수 만큼
				String str = new String(bytes, 0, readCount, encode); 
				System.out.println(str);
				
				//콘솔에서 문자열을 입력받아 
				OutputStream os = socket.getOutputStream();
				System.out.print("입력하세요 : ");
				String str2 = sc.nextLine();
				// 문자열을 바이트 배열로 바꿔주는 메소드, 한글 안깨지려면 UTF-8로 인코딩
				byte [] bytes2 = str2.getBytes(encode); 
				//클라이언트로 전송
				os.write(bytes2);
				os.flush();
				System.out.println("[전송 완료]");
				is.close(); // input 닫기
				os.close(); // output 닫기
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
