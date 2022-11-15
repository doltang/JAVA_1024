package day17;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardManagerMain {
	/* 게시글 관리 프로그램을 작성하세요.
	 * 1. 게시글 작성
	 * 2. 게시글 조회
	 * 3. 게시글 수정
	 * 4. 게시글 삭제
	 * 5. 프로그램 종료
	 * - 게시글은 번호, 제목, 내용, 작성자, 작성일, 조회수로 구성
	 * - 게시글 전체 조회는 나중에 작성된 게시글이 상단에 조회
	 * - 게시글 상세 조회는 게시글 번호를 입력하여 게시글 내용을 확인
	 * - 게시글 상세 조회를 하면 조회수가 1 증가 
	 * - 게시글 주성은 게시글 번호를 선탣하면 해당 게시글의 제목, 내용을 수정
	 * - 게시글 삭제는 게시글 번호를 선탣하면 해당 게시글을 삭제
	 * */
	// 게시글 번호
	private static int num;
	public BoardManagerMain(int num) {
		num = 0;
	}
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Board> list = new ArrayList<Board>();
		int menu = 0;
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu, list);
			
		}while(menu != 5);
	}
	private static void runMenu(int menu, ArrayList<Board> list) {
		switch(menu) {
		case 1: 
			addBoard(list);
			break;
		case 2:
			// 게시글 조회
			// 게시글 번호를 입력
			System.out.println("조회하려는 게시글의 번호를 입력하세요");
			System.out.print("게시글 번호 : ");
			// 입력받은 게시글 번호를 객체로 생성
			Board bNum = new Board(sc.nextInt());
			// 입력받은 게시글 번호를 가진 게시글의 번지수를 index에 저장
			int index = list.indexOf(bNum);
			// 입력받은 게시글 번호를 가진 게시글이 없으면 종료
			if(index == -1) {
				break;
			}
			// 입력한 번호와 일치하는 게시글이 있으면 출력
			Board tmp = list.get(index);
			System.out.println(tmp);
			break;
		case 3 : 
			break;
		case 4 : 
			break;
		case 5 :
			break;
		default : 	
		}
		
	}
	private static void addBoard(ArrayList<Board> list) {
		// 게시글 작성
		// 제시글 제목, 내용, 작성자, 작성일 입력
		System.out.println("게시글의 제목, 내용, 작성자를 입력하세요");
		sc.nextLine(); // 제목 입력하는 칸에서 메뉴 입력할때 넣은 엔터값을 흡수해서 넣었음
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String content = sc.nextLine();
		System.out.print("작성자 : ");
		String writer = sc.nextLine();
		// 게시글 번호 up
		num++;
		// board 객체를 만들어 입력한 내용을 저장
		Board board = new Board(num, title, content, writer);
		// 게시글(board)객체를 게시판 리스트(list)에 올리기 
		list.add(board);
		System.out.println(list);
		
	}
	private static void printMenu() {
		System.out.println("-----메뉴-----");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 조회");
		System.out.println("3. 게시글 수정");
		System.out.println("4. 게시글 삭제");
		System.out.println("5. 종료");
		System.out.println("-------------");
		System.out.print("메뉴 선택 : ");
		
	}

}//class
