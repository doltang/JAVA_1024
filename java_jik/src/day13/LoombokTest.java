package day13;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class LoombokTest {

	public static void main(String[] args) {
		TestA a= new TestA();
		a.setNum(10);
		System.out.println(a.getNum());
		System.out.println(a); // toString()확인
		TestA b = new TestA();
		b.setNum(10);
		System.out.println(a.equals(b)); // equals()확인

	}

}
@Data //@Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor을 포함한 기능
//@Setter
//@Getter
//@ToString // 얘가 없으면 문자열이 이상하게 출력
//@EqualsAndHashCode
//@RequiredArgsConstructor
class TestA {
	private int num;
}