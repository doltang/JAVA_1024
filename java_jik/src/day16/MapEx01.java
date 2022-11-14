package day16;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx01 {

	public static void main(String[] args) {
		// set list와는 부모도 다르고 방향도 다른 map
		//  두 개가 온다 < key(아이디처럼 중복 불가), value(비번처럼 중복 가능)>
		HashMap<String, String> userList = new HashMap<String, String>();
		userList.put("id1", "Pw1"); // 맵은 add말고 put
		userList.put("id2", "Pw2");
		userList.put("id3", "Pw2"); // 비번은 중복되도 괜찮다
		userList.put("id3", "Pw3"); // 새로 추가가 되지않고 덮어쓰기됨
									// 순서를 보장하지 않는 map		
		System.out.println(userList);
		// userList.get(userList) // map에서의 get은 key값을 이용해서 value를 찾는 역할, 둘다 나오는건 불가
		
		// 방법1. keySet을 이용
		// keySet()은 map에 있는 key들을 하나의 set에 담아 반환하는 메소드
		Set<String> keySet = userList.keySet();
		for(String tmp : keySet) {
			System.out.println(tmp + " : " + userList.get(tmp));
		}
		
		// 방법2. EntrySet을 이용
		// key와 value로 이루어져 있는 entry
		// key와 value각각을 set에 저장해 준다
		Set<Entry<String, String>> entrySet = userList.entrySet();
		for(Entry<String, String> tmp : entrySet) {
			System.out.println(tmp.getKey() + " : " + tmp.getValue());
		}
	}

}
