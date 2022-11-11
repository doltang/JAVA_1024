package day15;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ListEx01_1 {

	public static void main(String[] args) {
		/* 리스트를 이용하여 다음 기능을 갖는 오늘의 할 일 프로그램을 작성하라
		 * 메뉴
		 * 1. 할 일 추가
		 * 2. 할 일 확인
		 * 3. 할 일 삭제
		 * 4. 종료
		 * 메뉴 선택 : 1
		 * -------------------
		 * 할 일 입력 : 오후 수업 참여
		 * -------------------
		 * 1. 할 일 추가
		 * 2. 할 일 확인
		 * 3. 할 일 삭제
		 * 4. 종료
		 * 메뉴 선택 : 1
		 * -------------------
		 * 할 일 입력 : 저녁
		 * ------------------- 
		 * 1. 할 일 추가
		 * 2. 할 일 확인
		 * 3. 할 일 삭제
		 * 4. 종료
		 * 메뉴 선택 : 2
		 * -------------------
		 * 1. 오후 수업 참여
		 * 2. 저녁
		 * -------------------
		 * 1. 할 일 추가
		 * 2. 할 일 확인
		 * 3. 할 일 삭제
		 * 4. 종료
		 * 메뉴 선택 : 3
		 * -------------------
		 * 1. 오후 수업 참여
		 * 2. 저녁
		 * 
		 * 삭제할 번호 선택 : 1
		 * 1번 할 일이 삭제 되었습니다
		 * -------------------
		 * 1. 할 일 추가
		 * 2. 할 일 확인
		 * 3. 할 일 삭제
		 * 4. 종료
		 * 메뉴 선택 : 4
		 * -------------------
		 * 프로그램 종료
		 * 
		 * */
		// 리스트 만들기 : Arraylist<클래스 명 : 내가 어떠한 정보를 관리할 것인가?> 객체이름 = ArrayList<클래스명>();
		ArrayList<String> todoList = new ArrayList<String>();
		int menu = -1;
		Scanner sc = new Scanner(System.in);
		do {
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			try {
				menu = sc.nextInt();
				// 선택한 메뉴 실행
				// runMenu(관리할 리스트, 메뉴);
				runMenu(todoList, menu);
			}catch(InputMismatchException e) {
				System.out.println("-------------");
				System.out.println("예외 발생 : 정수를 입력하세요");
				System.out.println("-------------");
				sc.nextLine(); // 잘못 입력한 문자를 없애주는 역할
			}catch(Exception e) {
				System.out.println("-------------");
				System.out.println(e.getMessage());
				System.out.println("-------------");
			}
		}while(menu != 4);

	}

	private static void runMenu(ArrayList<String> todoList, int menu) throws Exception {
		Scanner sc = new Scanner(System.in);
		switch(menu) {
		case 1 : 
			// 할 일을 입력(공백 포함해서 입력)
			System.out.println("-------------");
			System.out.println("할 일 입력 : ");
			String todo = sc.nextLine();
			System.out.println("-------------");
			
			// 리스트에 입력된 할 일을 추가
			todoList.add(todo);
			break;
		case 2 : 
			// 숫자가 없으면 향상된 for문을 쓸 수 없다
			printTodoList(todoList);
			break;
		case 3 :
			// 할 일 확인
			printTodoList(todoList);
			// 삭제할 할일 번호 입력
			System.out.print("삭제할 번호 선택 : ");
			int index = sc.nextInt() -1 ; // 실제 번지는 0부터 시작하기 때문
			// 잘못된 번호를 입력한 경우 // 인덱스가 음수이거나 인덱스가 리스트 범위를 벗어날 경우 예외 처리
			if(index < 0 || index >= todoList.size()) {
				throw new Exception("예외 발생 : 삭제할 번호를 잘못 입력했습니다.");
			}
			//입력한 번호에 맞는 할일을 삭제		
			todoList.remove(index);
			System.out.println("삭제가 완료되었습니다");
			break;
		case 4 :
			System.out.println("프로그램 종료");
			break;
		default :
			throw new Exception("예외 발생 : 잘못된 메뉴입니다."); // 예외 발생시킴, sysout은 걍 출력
		}
		
	}
	

	private static void printTodoList(ArrayList<String> todoList) {
		if(todoList == null || todoList.size() == 0) {
			System.out.println("저장된 할 일이 없습니다");
			return;
		}
		System.out.println("---------------");
		for(int i = 0; i < todoList.size(); i++) {
			System.out.println(i + 1 + ". " + todoList.get(i));
		}
		System.out.println("---------------");
		
	}

	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 할 일 추가");
		System.out.println("2. 할 일 확인");
		System.out.println("3. 할 일 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");
	}

}
