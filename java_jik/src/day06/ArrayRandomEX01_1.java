package day06;

import java.util.Scanner;

public class ArrayRandomEX01_1 {

	public static void main(String[] args) {
		// 랜덤으로 1~9 사이의 숫자를 3개 생성하여 배열에 저장하는 코드를 작성하라
		
		int min = 1, max = 9;
		int arr [] = new int [3];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] += (int)(Math.random() * (max - min + 1) + min);
			System.out.print(arr[i] + " ");
		}
		
		// 정수를 입력 받아 랜덤한 수에 있는지없는지 확인해서 알려주는 코드를 작성하라
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		sc.close();
		int count = 0; // boolean isDuplicated = false; 라고 표현 할수도 있음
		for(int i = 0; i < arr.length; i++) {
			// i번지에 있는 값과 num이 같으면
			if(num == arr[i]) {
				// 중복 됬다고 저장
				count++; // isDuplicated = true;
				break;
			}
		}
		// 중복 됐으면 있다고 출력하고 아니면 없다고 출력
		if(count >= 1) {// if(isDuplicated)
			System.out.println("입력받은 숫자 " + num + "이 랜덤 숫자에 있습니다");
		}else {
			System.out.println("입력받은 숫자 " + num + "이 랜덤 숫자에 없습니다");
		}
		
	}

}
