package day15;

import java.util.ArrayList;
import java.util.Scanner;

import day14.Student;

public class ListEx01 {

	public static void main(String[] args) {
		/* 리스트를 이용하여 다음 기능을 갖는 오늘의 할 일 프로그램을 작성하라
		 * 메뉴
		 * 1. 할 일 추가
		 * 2. 할 일 확인
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * -------------------
		 * 할 일 입력 : 오후 수업 참여
		 * -------------------
		 * 1. 할 일 추가
		 * 2. 할 일 확인
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * -------------------
		 * 할 일 입력 : 저녁
		 * ------------------- 
		 * 1. 할 일 추가
		 * 2. 할 일 확인
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * -------------------
		 * 1. 오후 수업 참여
		 * 2. 저녁
		 * -------------------
		 * 1. 할 일 추가
		 * 2. 할 일 확인
		 * 3. 종료
		 * 메뉴 선택 : 3
		 * -------------------
		 * 프로그램 종료
		 * 
		 * */
		Scanner sc = new Scanner(System.in);
		// 리스트 만들기 : Arraylist<클래스 명 : 내가 어떠한 정보를 관리할 것인가?> 객체이름 = ArrayList<클래스명>();
		ArrayList<Todo> todoList = new ArrayList<Todo>();
		int menu = 0;
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu, todoList);
		}while(menu != 3);
	}


	private static void runMenu(int menu, ArrayList<Todo> todoList) {
		Scanner scan = new Scanner(System.in);
		switch(menu) {
		case 1:
			if(addTodo(todoList)) {
				System.out.println("할 일을 추가했습니다.");
			}else {
				System.out.println("할 일을 추가하지 못했습니다.");
			}
			break;
		case 2:	
			printTodoList1 (todoList);
			break;
		case 3: 
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴!!");
		}
		
	}
	
	private static void printTodoList1(ArrayList<Todo> todoList) {
		for(Todo tmp : todoList) {
			System.out.println(tmp);
		}
		
	}


	private static boolean addTodo(ArrayList<Todo> todoList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("추가할 할 일 입력");
		Todo tmp = scanTodo();
		
		int index = todoList.indexOf(tmp);
		
		if(index == -1) {
			todoList.add(tmp);
			return true;
		}
		return false;
	}
	
	private static Todo scanTodo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("할 일 : ");
		String todo = scan.nextLine();
		return new Todo(todo);
	}


	private static void printMenu() {
		System.out.println("------메뉴-----");
		System.out.println("1. 할 일 추가");
		System.out.println("2. 할 일 확인");
		System.out.println("3. 프로그램 종료");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");
		
	}
	
}
