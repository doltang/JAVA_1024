package day05;

public class WhileEx01 {

	public static void main(String[] args) {
		/* while문 문법
		 * 
		 * while(조건식){
		 * 		실행문;
		 * }
		 * 
		 * 초기화;
		 * while(조건식){
		 * 		실행문;
		 * 		증감식;
		 * }
		 * continue는 while문에서 조건식으로 이동(증감식도 실행문에 포함)
		 * 
		 * */
		int i;
		for(i = 1; i <= 5; i++) {
			System.out.println("hello world");
		}
		
		i = 1;
		while(i <= 5) {
			System.out.println("love world");
			i++;
		}
		
		i = 1;
		while(i++ <= 5) { // 상황에 따라서 코드를 간결하게 while문을 작성 할 수 있다, 특히 무한루프할떄
			System.out.println("love you");
		}
		
		/* while문에서는 조건식을 생략할 수 없다
		 * while문에서 무한루프를 만들려면 조건식에 true를 넣어주면 된다*/
		
		
		
		

	}

}
