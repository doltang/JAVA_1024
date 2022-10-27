package day04;

public class BreakEx01 {

	public static void main(String[] args) {
		int i;
//		for(i = 1; i <= 5; i++) {
//			System.out.println("Hello World!");
//			break; // 쓰면 한번만 종료 -> 반복문의 의미가 없음
//		}
		
		//break를 만나면 증감식으로 가지 않고, 가까운(break가 포함되어 있는) 반복문을 빠져 나감
		for(i = 1; i <= 5; i++) {
			System.out.println("Hello World!");
			if(i == 3) {
				break; // 3번 반복후 종료
			}
		}

	}

}
