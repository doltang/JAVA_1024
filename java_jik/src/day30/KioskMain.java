package day30;

import java.util.ArrayList;
import java.util.Scanner;

public class KioskMain {
	
	/*제품을 관리하는 프로그램을 작성하라
	 *  - 구매가격, 판매가격은 변동이 없음
	 * 기능
	 * - 제품 등록(분류, 제품명, 수량, 구매가격, 판매가격)
	 * - 제품 수정
	 * - 제품 삭제
	 * - 제품 구매
	 * - 제품 판매
	 * - 매출액 확인
	 *  - 년별
	 *   - 제품별
	 *   - 전체
	 *  - 월별
	 *   - 제품별
	 *   - 전체
	 *  - 일별
	 *   - 제품별
	 *   - 전체
	 * 분류 : 식품
	 * 제품명 : 진라면
	 * 수량 : 0
	 * 구매각격 : 400원
	 * 판매가격 : 500원
	 * 진라면 100개 구매 => 진라면 수량 : 100개
	 * 진라면 10개 판매(날짜) => 진라면 수량 90개*/
	static Scanner sc = new Scanner(System.in);
	static ArrayList <Product> pList = new ArrayList <Product>();
	public static void main(String[] args) {
		int menu = -1;
		// 종료 선택까지 반복
		do {	
			// 메뉴 출력
			printMenu();
			// 메뉴 입력
			menu = sc.nextInt();
			// 입력한 메뉴에 따른 메뉴 실행
			runMenu(menu);
		}while(menu != 7);
	}
	private static void printBar() {
		System.out.println("----------------");		
	}
	
	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}
	
	
	/** printMenu 메뉴 출력*/
	private static void printMenu() {
		System.out.println("======MENU======");
		System.out.println("1. 제품 등록");
		System.out.println("2. 제품 수정");
		System.out.println("3. 제품 삭제");
		System.out.println("4. 제품 구매");
		System.out.println("5. 제품 판매");
		System.out.println("6. 매출액 확인");
		System.out.println("7. 종료");	
		printBar();
		System.out.print("메뉴 입력 : ");
	}
	/** runMenu 메뉴 실행
	 * @param int menu 입력한 메뉴*/
	private static void runMenu(int menu) {
		sc.nextLine();
		switch(menu) {
		case 1 : 
			if(addProduct()) {
				System.out.println("제품을 등록했습니다.");
			}else {
				System.out.println("제품을 등록하지 못했습니다.");
			}
			break;
		case 2 :
			if(updateProduct()) {
				System.out.println("제품을 수정했습니다.");
			}else {
				System.out.println("제품을 수정하지 못했습니다.");
			}
			break;
		case 3 : 
			if(deleteProduct()) {
				System.out.println("제품을 삭제했습니다.");
			}else {
				System.out.println("제품을 삭제하지 못했습니다.");
			}
			break;
		case 4 :
			break;
		case 5 : 
			break;
		case 6 :
			break;
		case 7 :
			printStr("프로그램을 종료합니다.");
			break;
		default :
			printStr("잘못된 메뉴입니다.");
		}
		System.out.println(pList);
	}

	
	/** 1. 제품 등록
	 * @return false : 제품등록 실패, true : 제품등록 성공*/
	private static boolean addProduct() {
		// 제품 정보 입력 (분류, 제품명, 수량, 구매가격, 판매가격)		
		// 제품 객체로 만들기
		Product product = insertInfo();
		
		// 제품 리스트에 이미 같은 제품이 있는지 체크
		int index = pList.indexOf(product);
		if(index != -1) {
			return false;
		}
		// 제품 리스트에 제품 등록
		pList.add(product);
		return true;
	}
	
	/** 제품 정보 입력 (분류, 제품명)
	 * return 제품명*/
	private static String insertName() {
		System.out.print("제품명 : ");
		String name = sc.nextLine();	
		return name;
	}
	
	/** 제품 정보 입력후 객체로 반환(분류, 제품명, 수량, 구매가격, 판매가격)
	 * @return product 객체*/
	private static Product insertInfo() {
		System.out.print("분류 : ");
		String section = sc.nextLine();
		String name = insertName();
		System.out.print("수량 : ");
		int num = sc.nextInt();
		System.out.print("구매가격 : ");
		int buyPrice = sc.nextInt();
		System.out.print("판매가격 : ");
		int salePrice = sc.nextInt();
		return new Product(section, name, num, buyPrice, salePrice);
	}
	
	/** 2. 제품 수정
	 * @return false : 제품수정 실패, true : 제품수정 성공*/
	private static boolean updateProduct() {
		if(pList.size() == 0) {
			return false;
		}
		// 제품 정보 입력 (제품명) 
		String name = insertName();	
		
		// 제품 리스트에서 해당 제품 찾기
		int index = 0;
		for(Product tmp : pList) {
			if(!(tmp.getName().equals(name))) {
				return false;
			}
			index += pList.indexOf(tmp);
		}
		System.out.println(index);
		// 수정할 제품 정보 입력
		Product product = insertInfo();

		// 제품 리스트에 제품 등록
		pList.set(index, product);
		return true;
	}
	
	/** 3. 제품 삭제
	 * @return false : 제품삭제 실패, true : 제품삭제 성공*/
	private static boolean deleteProduct() {
		if(pList.size() == 0) {
			return false;
		}
		// 제품 정보 입력 (제품명) 
		String name = insertName();
		
		// 제품 리스트에서 해당 제품 찾기
		int index = pList.indexOf(name);
		if(index == -1) {
			return false;
		}
		
		// 제품 삭제
		pList.remove(index);
		return true;
	}
	
	/** 4. 제품 구매(관리자가 구매, 입고)*/
		// 제품 정보 입력 (분류, 제품명)
	
		// 제품 수량 입력
	
		// 해당 제품 수량 추가
	
	/** 5. 제품 판매*/
		// 제품 정보 입력 (분류, 제품명)

		// 제품 수량 입력
		
		// 판매 수량 + 날짜
	
		// 해당 제품 수량 감소
	
		// 매출액 증가
	
	/** 6. 매출액 확인*/
		// 매출 메뉴 출력 (년별, 월별, 일별)
		
		// 매출 메뉴 선택
	
		// 매출 메뉴 선택에 따른 매출 메뉴 실행
	
			// 서브 메뉴 출력(제품별, 전체)
			
			// 서브 메뉴 선택
			
			// 서브 메뉴에 따른 서브 메뉴 실행
}
