package day19;

import java.util.function.Supplier;

public class SupplierEx01 {

	public static void main(String[] args) {
		// 잘 안쓰이는 supplier
		// 랜덤 할떄 종종 쓰임
		System.out.println(num(() -> (int)(Math.random()*10)));

	}
	public static int num(Supplier<Integer> s) {
		return s.get();
	}
}
