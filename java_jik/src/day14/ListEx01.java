package day14;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEx01 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1); // 중복이 가능하고 순서가 유지되는 리스트
		list.add(2);
		list.add(0, 10);
		list.remove(1);
		list.remove((Integer)10); // 그냥 10하면 10번지에 있는걸 지우라는 것
		System.out.println(list); // list는 sysout하면 바로 나옴
		System.out.println("1이 있나요 ? " + list.contains(1));
		System.out.println("1이 어디에 있나요? " + list.indexOf(1) + "번지");
		System.out.println("1번지에 있는 값 : " + list.get(1));
		
		// list를 전체 출력하는 방법 
		// 반복문 이용 
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		// 향상된 for문 이용
		for(Integer tmp : list) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		// Iterator 이용 // set이나 Map에서 주로 사용, list는 이거 잘 사용 안함
		Iterator<Integer>it = list.iterator();
		while(it.hasNext()) { // hasNext()로 다음게 있는지 확인. 있으면 true, 없으면 false
			Integer tmp = it.next(); // it.next() 옆으로 이동
			System.out.print(tmp + " ");
		}
		System.out.println();

	}

}
