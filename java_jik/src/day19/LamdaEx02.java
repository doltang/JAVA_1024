package day19;

import java.util.function.Consumer;

public class LamdaEx02 {

	public static void main(String[] args) {
		// 객체 만들때 new라는 연산자를 쓰지 않는 람다
		// 타입을 생략 가능
		// 인터페이스의 메소드를 오버라이딩하는 메소드(함수)
		// 실행문이 하나인 경우 중괄호 생략 가능
		// 다만 void가 아닌 return이 필요할 경우, return 키워드를 제거해야 중괄호 생략이 가능하다
		
		// 람다로 구현 메소드
		Sum sum = (a, b) -> a + b; 
		System.out.println(sum.run(1, 2));
		
		// 람다로 구현 메소드
		Print <Integer> print = num -> System.out.println(num);
		print.run(10);
		
		Print <String> print3 = num -> System.out.println(num);
		print3.run("10");
		
		// Consumer 함수적 인터페이스 : 인터페이스를 만들지 않고 바로 람다식 쓰기
		Consumer<String> print2 = str -> System.out.println(str);
		print2.accept("10");
	}
}
interface Sum{
	// 추상 메소드
	double run(double a, double b);
}
// 제네릭 인터페이스 (다양하게 넣어서 사용할 수 있도록 인터페이스는 대부분 제네릭으로 쓴다)
interface Print<T>{ // 제네릭을 통해 다양한 타입의 매개변수를 넣을 수 있다 // T가 의미가있다기보다 대문자 아무거나 써도 됨
	// 추상메소드
	void run(T num);
}

interface Print1<T, G>{ // 제네릭 여러 개 써도 된다
	// 추상메소드
	void run(T num, G num2);
}