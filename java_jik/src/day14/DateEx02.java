package day14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx02 {

	public static void main(String[] args) throws ParseException  {
		Date date = new Date();
		System.out.println(date); // Sat Nov 12 00:01:02 KST 2022
		// Date를 원한는 패턴의 시간형태로 문자열로 변환(유용)
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // MM : 월 mm : 분
		String dateStr = format.format(date); 
		System.out.println(dateStr); //2022-11-10 05:19:35
		
		// 문자열을 Date로 변환
		String str = "2022-11-12 00:01:02"; // SimpleDateFormat("yyyy-MM-dd hh:mm:ss")와 형태를 맞춤
		Date date2 = format.parse(str); // add throws 해줘야함
		System.out.println(date2); //Sat Nov 12 00:01:02 KST 2022
		
	}

}
