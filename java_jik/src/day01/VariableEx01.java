package day01;

public class VariableEx01 {

	public static void main(String[] args) {
		/* - 변수 선언 
		 * 자료형 변수명;
		 * 자료형 변수명 = 초기값;
		 * - 자료형 종류
		 */
		
		// 기본 자료형
		boolean isEven = false;  // 짝수 입니까? =  홀수
		char operator = '+'; // 연산자 // 캐릭터는 무조건 한 글자! ' ' 따옴표만 가능, 빈 문자 불가능
		int age = 30; // 정수 
		float pi1 = 3.1415f; // float은 접미사 F나 f를 반드시 붙여야 한다.
		double pi2 = 3.1415; // 실수는 보통 double로 쓴다
		// 참조형 문자열 
		String str = "Hi"; // 무조건  " ", 한글자 여도  " ", 빈문자열도 가능
		String str1 = "+";
		String str2 = " ";
		
		// 사과의 개수를 저장하기 위한 변수를 선언해보기
		int appleCount;
		
		// 학생 평균 성적을 저장하기 위한 변수 선언해보기
		double scoreAvg; 
		
		int num;
		// double num; // duplicate local variable num: 중복된 변수를 선언. 자료형이 달라도 불가.
		int NUM; // 대소문자 구분
		int num1;
		// int 1num; // 숫자로 시작할 수 없다
		int _num, $num;
		// int !num2; // _와 $가 아닌 특수문자는 사용불가
		// int int; // 예약어 사용불가
		
		/*관례 : 안지켜도 되지만 많은 개발자들이 지킴
		 *  - 변수는 소문자로 시작
		 *  - 카멜 표기법을 따라서 두번째 글자부터 첫글자를 대문자로
		 *  - 클래스와 인터페이스는 대문자로 시작
		 * */
	}

}
