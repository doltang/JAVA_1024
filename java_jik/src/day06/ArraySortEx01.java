package day06;

import java.util.Arrays;
import java.util.Collections;

public class ArraySortEx01 {

	public static void main(String[] args) {
		// 버블 정렬을 이용한 배열 정렬
		int arr[] = {9, 8, 7, 6, 5, 3, 2, 1};
		for(int i = 0; i < arr.length - 1; i++) { // 두개두개씩 비교하기 위해 -1해줌
			for (int j = 0; j < arr.length - 1 - i; j++) { // -i는 생략 가능
				if(arr[j] > arr[j+1]) {// j가 j뒤에 있는 배열수 보다 크면 자리를 바꿔준다
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] =tmp;
				}
				
			}
			for(int tmp : arr) {
				System.out.print(tmp + " ");
			}
			System.out.println();
		}
		// 걍 간단하게 있는 메소드 쓰는 방법
		System.out.println("----------------");
		int arr2 [] = {9, 8, 7, 6, 5, 3, 2, 1}; 
		Arrays.sort(arr2); 
		for(int tmp : arr2) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		System.out.println("----------------");
		// 역순으로 정렬
		Integer arr3 [] = {9, 8, 7, 6, 5, 3, 2, 1}; 
		Arrays.sort(arr3, Collections.reverseOrder());
		for(int tmp : arr3) {
			System.out.print(tmp + " ");
		}

	}

}
