package practice;

import java.util.ArrayList;
import java.util.Scanner;

import day15.WordList;

public class UserManagerMain {

	public static void main(String[] args) throws Exception {
		/* 회원 정보를관리하는 프로그램을 작성하세요
		 * - 회원 정보는 아이디, 비번, 이름, 나이, 주민번호로 구성
		 * - 기능1 : 회원 추가
		 * - 기능2 : 회원 검색
		 * - 기능3 : 회원정보 수정
		 * - 기능4 : 회원 삭제*/
		Scanner sc = new Scanner(System.in);
		ArrayList<UserManager> userManager = new ArrayList<UserManager>();
		int menu = -1;
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu, userManager);
		}while(menu != 5);
	

}

	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 회원 추가");
		System.out.println("2. 회원 검색");
		System.out.println("3. 회원정보 수정");
		System.out.println("4. 회원 삭제");
		System.out.println("5. 종료");
		System.out.println("----------------");
		System.out.print("메뉴를 선택해주세요 : ");
	}

	private static void runMenu(int menu, ArrayList<UserManager> userManager) throws Exception {
		switch(menu) {
		case 1 : 
			System.out.println("회원 추가");
			addList(userManager);
			break;
		case 2 : 
			System.out.println("회원 검색");
			searchList(userManager);
			break;
		case 3 : 
			System.out.println("회원정보 수정");
			updateList(userManager);
			break;
		case 4 : 
			System.out.println("회원 삭제");
			deleteList(userManager);
			break;
		case 5 : 
			System.out.println("프로그램을 종료합니다");
			break;
		default :
			throw new Exception("잘못된 입력입니다");
		}
		
	}

	private static void deleteList(ArrayList<UserManager> userManager) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 id 입력 : ");
		String id = sc.next();
		ArrayList<Integer> indexList = findUserList(userManager, id);
		System.out.println(indexList);
		if(indexList == null || indexList.size()== 0) {
			throw new Exception("예외 발생 : 삭제하려는 단어가 단어장에 없습니다.");
		}
		for(int i = 0; i < indexList.size(); i++) {
			int index = indexList.get(i);
			System.out.println(i+1 + ". " + userManager.get(index));
		}
		System.out.print("삭제할 id 번호 : ");
		int index = sc.nextInt()-1;
		
		if(index < 0 || index >= indexList.size()) {
			throw new Exception("삭제할 id를 잘못 선택했습니다.");
		}
		userManager.remove((int)indexList.get(index)); // 번지를 의미하는 int로 바꿔야 한다
		System.out.println("삭제가 완료되었습니다.");
		
	}

	private static void updateList(ArrayList<UserManager> userManager) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 회원 id 입력 : ");
		String id = sc.next();
		ArrayList<Integer> indexList = findUserList(userManager, id);
		System.out.println(indexList);

		if(indexList == null || indexList.size()== 0) {
			throw new Exception("예외 발생 : 수정할 id를 잘못 입력했습니다.");
		}
		for(int i = 0; i < indexList.size(); i++) {
			int index = indexList.get(i);
			System.out.println(i+1 + ". " + userManager.get(index));
		} 
		
		System.out.print("수정할 회원 id 번호 : ");
		int index = sc.nextInt()-1;
		
		if(index < 0 || index >= indexList.size()) {
			throw new Exception("번호를 잘못 선택했습니다.");
		}
		sc.nextLine();
		// 수정할 정보를 입력
		System.out.print(" 수정할 비밀번호 입력" +  " : ");
		String pw = sc.next(); 
		
		
		UserManager tmp = userManager.get(indexList.get(index));
		tmp.setPw(pw);
		System.out.println("수정이 완료되었습니다.");

		
	}

	private static ArrayList<Integer> findUserList(ArrayList<UserManager> userManager, String id) {
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		for(int i = 0; i < userManager.size(); i++) {
			if(userManager.get(i).equals(id)) {
				list.add(i); 
			}
		}
		
		return list;
	}

	private static void searchList(ArrayList<UserManager> userManager) {
		if(userManager == null || userManager.size() == 0) {
			System.out.println("------------------");
			System.out.println("저장된 회원이 없습니다");
			System.out.println("------------------");
			return;
		}
		System.out.println("------------------");
		for(UserManager tmp : userManager) {
			System.out.println(tmp);
		}
		System.out.println("------------------");
		
	}

	private static void addList(ArrayList<UserManager> userManager) {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 입력" +  " : ");
		String id = sc.next();  
		System.out.print("비밀번호 입력" +  " : ");
		String pw = sc.next(); 
		System.out.print("이름 입력" +  " : ");
		String name = sc.next();  
		System.out.print("나이 입력" +  " : ");
		int age = sc.nextInt();  
		System.out.print("주민번호 입력" +  " : ");
		int socialNum = sc.nextInt();  
		UserManager tmp = new UserManager(id, pw, name, age, socialNum);
		userManager.add(tmp);
		
	}
}
