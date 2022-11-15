package day17;

import java.util.HashMap;
import java.util.Scanner;

public class UserManagerMapMain {

	// 멤버 변수로 만들어서 쉽게 접근 가능, 매번 스캐너 새로 적어주기 번거로우므로
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		HashMap<String, Member> map = new HashMap<String, Member>();
		int menu = 0; // 메뉴에 해당되는 1~5번 사이만 아니면 된다
		do {
			
			System.out.println("-----메뉴-----");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 종료");
			System.out.println("-------------");
			System.out.print("메뉴 선택 : ");
			
			menu = sc.nextInt();
			
			switch(menu) {
			case 1 :
				if(addMember(map)) {
					//true
					System.out.println("회원 정보가 추가됐습니다.");
				}else {
					//false
					System.out.println("이미 가입된 아이디입니다.");
				}
				break;
			case 2 :
				if(!searchMember(map)) {
					// 메소드 안에서 이미 true이면 출력하도록 해놓았으니 false값만 이용
					System.out.println("아이디 또는 비번이 일치하지 않습니다");
				}
				break;
			case 3 : 
				if(updateMember(map)) {
					System.out.println("회원 정보 수정이 완료되었습니다.");
				}else {
					System.out.println("아이디 또는 비번이 일치하지 않습니다.");
				}
				break;
			case 4 : 
				if(deleteMember(map)) {
					System.out.println("회원 정보 삭제가 완료되었습니다.");
				}else {
					System.out.println("아이디 또는 비번이 일치하지 않습니다.");
				}
				break; 				
			case 5 : 
				break;
			default :				
			}
			
		}while(menu != 5);

	}
	// 아이디 등록에 실패할 수 있으므로 boolean
	public static boolean addMember(HashMap<String, Member> map) {
		if(map == null) {
			throw new RuntimeException("Map이 null입니다"); // 코드에 에러표시 안나도록 예외처리
			
		}
		System.out.println("회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("주민번호 : ");
		String residentNum = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		// map에 해당 정보가 있는지 확인
		Member addTmp = map.get(id);
		// 있으면 건너뜀
		if(addTmp != null) { // if(map.get(id)!= null) // addTmp가 한번만 쓰이니 이렇게 줄여써도 무방
			return false;
		}
		// 없으면 추가
		map.put(id, new Member(pw, name, residentNum, age));
		return true;
	}//addMember()
	public static boolean searchMember(HashMap<String,Member> map) {
		// 아이디 입력
		System.out.println("검색할 회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		String id = sc.next();							
		// 비번 입력
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		// 아이디를 이용하여 회원 정보를 가져옴 // 리스트의 경우 번지를 찾아서 넣어 비교했었는데..
		Member searchTmp = map.get(id);
		
		// 일치하는 회원 정보가 없으면 건너 뜀
		if(searchTmp == null) {
			return false;
		}
		
		// 가져온 회원 정보에서 비번이 같은지를 확인하여 같으면 회원정보 출력
		if(!searchTmp.getPw().equals(pw)) { // getter이용해 Member의 id정보를 가져온다
			return false;
		}
		System.out.println(id + " : " + searchTmp);
		return true;
	}//searchMember()
	public static boolean updateMember(HashMap<String,Member> map) {
		System.out.println("검색할 회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		String id = sc.next();							
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		Member updateTmp = map.get(id);
		if(updateTmp == null || updateTmp.getPw().equals(pw)) {
			return false;
		}
		
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("새 비밀번호 : ");
		String newPw = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("주민번호 : ");
		String residentNum = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		updateTmp.update(newPw, name, residentNum, age);
		return true;
	}
	public static boolean deleteMember(HashMap<String,Member> map) {
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		String id = sc.next();							
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		Member deleteTmp = map.get(id); //id로 검색
		if(deleteTmp == null || !deleteTmp.getPw().equals(pw)){
			return false;
		}

		map.remove(id); // 키값(id)에 해당하는 value값을 삭제	
		return true;
	}
}// class
