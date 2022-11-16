package day18;

import java.util.Scanner;

public class EnumEx02 {

	public static void main(String[] args) {
		/* 오늘의 요일을 영어로 입력 받아 한글로 출력하는 코드를 작성하라/
		 * 예
		 * 요일 : WEDNESDAY
		 * 수요일*/
		Scanner sc = new Scanner(System.in);
		System.out.print("What day is it?(대문자로 입력) : ");
		String day = sc.next();
		switch(day) {
		case "MONDAY" :
			System.out.println("월요일");
			break;
		case "TUESDAY" :
			System.out.println("화요일");
			break;
		case "WEDNESDAY" :
			System.out.println("수요일");
			break;
		case "THURSDAY" :
			System.out.println("목요일");
			break;
		case "FRIDAY" :
			System.out.println("금요일");
			break;
		case "SATURDAY" :
			System.out.println("토요일");
			break;
		case "SUNDAY" :
			System.out.println("일요일");
			break;
		default :
			System.out.println("잘못된 입력입니다.");
		}
		
		// 열겨형으로 바꾸기, default 사용 블가 (예외 처리 시 switch문 바깥에서 둘러싸기 때문)
		try {
			Week week = Week.valueOf(day); // day를 열거형으로 변환
			switch(week) {
			case MONDAY : System.out.println("월요일"); break;
			case TUESDAY : System.out.println("화요일"); break;
			case WEDNESDAY : System.out.println("수요일"); break;
			case THURSDAY : System.out.println("목요일"); break;
			case FRIDAY : System.out.println("금요일"); break;
			case SATURDAY : System.out.println("토요일"); break;
			case SUNDAY : System.out.println("일요일"); break;
			}
		}catch(Exception e){
			System.out.println("잘못 입력했습니다.");
		}
	}

}
enum Week{
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}


