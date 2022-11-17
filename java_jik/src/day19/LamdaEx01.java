package day19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LamdaEx01 {

	public static void main(String[] args) {
		/* 람다식을 쓰는 이유?
		 *  - 코드가 간결해짐 (아래 예제 참고)
		 *  - 콜렉션에서 필터링이 쉬워짐
		 * 람다식은 언제 사용?
		 *  - 함수적 인터페이스의 객체가 필요한 경우
		 * 함수적 인터페이스
		 *  - 인터페이스의 추상메소드가 1개인 인터페이스*/
		ArrayList<Integer>list = new ArrayList<Integer>();
		list.add(1);
		list.add(10);
		list.add(-1);
		list.add(100);
		list.add(22);
		
		System.out.println(list);
		
		// 람다식을 이용한 list 정렬 (코드 간결)
		Collections.sort(list, (a, b) -> a-b);
		System.out.println(list);
		
		// list 정렬
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}			
		});
		System.out.println(list);


	}

}
