package day26;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx01 {

	public static void main(String[] args) {
		// 예외처리 필요
		InetAddress ia = null;
		
		try {
			ia = InetAddress.getByName("localhost");
			System.out.println(ia); //localhost/127.0.0.1
			ia = InetAddress.getByName("www.naver.com");//www.naver.com/223.130.200.104
			System.out.println(ia);
			ia = InetAddress.getLocalHost();//현재 내 pc 정보
			System.out.println(ia);//DESKTOP-TRSKSFK/192.168.10.24
			InetAddress []ias = InetAddress.getAllByName("www.naver.com");//네이버가 아이피가 여러개인지 확인
			for(InetAddress tmp : ias) { //향상된 for문으로 네이버 아이피가 여러개인것을 확인
				System.out.println(tmp);//www.naver.com/223.130.195.200
										//www.naver.com/223.130.200.107
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
