package exampleAccountBook;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class AccountBook {
	ArrayList<Item> list = new ArrayList<Item>(); // item이라는 내역으로 구성
	AccountService accountService = new AccountServiceImp();// 서비스라는 객체를 만듦
	Scanner scan;
	
	public void run() { // run은 프로그램을 실행하는 메소드
		System.out.println("가계부 프로그램 실행");
		int menu = -1;
		do {
			try {
				accountService.printMenu();
				
				menu = scan.nextInt();
				
				accountService.runMenu(list, menu, scan);
			} catch(ParseException e) {
				System.out.println("날짜 형태가 잘못 되었습니다");
			}catch(InputMismatchException e) {
				System.out.println("잘못된 타입을 입력했습니다");
				scan.nextLine();
			}catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}while(menu != 5);
		System.out.println("가계부 프로그램 종료");
	}

	public AccountBook(Scanner scan) { // 생성자, 밖에서 스캐너를 넘겨줘서 이용
		if(scan == null) {
			this.scan = new Scanner(System.in);
		}else {
			this.scan = scan;
		}
		
	}
}
