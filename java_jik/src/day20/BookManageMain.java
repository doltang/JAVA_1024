package day20;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManageMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Book에 관한 list
		ArrayList <Book> list = new ArrayList <Book> ();
		int menu = 0;
		// 반복
		do {
			// 메뉴를 출력
			System.out.println("======메뉴======");
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서 조회");
			System.out.println("3. 종료");
			System.out.println("===============");
			System.out.print("메뉴 선택 : ");
			
			// 메뉴를 선택
			menu = sc.nextInt();
			// char menu = sc.next().charAt(0) // 문자로 메뉴를 받게되면 예외 발생이 줄어든다 (어짜피 맨앞글자만 인식하니까)
			String title, author, publisher, genre, isbn;
			int price;
			// 선택한 메뉴에 따른 기능 실행
			switch(menu) {
			case 1 : 
			// 선택 메뉴가 1번이면 도서 추가
				// 추가할 도서 정보를 입력
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
				
				// 도서 목록에 새 도서를 추가
				// 위에서 입력받은 도서 정보를 이용하여 도서 객체를 생성
				Book book = new Book(title, author, publisher, genre, isbn, price);
				
				// 생성된 도서 객체를 리스트에 추가
				// isbn 중복 체크해서 중복되면 건너뜀
				// 중복 : 리스트에 book 객체가 포함되었다
				if(list.contains(book)) {
					System.out.println("이미 등록된 ISBN 번호입니다.");
					System.out.println("===============");
					continue;
				}
				// 중복되지 않으면 추가
				list.add(book);
				System.out.println("도서 추가가 완료되었습니다.");
				System.out.println("===============");
				break;
			case 2 :
			// 선택 메뉴가 2번이면 도서 조회
				// 서브 메뉴 출력
				System.out.println("======메뉴======");
				System.out.println("1. 도서명으로 조회");
				System.out.println("2. 저자로 조회");
				System.out.println("3. 출판사로 조회");
				System.out.println("4. 장르로 조회");
				System.out.println("5. 취소");
				System.out.println("===============");
				System.out.print("조회 방법 선택 : ");
				
				// 서브 메뉴 선택
				int subMenu = sc.nextInt();
				System.out.println("===============");
				// 선택한 서브 메뉴 실행
				int count = 0;
				switch(subMenu) {
				// 서브메뉴가 1이면 도서명으로 조회
				case 1 :
					sc.nextLine(); // 엔터처리
					System.out.println("도서명 : ");
					title = sc.nextLine();
					
					for(Book tmp : list) {
						if(tmp.getTitle().contains(title.trim())) { // trim() 단어 앞 뒤 사이 공백 제거
							System.out.println(tmp);				// 공백 입력시 전체 조회가 된다
							System.out.println("===============");
							count++;
						}
					}
					if(count == 0) {
						System.out.println("검색 결과가 없습니다.");
						System.out.println("===============");
					}
					break;
				// 서브메뉴가 2면 저자로 조회
				case 2 :
					sc.nextLine(); // 엔터처리
					System.out.println("저자 : ");
					author = sc.nextLine();
					
					for(Book tmp : list) {
						if(tmp.getAuthor().contains(author.trim())) { // trim() 단어 앞 뒤 사이 공백 제거
							System.out.println(tmp);				// 공백 입력시 전체 조회가 된다
							System.out.println("===============");
							count++;
						}
					}
					if(count == 0) {
						System.out.println("검색 결과가 없습니다.");
						System.out.println("===============");
					}
					break;
				// 서브메뉴가 3이면 출판사로 조회
				case 3 :
					sc.nextLine(); // 엔터처리
					System.out.println("출판사 : ");
					publisher = sc.nextLine();
					
					for(Book tmp : list) {
						if(tmp.getPublisher().contains(publisher.trim())) { // trim() 단어 앞 뒤 사이 공백 제거
							System.out.println(tmp);				// 공백 입력시 전체 조회가 된다
							System.out.println("===============");
							count++;
						}
					}
					if(count == 0) {
						System.out.println("검색 결과가 없습니다.");
						System.out.println("===============");
					}
					break;
				// 서브메뉴가 4면 장르로 조회
				case 4 :
					sc.nextLine(); // 엔터처리
					System.out.println("장르 : ");
					genre = sc.nextLine();
					
					for(Book tmp : list) {
						if(tmp.getGenre().contains(genre.trim())) { // trim() 단어 앞 뒤 사이 공백 제거
							System.out.println(tmp);				// 공백 입력시 전체 조회가 된다
							System.out.println("===============");
							count++;
						}
					}
					if(count == 0) {
						System.out.println("검색 결과가 없습니다.");
						System.out.println("===============");
					}
					break;
				// 서브메뉴가 5이면 조회 취소
				case 5:
					System.out.println("조회 취소");
					System.out.println("===============");
					break;
				// 잘못된 서브메뉴면 잘못됐다고 출력
				default : 
					System.out.println("잘못된 메뉴입니다");
					System.out.println("===============");
				}
				break;
			case 3 :	
			// 선택 메뉴가 3번이면 프로그램 종료 출력
				System.out.println("프로그램 종료");
				System.out.println("===============");
				break;
			default :
			// 선택 메소드가 1,2,3이 아니면 잘못된 메뉴라고 출력
				System.out.println("잘못된 메뉴입니다");
				System.out.println("===============");
			}
		}while(menu != 3);	
		sc.close();


	}
}
