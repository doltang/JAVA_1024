package db_day1;

import java.sql.*;
import java.util.ArrayList;

import lombok.Data;

public class Db_test {
	// 쿼리를 사용할 수 있게 만들어주는 구문
	static Statement stmt = null;
	// select
	static ResultSet rs = null;
	// insert
	static PreparedStatement pstmt = null;

	public static void main(String[] args) {
        Connection con = null;
        String url = "jdbc:mysql://localhost/University";
        String id = "root"; // git에 올리는 경우 개인 비번 쓰지 말것
        String pw = "root";
        ArrayList<Student1> list = null;
        con = connect(url, id, pw);
        
        try {
			stmt = con.createStatement();
			
			//insertStudent(con, "2022160004", "바길동", 1, "재학", "2022160002");
			//updateStudent(con, "2022160001", "가나다");
			deleteStudent(con, "2022160005");
			
			list = selectAllStudent(con);
			System.out.println(list);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        connectClose(con);
       
	}
	
	private static void deleteStudent(Connection con, String st_num) throws SQLException {
		String sql = "delete from student where st_num = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, st_num); // 여기서 숫자는 ?의 위치이다
		
		int count = pstmt.executeUpdate();
		if(count == 0) {
			System.out.println("[수정 실패]");
		}else {
			System.out.println("[수정 성공]");
		}
		
	}

	private static void updateStudent(Connection con, String st_num, String st_name) throws SQLException {
			String sql = "update student set st_name = ?" +
					"where st_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, st_name); // 여기서 숫자는 ?의 위치이다
			pstmt.setString(2, st_num);
			
			int count = pstmt.executeUpdate();
			if(count == 0) {
				System.out.println("[수정 실패]");
			}else {
				System.out.println("[수정 성공]");
			}
		
	}

	public static Connection connect(String url, String id, String pw) {
		Connection con = null;
		  try{
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            con = DriverManager.getConnection(url, id , pw);
	            System.out.println("[연결 성공]");

	        }
	        catch(ClassNotFoundException e){
	            System.out.println("[드라이버 로딩 실패]");
	        }
	        catch(SQLException e){
	            System.out.println("에러: " + e);
	        }
           
            return con;    
	}
	
	public static void connectClose(Connection con) {
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

	public static ArrayList<Student1> selectAllStudent(Connection con)throws SQLException{
		String sql = "select st_num, st_name, st_semester, st_state, st_pr_num from student";
		rs = stmt.executeQuery(sql);
		ArrayList<Student1> list = new ArrayList<Student1>();
		while(rs.next()) {
			String st_num = rs.getString(1);
			String st_name = rs.getString(2);
			int st_semester = rs.getInt(3);
			String st_state = rs.getString(4);
			String st_pr_num = rs.getString(5);
			Student1 std = new Student1(st_num, st_name, st_semester, st_state, st_pr_num);
			list.add(std);			
		}
		return list;
	}

	public static void insertStudent( Connection con, String st_num, String st_name, 
		int st_semester, String st_state, String st_pr_num) throws SQLException {
		String sql = "insert into student(st_num, st_name, st_semester," +
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
}
@Data
class Student1{
	private String st_num;
	private String st_name;
	private int st_semester;
	private String st_state;
	private String st_pr_num;
	
	public Student1(String st_num, String st_name, int st_semester, String st_state, String st_pr_num) {
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_state = st_state;
		this.st_pr_num = st_pr_num;
	}
	
	
	
}