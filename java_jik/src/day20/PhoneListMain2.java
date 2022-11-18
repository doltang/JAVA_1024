package day20;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneListMain2 {
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
		// 반복
			// 메뉴 출력
			
			// 메뉴 선택
			
			// 선택한 메뉴에 대한 기능 실행
				// 1. 번호 추가
					// 성명, 직장 입력
					
					// 반복		
						// 전화번호를 입력(이름(직장, 집등) : 번호) => PhoneNumber
					
						// 전화번호를 더 입력할건지 물어봄
		
					// 전화번호부에 추가 => PhoneBook 개체를 생성
		
				// 2. 번호 수정
						// 이름을 입력
		
						// 이름이 포함된 전화번호부를 검색하여 출력(번호와 함께)
		
						// 수정할 전화번호부를 선택
						
						// 서브 메뉴 출력
		
						// 서브 메뉴 선택
		
						// 서브 메뉴 실행
						// 1. 이름, 직장 수정
							// 이름 직장 입력
					
							// 이름, 직장을 수정
								
						// 2. 기존 전화번호 수정
							// 기존 전화번호들을 출력
						
							// 수정할 전화번호를 선택
		
							// 이름, 번호를 입력
					
							// 선택한 전화번호 이름, 번호를 수정
		
						// 3. 새 전화번호 추가
							// 이름, 번호를 입력
		
							// 새 전화번호를 추가
		
							
				// 3. 번호 삭제
					// 이름을 입력
					
					// 이름이 포함된 전화번호부를 검색하여 출력(번호와 함께)
			
					// 삭제할 전화번호부를 선택
		
				// 4. 번호 조회
					// 이름을 입력
					
					// 이름이 포함된 전화번호부를 검색하여 출력(번호와 함께)
			
					// 조회할 전화번호부를 선택
		
					// 전화번호 조회
		
				// 5. 프로그램 종료
		
			
		char menu = '0';
		ArrayList <PhoneList> list = new ArrayList <PhoneList>();
		do {
			printMenu();
			
			menu = sc.next().charAt(0);
			
			String lastName, firstName, office, num;
			switch(menu) {
			case '1' : 
				// 전화번호 정보 입력받기
				sc.nextLine();
				System.out.println("성 : ");
				lastName = sc.next();
				System.out.println("이름 : ");
				firstName = sc.next();
				sc.nextLine();
				System.out.println("직장 : ");
				office = sc.nextLine();
				System.out.println("전화번호 : ");
				num = sc.nextLine();
				
				// 입력받은 정보를 객체로 만들기
				PhoneList phone = new PhoneList(lastName, firstName, office, num);
				
				// 객체에서 중복되는 전화번호가 있는 경우
				if(list.contains(phone)) {
					System.out.println("이미 등록된 전화번호 입니다.");
					continue;
				}
				// 객체로 만든 정보 리스트에 저장
				list.add(phone);
				System.out.println("전화번호 등록이 완료되었습니다.");		
				break;
			case '2' :
				// 전화번호 수정	
				// 이름을 입력 받는다
				sc.nextLine();
				System.out.println("성 : ");
				lastName = sc.next();
				System.out.println("이름 : ");
				firstName = sc.next();
				sc.nextLine();
				
				int count = 0;
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
				// 검색된 사람들 중에서 선택
				// 전화번호로 검색
				System.out.println("수정할 사람의 전화번호 입력 : ");
				num = sc.nextLine();
				
				for(PhoneList tmp : list) {
					if(tmp.getNum().contains(num)) {
						System.out.println(tmp);				
						printBar();
						count++;						
					}
				}
				if(count == 0) {
					System.out.println("전화번호 입력이 잘못 됐습니다.");	
					continue;
				}
				// 성, 이름을 수정할건지, 기존 등록된 전화번호 수정할건지, 새 전화번호를 등록할건지 선택
				// 서브 메뉴 출력
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
			
		}while(menu != 5);
		
	}//main
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
