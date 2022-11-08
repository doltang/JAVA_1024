package day11;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello My name is Doltang.";
		String search = "o";
		int count = 0;
		String tmp = str;
		
		while(true) {
			int index = tmp.indexOf(search); // index에 str의 처음 만나는 o의 번지수(4)를 도출
			if(index == -1) { // 번지수가 -1로 (번지수 범위 벗어남) 반복문을 빠져나간다
				break;
			}
			tmp = tmp.substring(index + search.length());// 4 + 1(5번지의 길이) // 그냥 +1해도 무관
			count++;											// 5번지 부터 나머지
		}
		System.out.println(count);
		System.out.println(search.length());
		
	}

}
