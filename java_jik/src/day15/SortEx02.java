package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortEx02 {

	public static void main(String[] args) {
		// String은 알파벳 순으로 정렬된다
		ArrayList<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("orange");
		list.add("boy");
		list.add("year");
		list.add("a");
		System.out.println(list);
		Collections.sort(list); // 오름차순으로 올라간다
		System.out.println(list);
		
		//내림차순으로 바꾸기 
		// Comparator 인터페이스를 구현한 구현 클래스 객체가 필요
		Collections.sort(list, new Comparator<String>() {
			// Comparator인터페이스에 있는 compare 추상 메소드
			@Override
			public int compare(String o1, String o2) {
				return -o1.compareTo(o2);
			}
		});
		System.out.println(list);


	}

}
