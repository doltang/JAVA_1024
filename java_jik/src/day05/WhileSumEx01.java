package day05;

public class WhileSumEx01 {

	public static void main(String[] args) {
		/* 1부터 10사이의 홀수의 합을 구하는 코드를 while문으로 작성하라 */
		int i = 1;
		int sum = 0;
		
		while(i <= 10) {
			if (i % 2 != 0) {
				sum += i;
			}
			i++;
		}
		System.out.println("1부터 10까지의 홀수" + sum);
		
		// 코드 더 간결하게 작성법
		i = 0;
		sum = 0;
		while(++i <= 10) {
			if (i % 2 != 0) {
				sum += i;
			}
		}
		System.out.println("1부터 10까지의 홀수" + sum);
	}

}
