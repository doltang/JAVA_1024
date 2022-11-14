package day16;

import java.util.ArrayList;
import java.util.HashSet;

public class RandomListEx01 {

	public static void main(String[] args) {
		// set을 이용한 중복제거 방법 (set은 중복되지 않는다. 이때만 쓰이고 나머지는 다 리스트 씀)
		ArrayList<Integer> list = new ArrayList<Integer>();
		int maxCount = 3, min = 1, max = 9;
		
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size() < maxCount) {
			int r = (int)(Math.random()*(max - min + 1) + min);
			set.add(r);
		}
		list.addAll(set); // 1~9로 하면 정렬이 되는 set, 그 이상은 무작위
		System.out.println(list);

	}

}
