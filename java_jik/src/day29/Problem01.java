package day29;

import java.util.Scanner;

public class Problem01 {

	public static void main(String[] args) {
		/* 아래 코드를 실행했을 때 결과와 결과가 그렇게 나오는 이유를 설명하라
		 * 결과
		 * true
		 * false
		 * 이유 :  "abc"는 리터럴 문자열이다.
		 * 		이미 사용된 리터럴 문자열을 이용하는 경우, 
		 * 		새로 선언하는게 아니라 기존에 선언된 리터럴 문자열의 주소를 알려줌(공유) 
		 * 		그래서 첫번째 출력은 true가 됨
		 * 		Scanner를 이용하여 입력받은 문자열은 리터럴 문자열이 아니기 때문에
		 * 		입력한 문자열이 앞에 사용중인 리터럴 문자열이더라도 새로 할당하여 주소를 넘겨줌
		 * 		그래서 두번째 출력은 공유하는게 아니기 때문에 false가 됨
		 * 올바르게 동작시키려면 equals를 이용해야 함
		 * str1.equals(str2)
		 * str1.equals(str3) */
		Scanner sc = new Scanner(System.in);
		String str1 = "abc"; 
		String str2 = "abc";
		String str3 = sc.next(); // abc를 입력했다고 가정 // 리터럴 문자열이 아니기 때문에 주소가 다르다
		
		System.out.println(str1 == str2); // true // str1과 str2는 같은 주소를 공유하고 있다
		System.out.println(str1 == str3); // false
		sc.close();

	}

}
