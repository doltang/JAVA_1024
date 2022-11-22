package day22;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class AttendenceMain {

	/* 출석부 관리 프로그램
	 * - 이름과 생년월일
	 * 1. 학생 등록
	 * 2. 학생 수정
	 * - 이름과 생년월일로 검색해서 이름과 생년월일 수정
	 * 3. 학생 삭제
	 * - 이름과 생년월일로 검색해서 삭제
	 * 4. 학생 출결 확인
	 * - 이름과 생년월일 검색해서 해당 학생의 모든 출결을 확인
	 * - 2022-11-22 : O
	 * 5. 출석 확인
	 * - 날짜 입력 : 2022-11-22 
	 * - (출석 : O, 지각 : /, 조퇴 : \ , 결석 : X)
	 * 홍길동 출석현황 : X
	 * 고길동 출석현황 : O
	 * 임꺽정 출석현황 : /
	 * 6. 출석 수정
	 * - 날짜 입력
	 * - 수정할 학생의 이름과 생년월일 입력
	 * 7. 출석 삭제
	 * - 날짜 입력하여 해당 날짜 출석 삭제
	 * 8. 날짜 별 출석 확인
	 * - 날짜 입력하여 해당 날짜의 모든 학생의 출석 여부를 확인
	 * 9. 프로그램 종료
	 * */
	// 학생 클래스 : 이름, 생년월일
	// 학생 일지 클래스 : 이름, 생년월일, 출결
	// 일지 클래스 : 날짜, 학생일지들(이름, 생년월일, 출결)
	// 출석부 클래스 : 학생들, 일지들
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Student> sList = new ArrayList<Student>();
	public static void main(String[] args) {
		int menu = 0;
		do {
			printMenu();
			
			try {
				// 메뉴 선택
				menu = sc.nextInt();
				System.out.println("===================");
				
				// 메뉴 실행
				runMenu(menu);
				
			}catch(RuntimeException e) {
				System.out.println(e.getMessage());
				System.out.println("===================");
			}
			
			
		}while(menu != 9);
	}//main
	// 메인 메뉴 실행
	private static void runMenu(int menu) {
		int sMenu = 0, aMenu = 0;
		switch(menu) {
		case 1 : 
			do {
				printStudentMenu();
				
				sMenu = sc.nextInt();
				
				runStudentMenu(sMenu);
				
			}while(sMenu != 5);
			break;
		case 2 :
			do {
				printAttendenceMenu();
				
				aMenu = sc.nextInt();
				
				runAttendenceMenu(aMenu);
				
			}while(aMenu != 5);
			break;
		case 3 :
			System.out.println("프로그램을 종료합니다.");
			System.out.println("===================");
			break;
		default :
			System.out.println("잘못된 메뉴입니다.");
			System.out.println("===================");
		}
		
	}
	// 출석 메뉴 실행
	private static void runAttendenceMenu(int aMenu) {
		switch(aMenu) {
		case 1 : 
			// 출석 확인
			checkAttendence();
			break;
		case 2 : 
			// 출석 수정
			break;
		case 3 : 
			// 출석 삭제
			
			break;
		case 4 : 
			// 출석 출결 확인
			break;
		case 5 : 
			System.out.println("출석 메뉴를 종료합니다");
			System.out.println("===================");
			break;
		default :
			System.out.println("잘못된 메뉴입니다.");
			System.out.println("===================");
		}
		
	}
	// 1. 출석 확인
	private static void checkAttendence() {
		//StudentJournal sj = new 
		// 날짜 입력
		sc.nextLine();
		System.out.print("날짜 (2022-11-22) : ");
		String date = sc.nextLine();
		ArrayList<StudentJournal> sjList = new ArrayList<StudentJournal>();
		ArrayList<Journal> jList = new ArrayList<Journal>();
		StudentJournal sj;
		
		for(int i = 0; i < sList.size(); i++) {
			System.out.print(sList.get(i).getName() + " 출석 현황[출석 : O, 지각 : /, 조퇴 : \\, 결석 : X ] : ");
			char attendence = sc.next().charAt(0);			
			sj = new StudentJournal(sList, attendence);
			sjList.add(sj);			
			System.out.println("출석이 확인되었습니다.");
		}		
	}
	// 1. 학생 등록 
	private static boolean addStudent() {
		// 이름과 생년월일 입력 및 객체 생성
		Student st = inputNameBirth();	
		
		// 입력한 정보가 기존 리스트에있는 정보와 중복되는지 체크
		for(Student tmp : sList) {
			if(tmp.equals(st)) {
				return false;
			}
		}
		
		// 객체로 생성한 정보를 sList에 추가
		sList.add(st);
		System.out.println(sList);
		return true;
		
	}
	// 2. 학생 수정
	private static boolean updateStudent() {
		if(sList == null || sList.size() == 0) {
			throw new RuntimeException("검색 결과가 없습니다");
		}
		Student st = inputNameBirth();
		
		// 입력한 정보가 기존 리스트에있는 정보와 중복되는지 체크
		for(Student tmp : sList) {
			if(!tmp.equals(st)) {
				return false;
			}
			System.out.println(tmp);
		}
		
		// 수정할 이름과 생년월일 입력
		sc.nextLine();
		System.out.print("new 이름 : ");
		String name = sc.nextLine();
		System.out.print("new 생년월일(970214) : ");
		int dateOfBirth = sc.nextInt();
		
		st.update(name, dateOfBirth);
		System.out.println(st);
		return true;
	}
	// 3. 학생 삭제
	private static boolean deleteStudent() {
		if(sList == null || sList.size() == 0) {
			throw new RuntimeException("검색 결과가 없습니다");
		}
		Student st = inputNameBirth();
		
		int index = sList.indexOf(st);
	
		sList.remove(index);
		return true;
	}
	// 이름과 생년월일 입력 및 객체 생성
	private static Student inputNameBirth() {
		// 이름과 생년월일 입력
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("생년월일(970214) : ");
		int dateOfBirth = sc.nextInt();
		
		// 입력받은 정보를 객체로 생성
		Student st = new Student(name, dateOfBirth);	
		return st;
	}
	// 학생 메뉴 실행
	private static void runStudentMenu(int sMenu) {
		switch(sMenu) {
		case 1 : 
			// 학생 등록
			if(addStudent()) {
				System.out.println("학생을 등록했습니다.");
			}else {
				System.out.println("학생 등록에 실패했습니다.");
			}
			break;
		case 2 : 
			// 학생 수정
			if(updateStudent()) {
				System.out.println("학생정보를 수정했습니다.");
			}else {
				System.out.println("학생정보 수정에 실패했습니다.");
			}
			break;
		case 3 : 
			// 학생 삭제
			if(deleteStudent()) {
				System.out.println("학생정보를 삭제했습니다.");
			}else {
				System.out.println("학생정보 삭제에 실패했습니다.");
			}
			break;
		case 4 : 
			// 학생 출결확인
			
			break;
		case 5 : 
			System.out.println("학생 메뉴를 종료합니다");
			System.out.println("===================");
			break;
		default :
			System.out.println("잘못된 메뉴입니다.");
			System.out.println("===================");
		}
		
	}
	// 학생 메뉴 출력
	private static void printStudentMenu() {
		System.out.println("========메뉴========");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 학생 출결 확인");
		System.out.println("5. 취소");
		System.out.println("===================");
		System.out.print("메뉴 선택 : ");
		
	}
	// 출석 메뉴 출력
	private static void printAttendenceMenu() {
		System.out.println("========메뉴========");
		System.out.println("1. 출석 확인");
		System.out.println("2. 출석 수정");
		System.out.println("3. 출석 삭제");
		System.out.println("4. 날짜별 출석 확인");
		System.out.println("5. 취소");
		System.out.println("===================");
		System.out.print("메뉴 선택 : ");
		
	}
	// 메인 메뉴 출력
	private static void printMenu() {
		System.out.println("========메뉴========");
		System.out.println("1. 학생 관리 메뉴");
		System.out.println("2. 출석 관리 메뉴");
		System.out.println("3. 종료");
		System.out.println("===================");
		System.out.print("메뉴 선택 : ");
		
	}

}//class
