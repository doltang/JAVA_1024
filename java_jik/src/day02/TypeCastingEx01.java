package day02;

public class TypeCastingEx01 {

	public static void main(String[] args) {
		// 접미사f(F)가 없는 실수 리터럴은 double형
		// 1.23은 8바이트인 double이고, num1은 4 바이트인 float이기 때문에
		// 자동 형변환이 불가능하다 => 접미사를 붙이거나 강제 형변환
		float num1 = (float)1.23; // 리터럴 앞에 괄호안에 변환하고자 하는 자료형을 써준다
		// 정수 리터럴은 자료형에 맞는 타입으로 자동으로 설정
		byte num2 = 3;
		long num3 = 3;
		int num4 = (int)12345678901L; 
		// 10자리(십억)밖에 안되는 int. 
		// 접미사L을 써서 long으로 만들어 준 뒤 int로 강제 형변환 해준다
		

	}

}
