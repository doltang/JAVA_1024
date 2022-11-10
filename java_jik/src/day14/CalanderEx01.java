package day14;

import java.util.Calendar;

public class CalanderEx01 {

	public static void main(String[] args) {
		/* Calendar 클래스 : 날짜와 관련된 클래스
		 * get()을 통해서 년도, 월, 일, 시, 분, 초등 다양한 정보를 가져옴
		 * 매개변수를 지정하면 매개변수에 맞는 값을 돌려줌
		 * */
		
		Calendar cal = Calendar.getInstance(); // new 가 아닌 Calendar 클래스의 필드를 호출해서 통해 객체를 생성
		//System.out.println(cal);
		cal.add(Calendar.YEAR, 1); // 지금 시간으로부터 1년 후 
		cal.add(Calendar.MONTH, -1); // 지금으로부터 한달 전
		int year = cal.get(Calendar.YEAR); // 글씨가 기울어져 있다 = 상수 , 글씨가 굵다 = 클래스
		// int year2 = cal.get(1); // 같은 결과지만 뭘가져오는지 헷갈릴수 있으므로 비추
		System.out.println( year + "년");
		int month = cal.get(Calendar.MONTH) +1;// month는 0부터 시작해서 +1해준다
		System.out.println(month + "달");
		int date = cal.get(Calendar.DATE);
		System.out.println(date + "달");
		int hour = cal.get(Calendar.HOUR_OF_DAY);// 14시, hour은 2시로 나옴
		System.out.println(hour + "시");
		int minute = cal.get(Calendar.MINUTE);
		System.out.println(minute + "분");
		int sec = cal.get(Calendar.SECOND);
		System.out.println(sec + "초");
		

	}

}
