package day20;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneListMain {
	/* 전화번호를 관리하는 프로그램을 작성
	 * 1. 전화번호 추가 (성, 이름, 직장, 전화번호들(이름 : 번호)
	 * 2. 전화번호 수정
	 *  - 이름으로 검색(성 + 이름)
	 *  - 검색된 사람들 중에서 선택
	 *  - 성, 이름을 수정할건지, 
	 *    기존 등록된 전화번호를 수정할건지,
	 *    새 전화전호를 등록할건지를 선택하여 동작
	 * 3. 전화번호 삭제
	 * 	- 이름으로 검색(성+이름)
	 * 	- 검색된 사람들 중에서 전택
	 *  - 선택된 사람의 연락처를 삭제
	 * 4. 전화번호 조회
	 * 	- 이름으로 검색
	 *  - 검색된 사람들 중에서 선택
	 *  - 선택된 사람의 연락처를 출력*/
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		char menu = '0';
		ArrayList <PhoneList> list = new ArrayList <PhoneList>();
		do {
			printMenu();
			
			menu = sc.next().charAt(0);
			
			runMenu(menu, list);
	
		}while(menu != 5);
		
	}//main
	private static void runMenu(char menu, ArrayList<PhoneList> list, PhoneNumber number) {
		int count = 0;
		String lastName, firstName, office, label, num;
		switch(menu) {
		case '1' : 
			// 전화번호 정보 입력받기
			if(addNum(list)) {
				System.out.println("등록이 완료되었습니다.");
			}else {
				System.out.println("이미 등록된 전화번호 입니다.");
			}			
			break;
		case '2' :
			// 전화번호 수정
			updateNum(list);
			
			break;
		case '3' : 
			
			break;
		case '4' :
			
			break;
		case '5' :
			System.out.println("프로그램을 종료합니다.");
			printBar();
			break;
		default :
			System.out.println("잘못된 메뉴입니다.");
			printBar();
		}
		
	}
	private static void updateNum(ArrayList<PhoneList> list) {
		int count = 0;
		String lastName, firstName, office, label, num;
		// 이름을 입력 받는다
		sc.nextLine();
		System.out.print("성 : ");
		lastName = sc.next();
		System.out.print("이름 : ");
		firstName = sc.next();
		sc.nextLine();
		
		// 이름이 포함된 전화번호부를 검색하여 출력(번호와 함께)
		for(PhoneList tmp : list) {
			if(tmp.getLastName().contains(lastName)) {
				if(tmp.getFirstName().contains(firstName)) {
					System.out.println(tmp);				
					printBar();
					count++;
				}
			}
		}
		if(count == 0) {
			System.out.println("일치하는 이름이 없습니다.");					
		}
		// 수정할 전화번호부를 선택
		// 전화번호로 검색
		System.out.print("수정할 사람의 라벨(직장, 집등): ");
		label = sc.nextLine();
		System.out.print("수정할 사람의 전화번호 : ");
		num = sc.nextLine();
		
		PhoneNumber searchNumber = new PhoneNumber(label, num);
		
		for(PhoneList tmp : list) {
			if(tmp.getNumber().equals(searchNumber)) {
				System.out.println("수정 메뉴" + tmp);				
				printBar();
				count++;						
			}
		}
		if(count == 0) {
			System.out.println("전화번호 입력이 잘못 됐습니다.");	
			continue;
		}
		// 서브 메뉴 출력
		printSubMenu();
				
		// 서브 메뉴 선택
		char subMenu = sc.next().charAt(0);
		// 서브 메뉴 실행
		PhoneList updateTmp = new PhoneList();
		switch(subMenu) {
		case '1' :
			// 1. 이름, 직장 수정
			// 이름 직장 입력
			sc.nextLine();
			System.out.print("성 : ");
			lastName = sc.next();
			System.out.print("이름 : ");
			firstName = sc.next();
			sc.nextLine();
			System.out.print("직장 : ");
			office = sc.nextLine();
			
			count = 0;
			for(PhoneList tmp : list) {
				if(tmp.getLastName().contains(lastName)) {
					if(tmp.getFirstName().contains(firstName)) {
						if(tmp.getOffice().contains(office)) {
							// 이름, 직장을 수정
							// 새 이름, 직장 입력
							sc.nextLine();
							System.out.print("new 성 : ");
							String newLastName = sc.next();
							System.out.print("new 이름 : ");
							String newFirstName = sc.next();
							sc.nextLine();
							System.out.print("new 직장 : ");
							String newOffice = sc.nextLine();
							
							updateTmp.update1(newLastName, newFirstName, newOffice);

							System.out.println(tmp);				
							printBar();
							count++;
						}
					}
				}
			}
			if(count == 0) {
				System.out.println("일치하는 정보가 없습니다.");					
			}
			break;
		case '2' :
			// 2. 기존 전화번호 수정
			// 기존 전화번호들을 출력
		
			// 수정할 전화번호를 선택

			// 이름, 번호를 입력
	
			// 선택한 전화번호 이름, 번호를 수정
			break;
		case '3' :
			// 3. 새 전화번호 추가
			// 이름, 번호를 입력

			// 새 전화번호를 추가
			break;
		case '4' :
			System.out.println("취소");
			break;
		default :
			System.out.println("잘못된 메뉴 입니다.");
		}
	}
	private static void printSubMenu() {
		System.out.println("=====수정 메뉴=====");
		System.out.println("1. 이름, 직장 수정");
		System.out.println("2. 기존 전화번호 수정");
		System.out.println("3. 새 전화번호 추가");
		System.out.println("4. 취소");
		printBar();
		System.out.print("수정 메뉴 선택 : ");				
	}
	private static boolean addNum(ArrayList<PhoneList> list) {
		String lastName, firstName, office, label, num;
		sc.nextLine();
		System.out.print("성 : ");
		lastName = sc.next();
		System.out.print("이름 : ");
		firstName = sc.next();
		sc.nextLine();
		System.out.print("직장 : ");
		office = sc.nextLine();
		
		char moreNum;
		PhoneNumber number;
		do {
			System.out.print("라벨(직장, 집등): ");
			label = sc.nextLine();
			System.out.print("전화번호 : ");
			num = sc.nextLine();
			
			number = new PhoneNumber(label, num);
			
			System.out.print("전화번호를 더 입력할까요?(y/n) : ");
			moreNum = sc.next().charAt(0);		
			sc.nextLine();
		}while(moreNum != 'n');
		
		// 입력받은 정보를 객체로 만들기
		PhoneList phoneBook = new PhoneList(lastName, firstName, office, number);
		System.out.println(phoneBook);
		
		// 객체에서 중복되는 전화번호가 있는 경우
		if(list.contains(phoneBook)) {
			return false;
		}
		// 객체로 만든 정보 리스트에 저장
		list.add(phoneBook);	
		return true;
	}
	private static void printMenu() {
		System.out.println("======메뉴======");
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 조회");
		System.out.println("5. 종료");
		printBar();
		System.out.print("메뉴 선택 : ");		
	}
	public static void printBar() {
		System.out.println("===============");
	}
}//class
