package day16;

import java.util.HashSet;

public class SetEx01 {

	public static void main(String[] args) {
		// hashcode로 분류한 후에 equals로 중복을 판별한다
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(9);
		set.add(10);
		set.add(5); // 순서가 보장이 안되는 set
		set.add(10);
		set.add(100);
		set.add(1);
		System.out.println(set); // 여러번 같은 값을 넣어도 하나만 저장되는 Set

	}

}
