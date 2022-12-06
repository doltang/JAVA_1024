package day32;

import java.util.StringTokenizer;

public class StringTokenizerEx01 {

	public static void main(String[] args) {
		String str = "abc,def,.ghi";
		// 정규 표현식으로 적용 ,와 문자 하나를 구분자로 봄
		String [] arr = str.split(",."); 
		for(String tmp : arr) {
			System.out.println(tmp);
		}
		
		System.out.println("-----------------------");
		// . 또는 ,를 구분자로 봄
		StringTokenizer st = new StringTokenizer(str, ".,");
		System.out.println("개수 : " + st.countTokens());
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			System.out.println(tmp);
		}
		
		System.out.println("-----------------------");
		st = new StringTokenizer(str, ".,", true); // 뒤에 true를 추가하면 구분자도 같이 출력
		System.out.println("개수 : " + st.countTokens()); // 구분자의 개수
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			System.out.println(tmp); // 
		}
	}

}
