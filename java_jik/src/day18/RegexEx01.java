package day18;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexEx01 {

	public static void main(String[] args) {
		//문자열의 패턴을 알아낼 수 있는 정규표현식
//		String regex = "^...$"; // 세글자 아무거나
		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
//		boolean res = Pattern.matches(regex, str);
//		if(res) {
//		System.out.println(str + "는 3글자로 되어있습니다.");
//		}
//		else {
//			System.out.println(str + "는 3글자가 아닙니다.");
//		}
		// 아이디 정규 표현식 : 영문 소문자 5~20자리, 숫자와 특수기호 _와 -만 사용가능
		System.out.print("아이디를 입력하세요 : ");
		String regex1 = "[a-z0-9_\\-]{5,20}"; // \는 \\로 입력해야 인식
		String id = sc.next();
		boolean res1 = Pattern.matches(regex1, id);
		if(res1) {
		System.out.println(id + " 사용할 수 있는 아이디 입니다.");
		}
		else {
			System.out.println(id + " 아이디는영문 소문자 5~20자리, 숫자와 특수기호 _와 -만 사용가능합니다. ");
		}
	}

}
