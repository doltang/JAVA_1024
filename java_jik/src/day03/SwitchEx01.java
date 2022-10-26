package day03;

public class SwitchEx01 {

	public static void main(String[] args) {
		/* switch(식 또는 변수명){ boolean 이나 실수는 안됨
		 * case 값1: 	if(식 == 값1)
		 * 	실행문1;
		 * 	break
		 * case 값2:		else if(식 == 값2)
		 * 	실행문2
		 * 	break
		 * default:
		 * 	실행문3;
		 * }
		 * - case 옆에 있는 값들은 정수, 문자, 문자열만 올 수 있다.
		 * 	 변수명은 올 수 없다. 상수(리터럴 + final 변수)
		 * - break : switch문을 빠져 나가는 역할. break가 없으면 다음 case의 실행문으로 이동(다음 case의 값과 달라도 이동)
		 * - 여러 경우를 같이 처리하고싶으면
		 * 	case 값1, 값2, 값3: (if문에서 ||연산자를 연달아서 사용한것과 같다) 
		 * - default : else와 같음. 생략가능
		 * - switch문 사용하는 경우
		 * 	1. 식의 값이 제한적일 때 : %연산자 이용하는 경우
		 * 	2. 사용하는 변수 값이 제한적일 때 : 산술연산자를 이용한 계산 예제
		 * 	if보다 상대적으로 가독성이 있고 코드가 간결함*/
		int num = 4;
		switch(num % 2) {
		case 0: // num % 2의 결과가 0이면 아래 식을 동작
			System.out.println(num + "는 짝수");
			break;
		default:
			System.out.println(num + "는 홀수");
		}
		

	}

}
