package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortEx01 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(10);
		list.add(3);
		list.add(20);
		list.add(-1);
		System.out.println(list);
		Collections.sort(list); // 오름차순으로 올라간다
		System.out.println(list);
		
		//내림차순으로 바꾸기 
		// Comparator 인터페이스를 구현한 구현 클래스 객체가 필요
		Collections.sort(list, new Comparator<Integer>() {
			// Comparator인터페이스에 있는 compare 추상 메소드
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		System.out.println(list);

	}

}
