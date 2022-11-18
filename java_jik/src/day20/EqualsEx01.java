package day20;

import java.util.ArrayList;

import lombok.Data;

public class EqualsEx01 {

	public static void main(String[] args) {
		Test t1 = new Test();
		t1.setNum(10);
		System.out.println("Test 객체와 Integer 객체 비교(equals) : " // true
		+ t1.equals((Integer)10));
		ArrayList<Test>list = new ArrayList<Test>();
		list.add(t1);
		/* 리스트의 contains와 indexOf는 Test의 equals를 바로 호출하는것이 아니라
		 * Objects.equla(o1, o2)를 호출한 뒤, 내부에서 o1과 o2가 같은 클래스의 객체이면
		 * Test의 equals를 호출
		 * - 두 객체가 같은 클래스인 경우
		 * contains() -> Objects.equals() -> Test.equals()를 이용하여 true/false 리턴
		 * - 두 객체가 다른 클래스인 경우 (강제 형변환이 필요한 경우, 직접 반복문을 이용하거나 해야 함)
		 * contains() -> Objects.equals() -> false 리턴(더 갈 필요 없다)
		 * */
		System.out.println("Test 리스트와 Integer 객체 비교(contains) :" // false
				+ list.contains((Integer)10));
		System.out.println("Test 리스트와 Integer 객체 비교(indexOf) :" // -1
				+ list.indexOf((Integer)10));
	};

}
@Data
class Test{
	private int num;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// 나랑 상대방 클래스가 다르면 다르다고 인식한다
		// 이부분을 수정
		if (getClass() != obj.getClass()) {
			// 클래스가 다른 경우 obj가 Integer로 변환이 가능하면
			// obj를 Integer로 형변환해서 클래스가 같다고 설정
			if(obj instanceof Integer) {
				return num == (Integer)obj;
			}
		}
		Test other = (Test) obj;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}
	
}