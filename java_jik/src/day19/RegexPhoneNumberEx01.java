package day19;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexPhoneNumberEx01 {

	public static void main(String[] args) {
		/* 전화번호 정규표현식을 작성하여 입력받은 번호가 전화번호가 맞는지 출력하는 코드 작성
		 * 규칙1.
		 * 010-
		 * 010-[0-9]{4}-[0-9]{4}
		 * 010-\d{4}-\d{4}
		 * ^(010)-\\d{4}-\\d{4}$
		 * 010(-\d{4}){2}
		 * */
		String regex = "010(-\\d{4}){2}";
		Scanner sc = new Scanner(System.in);
		System.out.println("이메일을 입력하세요 : ");
		String str = sc.next();
	
		if(Pattern.matches(regex, str)){
			System.out.println(str + "은 ");
		}else {
			System.out.println(str + "은 ");
		}

	}

}
