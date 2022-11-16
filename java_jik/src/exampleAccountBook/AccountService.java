package exampleAccountBook;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public interface AccountService { // 가계부 쓰는 사람의 입장
	// 인터페이스, 기능 설계도 
	void insertItem(ArrayList<Item>list, Item item); // 가계부에 있는 내역 리스트, 추가할 아이템
	void printItem(ArrayList<Item>list); // 가계부에 있는 내역 리스트
	boolean updateItem(ArrayList<Item>list, int index, Item item); // 가계부에 있는 내역 리스트, 몇 번지, 수정할 아이템
	boolean deleteItem(ArrayList<Item>list, int index); // 내역 삭제
	void printMenu(); // 메뉴 출력
	void printItem(ArrayList<Item>list, int ...dates); // 메소드 오버로딩
	void runMenu(ArrayList<Item> list, int menu, Scanner scan) throws ParseException;//메뉴 실행
	Item inputItem(Scanner scan) throws ParseException; // 스캐너를 통해서 입력받은걸 새로운 객체로 생성시켜 준다
	int selectItem(ArrayList<Item> list, String date, Scanner scan);
	String inputDate(Scanner scan)throws ParseException; // 날짜를 입력하는 메소드
	int inputYear(Scanner scan);
	int inputMonth(Scanner scan);
	int inputDay(Scanner scan);
	void printSubMenu();
	void runPrint(ArrayList<Item>list, int subMenu, Scanner scan);
}
