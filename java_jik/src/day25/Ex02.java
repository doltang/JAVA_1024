package day25;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.Data;

public class Ex02 {

	public static void main(String[] args) {
		/* 정수를 5번 입력하여 배열/리스트에 저장하는 코드를 작성하라
		 * 정수가 홀수이면 그대로 저장, 정수가 짝수이면 -를 붙여서 저장*/
		Scanner sc = new Scanner(System.in);
		ArrayList<Numbers> list = new ArrayList<Numbers>();
		int num;
		int size = 5;
		for(int i = 0; i <= size; i++) {
			System.out.print("정수를 입력하세요 : ");		
			num = sc.nextInt();
			if(num % 2 != 0) {
				Numbers number = new Numbers(num);
				list.add(number);
			}else {
				num *= -1;
				Numbers number = new Numbers(num);
				list.add(number);
			}
		}
		for(Numbers tmp : list) {
			System.out.println(tmp);
		}

	}

}
@Data
class Numbers {
	private int num;
	
	public Numbers(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "num : " + num;
	}
	

}
