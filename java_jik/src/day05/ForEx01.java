package day05;

public class ForEx01 {

	public static void main(String[] args) {
		// 반복문을 사용할 때 나오는 실수
		
		int i;
		for(i = 1; i <= 5; i++); //반복문 옆에 ;을 넣으면 종결의 의미이다
		{
			System.out.println(i); // 6 // 반복문과 별개의 실행문
		}
		
		i = 5;
		if(i % 2 == 0); //마찬가지로 조건문 옆에 ;을 넣으면 종결의 의미이다
		{
			System.out.println("짝수"); // 짝수 // 조건문과 별개의 실행문
		}
		// 위에 있는게 if문이 아니기 때문에 else에 에러가 뜸
		/*else { 
			System.out.println("홀수");
		}
		*/
		
		// 조건문, 반복문은 실행운이 1줄이면 {}가 생략이 가능 // 이 경우 실수가 자주 일어남!
		for(i = 1; i <= 5; i++); 
			System.out.println(i); 
		
	}

}
