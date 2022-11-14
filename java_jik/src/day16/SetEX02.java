package day16;

import java.util.HashSet;
import java.util.Iterator;

public class SetEX02 {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(1);
		// 향상된 for문으로 set 접근하기, 출력하기
		for(Integer tmp : set) {
			System.out.print(tmp + " ");
		}
		// Iterator로 set 접근하기, 출력하기
		// 거의 공식
		System.out.println();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) { // hasNext로 있는지 없는지 확인
			Integer tmp = it.next(); // next로 갖고 나오기 
			System.out.print(tmp + " ");
		}
		System.out.println();

	}

}
