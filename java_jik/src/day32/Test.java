package day32;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws ParseException {
		//Date date = new Date();
		String str = "2021년 02월 15일 11시 30분 50초";
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");

		Date dateStr1 = format.parse(str);
		System.out.println(dateStr1);
		String dateStr = format.format(dateStr1);
		System.out.println(dateStr);
	}

}
