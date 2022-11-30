package day28;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

public class EqualsEx01 {

	public static void main(String[] args) {
		/* list에서 제공하는 indexOf와 contains
		*/
		List<Test> list = new ArrayList<Test>();
		list.add(new Test(1,1));
		list.add(new Test(1,2));
		list.add(new Test(1,3));
		list.add(new Test(2,1));
		list.add(new Test(3,1));
		list.add(new Test(4,1));
		System.out.println(list);
		int index = list.indexOf(new Test(2,2));
		System.out.println("indexOf : " + index);
		Test t = new Test(2,1);
		System.out.println("equals : " + t.equals(new Test(2,2)));
		/* indexOf(비교객체)에서 Objects.equals를 호출하는데, 
		 * Objects.equals(비교객체, 리스트에서 꺼낸 객체)를 호출하기 때문에
		 * 비교객체.equals(리스트에서 꺼낸 객체)로 비교
		 * 아래 indexOf는 Integer.equals(Test 객체)를 하기 때문에 -1이 나옴
		 * */
		index = list.indexOf((Integer)2);
		System.out.println("indexOf : " + index); //-1
		System.out.println("equals : " + t.equals((Integer)2)); //true
		// Objects.equals(a,b) : a.equals(b)를 호출
		System.out.println((Objects.equals(new Test(2,1),(Integer)2))); // true
		System.out.println((Objects.equals((Integer)2, new Test(2,1)))); // false
		List <Test>list2 = new ArrayList<Test>();
		list2.add(new Test(1,1));
		list2.add(new Test(1,2));
		System.out.println("두 리스트 비교 : " + list.containsAll(list2));
		list2.add(new Test(10,1));
		System.out.println("두 리스트 비교 : " + list.containsAll(list2));
	}
}
@Data
class Test {
	int num1;
	int num2;
	
	public Test(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	// @Data의 equals는 모든 필드를 비교해서 모든 필드가 같아야 같은것이라고 판단하도록 오버라이딩 되어있다.
	// 내가 원하는 필드만 같은 객체로 판별하고 싶으면?
	// 내가 원하는 조건만 선택해서 오버라이드 해준다.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			// 정수로 타입변환이 가능하면 비교
			// instanceof : 클래스 변환이 가능한지 물어보는 연산자
			if(obj instanceof Integer) {
				// 비교해서 같으면 true
				if(num1 == (Integer)obj) {
					return true;
				}
				// 정수변환이 불가하거나 비교해서 같지 않으면 false
				return false;
			}
		Test other = (Test) obj;
		if (num1 != other.num1)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num1;
		return result;
	}
	
	
	
}