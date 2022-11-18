package day20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

public class BookManageMain2 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Book에 관한 list
		ArrayList <Book> list = new ArrayList <Book> ();
		int menu = 0;
		// 반복
		do {
			// 메뉴를 출력
			printMenu();
			
			// 메뉴를 선택
			// char menu = sc.next().charAt(0) // 문자로 메뉴를 받게되면 예외 발생이 줄어든다 (어짜피 맨앞글자만 인식하니까)
			menu = sc.nextInt();
			printBar();
			
			// 메뉴를 실행
			runMenu(menu, list);
			
		}while(menu != 3);	
		sc.close();
	}
	
	public static void printMenu() {
		System.out.println("======메뉴======");
		System.out.println("1. 도서 추가");
		System.out.println("2. 도서 조회");
		System.out.println("3. 종료");
		printBar();
		System.out.print("메뉴 선택 : ");
	}
	public static void printBar() {
		System.out.println("===============");
	}
	public static void runMenu(int menu, ArrayList <Book> list) {
		// 선택한 메뉴에 따른 기능 실행
		switch(menu) {
		case 1 : 
		// 선택 메뉴가 1번이면 도서 추가
			// 도서 정보를 입력받아 도서 객체 생성
			Book book = createBook();
			
			if(!insertBook(list, book))
				// false면
				System.out.println("이미 등록된 ISBN 번호입니다.");
			else 
				// true면
				System.out.println("도서 추가가 완료되었습니다");
			printBar();
			break;
		case 2 :
		// 선택 메뉴가 2번이면 도서 조회
			// 서브 메뉴 출력
			printSearchMenu();
			
			// 서브 메뉴 선택
			int subMenu = sc.nextInt();
			printBar();
			
			// 선택한 서브 메뉴 실행
			runSearchMenu(subMenu, list);
			break;
		case 3 :	
			System.out.println("프로그램 종료");
			printBar();
			break;
		default :
			System.out.println("잘못된 메뉴입니다");
			printBar();
		}
	}
	public static Book createBook() {
		String title, author, publisher, genre, isbn;
		int price;
		sc.nextLine(); // 엔터 처리
		System.out.print("도서명 : ");
		title = sc.nextLine();
		System.out.print("저자 : ");
		author = sc.nextLine();
		System.out.print("출판사 : ");
		publisher = sc.nextLine();
		System.out.print("장르 : ");
		genre = sc.nextLine();
		System.out.print("ISBN : ");
		isbn = sc.next();
		System.out.print("가격 : ");
		price = sc.nextInt();	
		printBar();
		
		// 도서 목록에 새 도서를 추가
		// 위에서 입력받은 도서 정보를 이용하여 도서 객체를 생성
		return new Book(title, author, publisher, genre, isbn, price);
	}
	public static boolean insertBook(ArrayList<Book> list, Book book) {
		if(list.contains(book)) {
			return false;
		}
		// 중복되지 않으면 추가
		list.add(book);
		// isbn 정렬 -> ? predicate 인터페이스의 test 메소드를 오버라이드
		Collections.sort(list, (o1, o2) -> o1.getIsbn().compareTo(o2.getIsbn()));
		// 역순으로 정렬, - 를 붙여준다
		// Collections.sort(list, (o1, o2) -> - o1.getIsbn().compareTo(o2.getIsbn()));
		return true;
	}
	public static void printSearchMenu() {
		System.out.println("======메뉴======");
		System.out.println("1. 도서명으로 조회");
		System.out.println("2. 저자로 조회");
		System.out.println("3. 출판사로 조회");
		System.out.println("4. 장르로 조회");
		System.out.println("5. 취소");
		printBar();
		System.out.print("조회 방법 선택 : ");
	}
	public static void runSearchMenu(int subMenu, ArrayList<Book> list) {
		String title, author, publisher, genre;
		switch(subMenu) {
		// 서브메뉴가 1이면 도서명으로 조회
		case 1 :
			sc.nextLine(); // 엔터처리
			System.out.println("도서명 : ");
			title = sc.nextLine();
			printBar();
			
			// Predicate 람다식 하나로 반복되는 패턴을 한줄로 처리하기
			printBookList(list, b -> b.getTitle().contains(title.trim()));
			break;
		// 서브메뉴가 2면 저자로 조회
		case 2 :
			sc.nextLine(); // 엔터처리
			System.out.println("저자 : ");
			author = sc.nextLine();
			printBar();
			
			printBookList(list, b -> b.getAuthor().contains(author.trim()));
			break;
		// 서브메뉴가 3이면 출판사로 조회
		case 3 :
			sc.nextLine(); // 엔터처리
			System.out.println("출판사 : ");
			publisher = sc.nextLine();
			printBar();
			
			printBookList(list, b -> b.getPublisher().contains(publisher.trim()));			
			break;
		// 서브메뉴가 4면 장르로 조회
		case 4 :
			sc.nextLine(); // 엔터처리
			System.out.println("장르 : ");
			genre = sc.nextLine();
			printBar();
			
			printBookList(list, b -> b.getGenre().contains(genre.trim()));	
			break;
		// 서브메뉴가 5이면 조회 취소
		case 5:
			System.out.println("조회 취소");
			printBar();
			break;
		// 잘못된 서브메뉴면 잘못됐다고 출력
		default : 
			System.out.println("잘못된 메뉴입니다");
			printBar();
		}
	}
	public static void printBookList(ArrayList<Book> list, Predicate<Book> p) {
		int count = 0;
		for(Book tmp : list) {
			// printBookList(list, b -> b.getTitle().contains(title.trim()));
			// Predicate 람다식 이용
			if(p.test(tmp)) { 
				System.out.println(tmp);				
				printBar();
				count++;
			}
		}
		if(count == 0) {
			System.out.println("검색 결과가 없습니다.");
			printBar();
		}
	}
}
