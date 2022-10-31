package day06;

public class ArrayRandomEX02 {

	public static void main(String[] args) {
		/* 랜덤으로 1~9 사이의 숫자를 중복되지 않게 3개 생성하여 배열에 저장하는 코드를 작성하라
		 * */
		int min = 1, max = 9;
		int arr [] = new int [3];
		int count = 0, r;
		
		// 배열에 저장된 중복되지 않은수가 3개가 될 때까지 반복해야함
		while(count < 4) {
				// 랜덤한 수 생성
				r =(int)(Math.random() * (max - min + 1) + min);			
			// 배열에 저장된 수 중에서 랜덤한 수와 일치하는 숫자가 있는지 없는지 확인하여
			for(int i = 0; i < arr.length; i++) {
				// 배열에 저장된 숫자 개수만큼 확인
				if(arr[i] == r) {
				// 있으면 다시 처음으로,
					break;
				}else {	
				//없으면 배열에 저장하고, 저장된 개수 1 증가
					arr[i] += r;
					count++;
				}	
			}
		}
		
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		
		}
		
	}
}	



