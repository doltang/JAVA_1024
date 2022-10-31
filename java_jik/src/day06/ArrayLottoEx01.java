package day06;

import java.util.Scanner;

public class ArrayLottoEx01 {

	public static void main(String[] args) {
		/* 로또 번호를 랜덤으로 생성하고, 당첨번호를 입력하여 몇 등 당첨 됐는지 출력하는 코드를 작성
		 * 숫자 범위 : 1~ 45
		 * 1등 : 6개
		 * 2등 : 5개 + 보너스 번호
		 * 3등 : 5개
		 * 4등 : 4개
		 * 5등 : 3개
		 * 로또 번호 : 번호 6개 + 보너스
		 * */
		
		int min = 1, max = 45; // 랜덤 수 범위
		int lotto [] = new int [6]; // 랜덤 수를 저장할 배열
		int count = 0; // 저장된 랜덤 수의 개수
		
		
		//랜덤으로 6개의 로또 번호 생성
		while(count < 6) {

			int r =(int)(Math.random() * (max - min + 1) + min);
			boolean isDuplicated = false;	
			for(int i = 0; i < count; i++) {
				if(lotto[i] == r) {
					isDuplicated = true;
				}	
			}
				
			if(isDuplicated) {
				continue;
			}	
			lotto[count] = r; // lotto[count++] = r;
			count++;
	
		}
		System.out.print("로또 번호 확인 : ");
		for(int tmp : lotto) {
			System.out.print(tmp + " ");
		}
		
		
		// 보너스 번호를 랜덤으로 생성(위에서 생성한 번호와 중복되지 않게) -> 어렵다..
			int b;
			while(true) {
				int r = (int)(Math.random() * (max - min + 1) + min);
				boolean isDuplicated = false;
				for(int i = 0; i < lotto.length; i++) {
					if(lotto[i] == r) {
						isDuplicated = true;
					}	
				}
					
				if(isDuplicated) {
					continue;
				}
				b = r;
				break;
			}
			System.out.println("보너스 : " + b);
		
		// 당첨 번호 6개를 입력 받음
		Scanner sc = new Scanner(System.in);
		int [] arr = new int [6];
		System.out.print("\n당첨 번호 입력 : ");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		// 일치하는 번호 개수를 구함 (보너스 번호 제외)
		int winCount = 0;
		for(int i = 0; i < lotto.length; i++) {
			for(int k = 0; k < arr.length; k++) {
				if(lotto[i] == arr[k]) {
					winCount++;
				}
			}
		}
		
		// 등수 판별
		switch(winCount) {
		case 6 : 
			System.out.println(winCount + "개 맞췄으므로 1등 입니다!");
			break;
		case 5 :
			boolean isDuplicated = false;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == b) {
					isDuplicated = true;
				}	
			}
			if(isDuplicated) {
				System.out.println(winCount + "개와 보너스를 맞췄으므로 2등 입니다!");
			}else {
				System.out.println(winCount + "개 맞췄으므로 3등 입니다!");
			}
			break;
		case 4 :
			System.out.println(winCount + "개 맞췄으므로 4등 입니다!");
			break;
		case 3 :
			System.out.println(winCount + "개 맞췄으므로 5등 입니다!");
			break;
		default :
			System.out.println(winCount + "개 맞췄으므로 낙첨 입니다!");			
		}
		
	
	
	
	
	
	}

}
