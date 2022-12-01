package day30;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardMain {

	/* 기능
	 * - 게시글 등록
	 * - 게시글 수정
	 * - 게시글 삭제
	 * - 게시글 목록
	 * - 게시글 확인
	 * 	- 댓글 등록
	 * 	- 댓글 확인
	 * 	- 이전
	 * - 프로그램 종료*/
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Board> boardList = new ArrayList<Board>();
	public static void main(String[] args) {
		// 메뉴를 출력하고, 입력한 메뉴가 프로그램 종료가 아니면 반복하는 코드를 작성
		int menu = 0;
		do {
			try {
				printMenu();
				menu = sc.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("숫자를 입력하세요");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(menu != 6);

	}
	/** 메뉴를 출력하는 메소드
	 * */
	private static void printMenu() {
		System.out.println("=====메뉴=====");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 목록");
		System.out.println("5. 게시글 확인");
		System.out.println("6. 종료");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");
	}
	/** 메뉴가 주어지면 주어진 메뉴에 맞는 기능을 출력하는 메소드
	 * @param menu 선택된 메뉴로 정수*/
	private static void runMenu(int menu) {
		sc.nextLine();
		switch(menu) {
		case 1 :
			insertBoard();
			break;
		case 2 :
			System.out.println("2. 게시글 수정");
			break;
		case 3 :
			System.out.println("3. 게시글 삭제");
			break;
		case 4 :
			System.out.println("4. 게시글 목록");
			break;
		case 5 : 
			System.out.println("5. 게시글 확인");
			break;
		case 6 :
			System.out.println("프로그램을 종료합니다.");
			break;
		default :
			throw new RuntimeException("잘못된 메뉴를 선택했습니다.");
		}
		
	}
	
	/** insertBoard
	 * 게시글 정보를 입력받아 게시글을 출력하는 메소드
	 * 메소드 구현에 필요한 필드를 추가해도 됨
	 * */
	private static void insertBoard() {
		System.out.print("게시글 번호 : " );
		int num = sc.nextInt();
		sc.nextLine();
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("작성자 : ");
		String writer = sc.nextLine();
		System.out.print("내용 : ");
		String content = sc.nextLine();
		// 게시글 객체 생성
		Board board = new Board(num, title, writer, content);
		// 번호 중복 확인
		if(boardList.contains(board)) {
			System.out.println("이미 등록된 게시글 번호입니다.");
			return;
		}
		// 게시글 리스트에 추가
		boardList.add(board);
		for(Board tmp : boardList) {
			System.out.println(tmp);
		}
		
	}
}
