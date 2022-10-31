package day06;

import java.util.Arrays;

public class ArrayCopyEx02 {

	public static void main(String[] args) {
		// 깊은 복사 예제
		int arr1[] = new int[3];
		int arr2[];
		
		// 깊은 복사 예제1
		// 예제 3을 코드로 풀어 쓴 버전
		int tmpArr[] = new int [arr1.length];
		for(int i = 0; i < arr1.length; i++) {
			tmpArr[i] = arr1[i];
		}
		arr2 = tmpArr;
		
		// 깊은 복사 예제2
//		arr2 = new int [arr1.length];
//		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		
		// 깊은 복사 예제3
		//arr2 = Arrays.copyOf(arr1, arr1.length);
		
		// array1과 arr2 값 확인
		for(int i = 0; i <arr1.length; i++) {
			System.out.println("arr1[" + i + "] = " + arr1[i] + ", arr2 [" + i + "] = "
			+ arr2[i]);
		}
		arr1[0] = 10; //arr1의 값만 10으로 변경
		System.out.println("-----------------");
		//arr1은 10, arr2는 0서로 영향을 주지 않게 된다
		for(int i = 0; i <arr1.length; i++) {
			System.out.println("arr1[" + i + "] = " + arr1[i] + ", arr2 [" + i + "] = "
			+ arr2[i]);
		}

	}

}
