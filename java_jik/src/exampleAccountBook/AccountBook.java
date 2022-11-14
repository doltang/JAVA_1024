package exampleAccountBook;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountBook {
	ArrayList<Item> list = new ArrayList<Item>();
	AccountService accountService = new AccountServiceImp();
	Scanner scan;
	public void run() {
		System.out.println("가계부 프로그램 실행");
		int menu = -1;
		do {
			accountService.printMenu();
			
			menu = scan.nextInt();
			
			accountService.runMenu(list, menu, scan);
		}while(menu != 5);
		System.out.println("가계부 프로그램 종료");
	}

	public AccountBook(Scanner scan) {
		if(scan == null) {
			this.scan = new Scanner(System.in);
		}else {
			this.scan = scan;
		}
		
	}
}
