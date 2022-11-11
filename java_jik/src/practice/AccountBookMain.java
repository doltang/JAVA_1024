package practice;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountBookMain {

	/* 가계부 프로그램을 작성하라.
	 * 메뉴
	 * 1. 내역 추가
	 * 2. 내역 확인
	 * 3. 내역 수정
	 * 4. 내역 삭제
	 * 5. 종료
	 * 
	 * 1. 내역 추가 
	 * 구분 : 수입/지출
	 * 분류 : 식비/통신비/교통비/생활비/용돈
	 * 내용 : 홈플러스/xx약국/xx식당
	 * 금액 : 5000
	 * 일시 : 년, 월, 일
	 * 
	 * 2. 내역 확인
	 * 2-1. 전체 내역 확인 (선택)
	 * 2-2. 년 내역 확인
	 * 2-3. 월 내역 확인
	 * 2-4. 일 내역 확인
	 * 구분 | 일시 | 분류 | 내용 | 금액 순으로 (한줄로 출력)
	 * 
	 * 3. 내역 수정
	 * 년, 월, 일로 검색 후 내역 출력
	 * 번호를 입력 
	 * 입력 받은 번호에 맞는 내역을 수정 - 구분/일시/분류/내용/금액 순으로 입력받아 수정
	 * 
	 * 4. 내역 삭제
	 * 년, 월, 일로 검색 후 내역 출력
	 * 번호를 입력
	 * 입력 받은 번호에 맞는 내역을 삭제
	 * 
	 * 추가 - 가계부를 년, 월, 일로 정렬
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<AccountBook> accBook = new ArrayList<AccountBook>();
		int menu = -1;
		
		do {
			printMenu();	
			
			try {
				menu = sc.nextInt();
				runMenu(menu, accBook);
			} catch (InputMismatchException e) {
				System.out.println("------------------------");
				System.out.println("예외 발생 : 정수를 입력하세요");
				System.out.println("------------------------");
				sc.nextLine(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}while(menu != 5);
	}

	private static void runMenu(int menu, ArrayList<AccountBook> accBook) throws Exception {
		switch(menu) {
		case 1 : 
			System.out.println("1. 내역 추가");
			addList(accBook);
			break;
		case 2 : 
			System.out.println("2. 내역 확인");
			printList(accBook);
			break;
		case 3 : 
			System.out.println("3. 내역 수정");
			updateList(accBook);
			break;
		case 4 : 
			System.out.println("4. 내역 삭제");
			deleteList(accBook);
			break;
		case 5 : 
			System.out.println("프로그램을 종료합니다");
			System.out.println("-----------------");
			break;
		default :
			throw new Exception("예외 발생: 잘못된 입력입니다.");
		}
		
	}



	private static void deleteList(ArrayList<AccountBook> accBook) {
		// TODO Auto-generated method stub
		
	}

	private static void updateList(ArrayList<AccountBook> accBook) {
		// TODO Auto-generated method stub
		
	}

	private static void printList(ArrayList<AccountBook> accBook) {
		// TODO Auto-generated method stub
		
	}

	private static void addList(ArrayList<AccountBook> accBook) {
		Scanner sc = new Scanner(System.in);
		System.out.println("구분 입력(수입/지출) : ");
		String inEx = sc.next();
		sc.nextLine();
		System.out.println("분류 입력(식비/통신비) : ");
		String type = sc.next();
		sc.nextLine();
		System.out.println("내용 입력(홈플러스/식당) : ");
		String content = sc.next();
		sc.nextLine();
		System.out.println("금액 입력 : ");
		int money = sc.nextInt();
		System.out.println("일시 입력(년,월,일) : ");
		int year = sc.nextInt();
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		accBook.add(new AccountBook(inEx, type, content, money, year, month, day)); 
	}

	private static void printMenu() {
		System.out.println("<<<<<메뉴>>>>>");
		System.out.println("1. 내역 추가");
		System.out.println("2. 내역 확인");
		System.out.println("3. 내역 수정");
		System.out.println("4. 내역 삭제");
		System.out.println("5. 종료");
		System.out.println("-------------");		
		System.out.print("메뉴 선택 : ");
	}

}
