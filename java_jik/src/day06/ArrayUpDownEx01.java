package day06;

import java.util.Scanner;

public class ArrayUpDownEx01 {

	public static void main(String[] args) {
		/* Up Down 게임을 3번 반복해서 플레이 하고,
		 * 각 게임당 맞춘 횟수를(몇 번만에 멎췄는지)배열에 저장하여 출력하는 코드 작성
		 * */
		int min = 1, max = 100, i, a;
		int size = 3;
		int win [] = new int [size];
		
		for(i = 0; i < win.length; i++) {
			int count = 0;
			int r = (int)(Math.random() * (max - min + 1) + min);
			System.out.println(r);		
			Scanner sc = new Scanner(System.in);		
			a = min - 1; // 이렇게 해주는 이유는 처음 한번은 무조건 실행하기 위해서 
			for ( ; r != a ; ) {
			System.out.print("숫자를 입력하세요 : ");
			a = sc.nextInt();
				if(a == r) {
					System.out.println("정답입니다");
					count++;
				}else if (a < r){
					System.out.println("UP");
					count++;
				}else{
					System.out.println("DOWN");
					count++;
				}
			}
			win[i] += count;
		}
		
		
		for(i = 0; i < win.length; i++) {
			System.out.println((i+1) + "번째 게임에선 "+ win[i] +"회 만에 맞췄습니다");
		}
		
		
		
		
		
	}

}
