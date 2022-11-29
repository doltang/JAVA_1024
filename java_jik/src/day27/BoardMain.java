package day27;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardMain {
	
	/* 게시글 관리 프로그램
	 * - 회원가입
	 *  - 처음 가입한 회원이 관리자, 그외 회원은 일반회원
	 * - 로그인
	 * - 게시글 등록/수정/삭제 => 회원만 가능
	 * - 카테고리 관리 (공지, 자유)
	 * - 카테고리 추가/수정/삭제 (관리자만 가능)
	 * */
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int menu = 0;
		ArrayList <Member> memberList = new ArrayList<Member>();
		ArrayList<Member> loginList = new ArrayList<Member>();
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu, memberList, loginList);
		}while(menu != 5);

	}

	private static void runMenu(int menu, ArrayList<Member> memberList, ArrayList<Member> loginList) {
		switch(menu) {
		case 1 : 
			if(signUp(memberList)) {
				printStr("회원가입이 완료되었습니다.");
			}else {
				printStr("회원가입에 실패했습니다.");
			}
			break;
		case 2 : 
			if(signIn(memberList, loginList)) {				
				printStr("로그인이 완료되었습니다.");
				for(Member m : loginList) {
					System.out.println(m);
				}
			}else {
				printStr("로그인에 실패했습니다.");
			}
			break;
		case 3 :
			int menu3 = 0;
			do {
				printMenu3();			
				menu3 = sc.nextInt();
				runMenu3(menu3, memberList);
			}while(menu3 != 4);
			break;
		case 4 : 
			break;
		case 5 :
			System.out.println("프로그램을 종료합니다.");
			break;
		default :
			System.out.println("잘못된 메뉴 입력입니다.");
		}
		
	}


	private static void runMenu3(int menu3, ArrayList<Member> memberList) {
		switch(menu3) {
		case 1 :
			writeBoard(memberList);
			break;
		case 2 :
			break;
		case 3 :
			break;
		case 4 :
			printStr("메인 메뉴로 돌아갑니다.");
			break;
		default :
			printStr("잘못된 메뉴 입력입니다.");
		}	
	}

	private static void writeBoard(ArrayList<Member>memberList) {
		// 게시글 등록
		// 이름 입력
		
		// 카테고리 입력
		// 제목 입력
		// 내용 입력
		
	}

	private static void printMenu3() {
		System.out.println("==========메뉴==========");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 메인 메뉴로 돌아가기");
		printBar();
		System.out.print("메뉴 입력 : ");			
	}
	
	private static boolean signIn(ArrayList<Member> memberList, ArrayList<Member> loginList) {
		
		if(memberList == null || memberList.size() == 0) {
			printStr("등록된 회원이 없습니다.");
			return false;
		}
		sc.nextLine();
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String ps = sc.nextLine();
		
		for(Member tmp : memberList) {
			if(tmp.getId().equals(id) && tmp.getPs().equals(ps)) {
				printStr("환영합니다 " + tmp.getName() + "님!");
				loginList.add(tmp);
				return true;
			}
		}
		printStr("존재하지 않는 회원 정보입니다.");
		return false;
	}

	private static boolean signUp(ArrayList<Member> memberList) {
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String ps = sc.nextLine();
		String state = null;

		Member member = new Member(name, id, ps, state);
		
		for(Member tmp : memberList) {
			if(tmp.getId().equals(id) || tmp.getPs().equals(ps)) {
				printStr("이미 존재하는 아이디나 비밀번호 입니다.");
				return false;
			}
		}
		memberList.add(member);			
		//System.out.println(memberList.indexOf(member));
		
		if(memberList.indexOf(member) != 0) {
			member.setState("회원");
			return true;
		}
		printStr(name +"님이 관리자로 임명되었습니다.");
		member.setState("관리자");
		return true;		
	}

	private static void printMenu() {
		System.out.println("==========메뉴==========");
		System.out.println("1. 회원 가입");
		System.out.println("2. 로그인");
		System.out.println("3. 게시글 메뉴");
		System.out.println("4. 카테고리 메뉴");
		System.out.println("5. 종료");
		printBar();
		System.out.print("메뉴 입력 : ");	
	}
	
	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}
	
	private static void printBar() {
		System.out.println("------------------------");
	}
	

}
