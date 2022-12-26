package student_DB;

import java.sql.*;
import java.util.Scanner;

public class StudentManager {
	Connection con;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		StudentManager sm = new StudentManager();
		
		String url = "jdbc:mysql://localhost/university";
		String id = "root", pw = "root";
		
		try {
			// DB 연결 메소드
			sm.connect(url, id, pw);
			
			// menu
			int menu = 0;
			do {
				
				printMenu();
				menu = sc.nextInt();
				sc.nextLine();
				runMenu(menu);
				
			}while(menu != 7);
			
		} catch (Exception e) {
			System.out.println("예외 발생 : 프로그램 종료");
		}finally{
			// DB 연결 종료 메소드
			sm.closeConnect();
		}

	}
	// 메인 메뉴 출력
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

	// DB 연결 메소드
	private void connect(String url, String id, String pw) throws Exception {
		con = DriverManager.getConnection(url, id, pw);
		
	}
	
	// DB 연결 종료 메소드
	private void closeConnect() {		
		try {
				// con 이 null이 아니고 con이 종료되지 않았다면 con을 종료해라
				if(con != null && !con.isClosed()) {
					con.close();
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
}
