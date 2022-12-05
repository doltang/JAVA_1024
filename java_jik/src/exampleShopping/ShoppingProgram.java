package exampleShopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingProgram {
	
	private List<Product> productList = new ArrayList<Product>();
	private List<Sales> salesList = new ArrayList<Sales>();
	private ProductController pc = new ProductController(productList);
	private SalesController sac = new SalesController(salesList, productList);
	private Scanner sc = new Scanner(System.in);
	
	public void run() {
		int menu = -1;
		// 프로그램 실행 중에 변경될 일이 없기 때문에 상수로 선언
		final int exit = 7;
		do {
			try {
				printMenu();
				menu = inputInt();
				exeMenu(menu);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(menu != exit);
	}

	private void exeMenu(int menu) {
		switch(menu) {
		case 1 :
			pc.insertProduct();
			break;
		case 2 :
			pc.updateProduct();
			break;
		case 3 :
			pc.deleteProduct();
			break;
		case 4 :
			sac.sales("구매");
			break;
		case 5 :
			sac.sales("판매");
			break;
		case 6 :
			sac.print();
			break;
		case 7 :
			break;
		default :
		}
		
	}
	
	// 정수 입력
	private int inputInt() {
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	private void printMenu() {
		System.out.println("=======MENU=======");
		System.out.println("1. 제품 등록");
		System.out.println("2. 제품 수정");
		System.out.println("3. 제품 삭제");
		System.out.println("4. 제품 구매");
		System.out.println("5. 제품 판매");
		System.out.println("6. 매출액 확인");
		System.out.println("7. 프로그램 종료");
		System.out.println("------------------");
		System.out.print("메뉴 선택 : ");
		
	}
	
	
}
