package db_day1;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
	static Scanner sc = new Scanner(System.in);
	static Statement stmt = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ArrayList<Student1> list = null;
	
	public static void main(String[] args) {
		Connection con = null;
		String url = "jdbc:mysql://localhost/University";
		String id = "root";
		String pw = "root";
		con = connect(url, id, pw);
		
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int menu = 0;
		do {
			print_menu();
			
			menu = sc.nextInt();
			
			run_menu(menu, con);
		}while(menu != 3);

	}
	private static Connection connect(String url, String id, String pw) {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("[연결 성공]");
			
		} 
		catch(ClassNotFoundException e) {
			System.out.println("[드라이버 로딩 실패]");
		}		
		catch(SQLException e) {
			System.out.println("에러 : " + e);
		}
		
		return con;
	}
	private static void run_menu(int menu, Connection con) {
		switch(menu){
		case 1 : 
			sc.nextLine();
			addStudnet(con);
			break;
		case 2 : 
			sc.nextLine();
			try {
				list = selectAllStudent(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(list);
			break;
		case 3 : 
			System.out.println("프로그램을 종료합니다.");
			connectClose(con);
			break;
		default :
			System.out.println("잘못된 메뉴입니다.");
			connectClose(con);
		}
		
	}
	private static void addStudnet(Connection con) {
		System.out.print("학번 : ");
		String st_num = sc.nextLine();
		System.out.print("이름 : ");
		String st_name = sc.nextLine();
		System.out.print("학기 : ");
		int st_semester = sc.nextInt();
		sc.nextLine();
		System.out.print("상태 : ");	
		String st_state = sc.nextLine();
		System.out.print("교수번호 : ");
		String st_pr_num = sc.nextLine();
		
		try {
			
			insertStudent(con, st_num, st_name, st_semester, st_state, st_pr_num);
			
			list = selectAllStudent(con);
			System.out.println(list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	private static ArrayList<Student1> selectAllStudent(Connection con) throws SQLException {
		String sql = "select st_num, st_name, st_semester, st_state, st_pr_num from student";
		rs = stmt.executeQuery(sql);
		ArrayList<Student1> list = new ArrayList<Student1>();
		while(rs.next()) {
			int st_num = rs.getInt(1);
			String st_name = rs.getString(2);
			int st_semester = rs.getInt(3);
			String st_state = rs.getString(4);
			String st_pr_num = rs.getString(5);
			Student1 std = new Student1(st_num, st_name, st_semester, st_state, st_pr_num);
			list.add(std);			
		}
		return list;
	}
	private static void connectClose(Connection con) {
		try{
            if( con != null && !con.isClosed()){
                con.close();
                System.out.println("[연결 해제]");
            }
        }
        catch( SQLException e){
            e.printStackTrace();
        }
		
	}
	private static void insertStudent(Connection con, String st_num, String st_name, int st_semester, String st_state,
			String st_pr_num) throws SQLException {
		String sql = "insert into student(st_num, st)name, st_semester," +
				"st_state, st_pr_num) values(?, ?, ?, ?, ?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, st_num);
		pstmt.setString(2, st_name);
		pstmt.setInt(3, st_semester);
		pstmt.setString(4, st_state);
		pstmt.setString(5, st_pr_num);
		
		int count = pstmt.executeUpdate();
		if(count == 0) {
			System.out.println("[추가 실패]");
		}else {
			System.out.println("[추가 성공]");
		}
	}
	private static void print_menu() {
		System.out.println("=========메뉴=========");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 조회");
		System.out.println("3. 종료");
		System.out.println("---------------------");	
		System.out.print("메뉴 입력 : ");
	}

}
