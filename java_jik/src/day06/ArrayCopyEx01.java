package day06;

public class ArrayCopyEx01 {

	public static void main(String[] args) {
		// 배열의 얕은 복사 예제
		int arr1[] = new int[3];
		int arr2[]; 
				
		arr2 = arr1; // arr1을 앝은 복사해서 arr2를 만듦
		
		
		
		// array1과 arr2 값 확인
		for(int i = 0; i <arr1.length; i++) {
			System.out.println("arr1[" + i + "] = " + arr1[i] + ", arr2 [" + i + "] = "
			+ arr2[i]);
		}
		arr1[0] = 10; //aee1의 값만 10으로 변경
		System.out.println("-----------------");
		//arr1과 arr2  값 확인, arr1, arr2 모두 10 출력
		for(int i = 0; i <arr1.length; i++) {
			System.out.println("arr1[" + i + "] = " + arr1[i] + ", arr2 [" + i + "] = "
			+ arr2[i]);
		}

	}

}
