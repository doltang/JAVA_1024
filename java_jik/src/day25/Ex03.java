package day25;

public class Ex03 {

	public static void main(String[] args) {
		/* 1에서 9 사이의 숫자를 랜덤하게 9번 뽑아서 일렬로 출력하는 코드를 작성*/
		int min = 1;
		int max = 9;
		int [] arr = new int[max];
		int r;
		int count = 0;
		
		while(count < max) {
			r = (int)(Math.random()*(max-min+1)+min);	
			boolean isDuplicated = false;
			for(int i = 0; i < count; i++) {
				if(arr[i] == r) {
					isDuplicated = true;
				}//if
			}//for
			if(isDuplicated) {
				continue;
			}
			arr[count++] = r;
		}//while
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
	}

}
