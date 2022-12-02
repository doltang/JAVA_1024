package day30;

import java.util.function.Consumer;

public class LambdaEx01 {

	static String filedStr = "필드";
	
	public static void main(String[] args) {
		String str = "main 지역변수";
		Consumer<Object> con = o -> {
			filedStr = "람다식에서 변경";
			System.out.println(str);//가져와서 쓸 수는 있지만 변경은 불가능
			//str += ""; // 에러 발생. 지역변수는 람다식에서 final이 자동으로 붙음
		};
		con.accept("");
		System.out.println(filedStr);
	}

}
