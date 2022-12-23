package studentDB_homework;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentMain {
	static Scanner sc = new Scanner(System.in);
	static StudentDB stdDB;
	static ArrayList<Student1> list = new ArrayList<Student1>();
	
	public static void main(String[] args) {
		 String url = "jdbc:mysql://localhost/University";
	     String id = "root"; 
	     String pw = "root";
	     
	     try {
			stdDB = new StudentDB(url, id, pw);
		} catch (Exception e) {
			System.out.println("[DB 연결 실패]");
			System.out.println("[프로그램 종료]");
			return;
		}
	    
	    int menu = -1;
	    load();
	    do {
	    	printMenu();
	    	menu = sc.nextInt();
	    	runMainMenu(menu);
	    }while(menu != 7);
	       

	}
	private static void load() {
		try {
			list = stdDB.selectAllStudent();
		} catch (SQLException e) {
			System.out.println("[로딩 실패]");
		}
		
	}
	private static void runMainMenu(int menu) {
		switch(menu){
		case 1 : 
			int subMenu = -1;			
			do {
				printsubMenu(1);
				subMenu = sc.nextInt();
				runDepartMenu(subMenu);
				
			}while(subMenu != 5);
			
			break;
		case 2 : 
			subMenu = -1;			
			do {
				printsubMenu(2);
				subMenu = sc.nextInt();
				runDepartMenu(subMenu);
				
			}while(subMenu != 5);

			break;
		case 3 : 
			subMenu = -1;			
			do {
				printsubMenu(3);
				subMenu = sc.nextInt();
				runDepartMenu(subMenu);
				
			}while(subMenu != 5);
			break;
		case 4 : 
			printsubMenu(4);
			break;
		case 5 : 
			printsubMenu(5);
			break;
		case 6 : 
			printsubMenu(6);
			break;
		case 7 : 
			System.out.println("프로그램을 종료합니다.");
			break;
		default :
			System.out.println("잘못된 메뉴입니다.");

		}
		
	}
		
	private static void runDepartMenu(int subMenu) {
		switch(subMenu) {
		case 1: 
			System.out.println("1. 학부 등록");
			insertDepart();
			break;
		case 2: 
			System.out.println("2. 학부 수정");
			break;
		case 3: 
			System.out.println("3. 학부 삭제");
			break;
		case 4: 
			System.out.println("4. 학부 조회");
			break;
		case 5: 
			System.out.println("5. 뒤로");
			break;
		default :
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}
	// 학부 등록
	private static void insertDepart() {
		System.out.print("학부 번호 : ");
		String st_num = sc.nextLine();
		System.out.print("이름 : ");
		String st_name = sc.nextLine();
		System.out.print("학기 : ");
		int st_semester = sc.nextInt();
		sc.nextLine();
		System.out.print("상태(재학/휴학/자퇴/퇴학) : ");	
		String st_state = sc.nextLine();
		System.out.print("지도교수번호 : ");
		String st_pr_num = sc.nextLine();
		
		try {
			stdDB.insertStudent(st_num, st_name, st_semester, st_state, st_pr_num);
			Student1 std = new Student1(st_num, st_name, st_semester, st_state, st_pr_num);
			list.add(std);
			Collections.sort(list,(o1,o2) -> {
				return o1.getSt_num().compareTo(o2.getSt_num());
			});
		} catch (SQLException e) {
			System.out.println("학생 등록에 실패했습니다.");
		}
	}
	private static void printStudentList() {
		if(list.size() == 0)
			System.out.println("저장된 학생 정보가 없습니다.");
		for(Student1 std : list) {
			System.out.println(std);
		}
		
		
	}
	private static void printsubMenu(int subMenu) {
		switch(subMenu) {
		case 1: 
			System.out.println("=======학부 메뉴=======");
			System.out.println("1. 학부 등록");
			System.out.println("2. 학부 수정");
			System.out.println("3. 학부 삭제");
			System.out.println("4. 학부 조회");
			System.out.println("5. 뒤로");
			System.out.println("---------------------");	
			System.out.print("메뉴 입력 : ");
			break;
		case 2: 
			System.out.println("=======강좌 메뉴=======");
			System.out.println("1. 강좌 등록");
			System.out.println("2. 강좌 수정");
			System.out.println("3. 강좌 삭제");
			System.out.println("4. 강좌 조회");
			System.out.println("5. 뒤로");
			System.out.println("---------------------");	
			System.out.print("메뉴 입력 : ");
			break;
		case 3: 
			System.out.println("=======학생 메뉴=======");
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 수정");
			System.out.println("3. 학생 삭제");
			System.out.println("4. 학생 조회");
			System.out.println("5. 뒤로");
			System.out.println("---------------------");	
			System.out.print("메뉴 입력 : ");
			break;
		case 4: 
			System.out.println("=======교수 메뉴=======");
			System.out.println("1. 교수 등록");
			System.out.println("2. 교수 수정");
			System.out.println("3. 교수 삭제");
			System.out.println("4. 교수 조회");
			System.out.println("5. 뒤로");
			System.out.println("---------------------");	
			System.out.print("메뉴 입력 : ");
			break;
		case 5: 
			System.out.println("=======수강 메뉴=======");
			System.out.println("1. 수강 신청");
			System.out.println("2. 수강 취소");
			System.out.println("3. 뒤로");
			System.out.println("---------------------");	
			System.out.print("메뉴 입력 : ");
			break;
		case 6: 
			System.out.println("=======성적 메뉴=======");
			System.out.println("1. 성적 등록");
			System.out.println("2. 성적 수정");
			System.out.println("3. 성적 조회");
			System.out.println("4. 뒤로");
			System.out.println("---------------------");	
			System.out.print("메뉴 입력 : ");
			break;
		
		}
		
	}
	private static void insertStudent() {
		System.out.print("학번 : ");
		String st_num = sc.nextLine();
		System.out.print("이름 : ");
		String st_name = sc.nextLine();
		System.out.print("학기 : ");
		int st_semester = sc.nextInt();
		sc.nextLine();
		System.out.print("상태(재학/휴학/자퇴/퇴학) : ");	
		String st_state = sc.nextLine();
		System.out.print("지도교수번호 : ");
		String st_pr_num = sc.nextLine();
		
		try {
			stdDB.insertStudent(st_num, st_name, st_semester, st_state, st_pr_num);
			Student1 std = new Student1(st_num, st_name, st_semester, st_state, st_pr_num);
			list.add(std);
			Collections.sort(list,(o1,o2) -> {
				return o1.getSt_num().compareTo(o2.getSt_num());
			});
		} catch (SQLException e) {
			System.out.println("학생 등록에 실패했습니다.");
		}
	}
	private static void printStudentList() {
		if(list.size() == 0)
			System.out.println("저장된 학생 정보가 없습니다.");
		for(Student1 std : list) {
			System.out.println(std);
		}
		
	}
	private static void printMenu() {
		System.out.println("=========메뉴=========");
		System.out.println("1. 학부 메뉴");
		System.out.println("2. 강좌 메뉴");
		System.out.println("3. 학생 메뉴");
		System.out.println("4. 교수 메뉴");
		System.out.println("5. 수강 메뉴");
		System.out.println("6. 성적 메뉴");
		System.out.println("7. 종료");
		System.out.println("---------------------");	
		System.out.print("메뉴 입력 : ");
		
	}

}
