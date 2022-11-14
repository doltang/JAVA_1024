package day16;

import java.util.HashMap;

import lombok.Data;

public class MapEx02 {

	public static void main(String[] args) {
		// 옵션에 이것저것 넣고싶다, 다양한 자료형을 넣고싶다 하면 object를 활용
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user", new User("abc", "def"));
		map.put("age", 22);
		map.put("address", "서울시");
		System.out.println(map.get("user"));
		System.out.println(map.get("age"));
		System.out.println(map.get("address"));
		System.out.println(map.get("123")); // key에 맞는 값이 없으면 null이 출력

	}

}
@Data
class User {
	private String id, pw;
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
		
	}
}