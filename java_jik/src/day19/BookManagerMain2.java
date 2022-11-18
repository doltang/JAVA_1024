package day19;

import java.util.ArrayList;
import java.util.Scanner;

import day17.Board2;

public class BookManagerMain2 {
	/* 도서 관리 프로그램 작성
	 * 도서 정보 
	 * - 도서명, 저자(여러명, 엮은이, 옮긴이 다 포함), 가격, 출판사, 장르, ISBN
	 * 기능
	 * - 도서 추가
	 * 	- ISBN 으로 정렬 (1,2,3,4...)
	 * - 도서 조회
	 * 	- 도서명으로 조회
	 * 	- 저자로 조회
	 * 	- 출판사로 조회
	 * 	- 분류로 조회 */
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList <Book> list = new ArrayList<Book>();
		int menu = 0;
		int isbn = 0;
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu, list);
			
		}while(menu != 3);
	}

	private static void runMenu(int menu, ArrayList <Book> list) {
		switch(menu) {
		case 1 : 
			// 도서 추가
			addBook(list);
			break;
		case 2 : 
			// 추가된 도서가 없는 경우
			if(list == null || list.size() == 0) {
				System.out.println("추가된 도서가 없습니다.");
				return;
			}
			// 도서 조회
			// 서브 메뉴 출력
			printSubMenu();
			// 서브 메뉴 선택
			int subMenu = sc.nextInt();
			// 서브 메뉴 실행
			runSubMenu(sc, subMenu, list);
			break;
		case 3 :
			System.out.println("프로그램을 종료합니다.");
			break;
		default : 
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}

	private static void addBook(ArrayList <Book> list) {
		sc.nextLine();
		// 추가하려는 도서 정보 입력
		System.out.print("도서명 : ");
		String name = sc.nextLine();
		System.out.print("지은이 : ");
		String writer = sc.next();
		System.out.print("엮은이 : ");
		String editor = sc.next();
		System.out.print("옮긴이 : ");
		String translator = sc.next();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		System.out.print("출판사 : ");
		String publisher = sc.next();
		System.out.print("장르 : ");
		String genre = sc.next();
		System.out.print("ISBN : ");
		int isbn = sc.nextInt();
		
		// 지은이, 엮은이, 옮긴이를 객체로 만듦
		Book author = new Book(writer, editor, translator);
		
		// 도서 정보를 객체로 만들어 리스트에 저장
		Book book = new Book(name, writer, editor, translator, publisher, genre, price, isbn);
		list.add(book);
		System.out.println("도서가 추가되었습니다.");
	}

	private static void runSubMenu(Scanner sc, int subMenu, ArrayList <Book> list) {
		switch(subMenu) {
		case 1 : 
			// 도서명으로 조회
			sc.nextLine();
			// 조회하려는 도서명 입력
			System.out.print("도서명 : ");
			String name = sc.nextLine();
			
			for(Book tmp : list) {
				if(tmp.getName().equals(name)) {
					System.out.println(tmp);
				}
				else{
					System.out.println("찾으시는 도서가 없거나 이름이 잘못되었습니다.");
				}
			}
			break;
		case 2 : 
			// 저자로 조회
			sc.nextLine();

			// 조회하려는 저자명(글쓴이, 엮은이, 옮긴이중에서 입력)
			System.out.print("저자명(글쓴이, 엮은이, 옮긴이중 하나 입력) : ");
			String author = sc.next();
			
			
			// 추가된 도서가 있는 경우
			for(Book tmp : list) {
				if(tmp.getWriter().equals(author) || tmp.getEditor().equals(author) || tmp.getTranslator().equals(author)) {
					System.out.println(tmp);
				}
			}
			break;
		case 3 : 
			// 출판사로 조회
			sc.nextLine();
			// 조회하려는 출판사 입력
			System.out.print("출판사 : ");
			String publisher = sc.nextLine();
			break;
		case 4 : 
			// 장르로 조회
			sc.nextLine();
			// 조회하려는 장르 입력
			System.out.print("장르 : ");
			String genre = sc.nextLine();
			break;
		default : 
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}

	private static void printSubMenu() {
		System.out.println("-----조회 메뉴-----");
		System.out.println("1. 도서명으로 조회");
		System.out.println("2. 저자로 조회");
		System.out.println("3. 출판사로 조회");
		System.out.println("4. 장르로 조회");
		System.out.println("-------------");
		System.out.print("메뉴 입력 : ");
		
	}

	private static void printMenu() {
		System.out.println("-----메뉴-----");
		System.out.println("1. 도서 추가");
		System.out.println("2. 도서 조회");
		System.out.println("3. 종료");
		System.out.println("-------------");
		System.out.print("메뉴 입력 : ");
	}

}
