package day14;

import java.util.Date;

public class DateEx01 {

	public static void main(String[] args) {
		/* Date 클래스
		 * - 시스템으로부터 시간 정보를 가져와서 다루게 하는 클래스
		 * - Date() : 현재 시간 정보를 가져옴 (기본 생성자 사용)
		 * - Date(정수) : 1970년도 1월 1일 0시 0분 0초를 기준으로 흐른 시간을 가져옴
		 * 				정수 밀리세컨드 흐른 시간
		 *  */
		
		Date date1 = new Date(); // 매개변수 없음 -> 현재 시간
		System.out.println("현재 시간 : " +  date1);
		Date date2 = new Date(1000); // 1000 -> 1초, 9시가 뜨는 이유는 우리나라가 기준시간보다 9시간 지나있기 때문
		System.out.println("기준 시간 : " +  date2);
		//System.currentTimeMillis() : 현재 시스템 시간을 밀리세컨드로 환산
		// 현재 시간부터 1주일 지난 뒤의 시간을 출력하는 코드
		long nowMillis = System.currentTimeMillis(); 
		int week = 7 * 24 * 60 * 60 * 1000; // 일주일은 7일, 하루 24시간, 1시간은 60분, 1분은 10초, 1초는 1000밀리세컨드
		Date date3 = new Date(nowMillis + week);
		System.out.println("일주일 뒤 : " + date3);

	}

}
