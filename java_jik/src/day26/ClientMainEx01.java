package day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMainEx01 {

	public static void main(String[] args) {
		Socket socket = null; // 소켓 먼저 만들고 시작. 예외때문에 null로 초기화
		Scanner sc = new Scanner(System.in);
		try {
			// 서버와 연결
			socket = new Socket();
			socket.connect(new InetSocketAddress(5001));
			System.out.println("[연결 완료]");
			// Output 스트림 연결(데이터 주고받기 위해서)
			OutputStream os = socket.getOutputStream(); // output을 소켓을 통해 만들어줌
			// 보내려는 문자열을 byte 배열로 변환
			String str = "안녕하세요"; //바이트변환 필요
			System.out.print("입력하세요 : ");
			String str2 = sc.nextLine();
			byte [] bytes = str2.getBytes("UTF-8"); // 문자열을 바이트 배열로 바꿔주는 메소드, 한글 안깨지려면 유티에프8
			// 전송
			os.write(bytes);
			os.flush(); // output쓰고 flush를 통해 밀어준다.
			
			//서버에서 문자열을 입력받아
			InputStream is = socket.getInputStream();
			byte [] bytes3 = new byte[1024]; // 1024는 최대 바이트 배열 크기
			int readCount = is.read(bytes3); // 읽어온 데이터를 bytes에 저장
			str = new String(bytes3, 0, readCount, "UTF-8"); 
			System.out.println(str);
			is.close(); // Input 스트림 객체 닫음
			os.close(); // Output 스트림 객체 닫음
		} catch (Exception e) { // 입력하고싶은 경고문이없으면 걍 Exception으로 통일
			e.printStackTrace();
		} 

	}

}
