package db_day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lombok.Data;

public class DB_test {
	Connection conn;
	ResultSet rs;
	Statement stmt;
	PreparedStatement pstmt;
	
	public static void main(String[] args) {
		DB_test dbTest = new DB_test();
		ArrayList<StudentVO1> list = new ArrayList<StudentVO1>();
		
		StudentDAOImp studentDao = null;
		
	    try{
	       // 생략해도 자동으로 driver 연결 됨
	       // Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost/university";
	        String id = "root", pw = "root";
	        dbTest.connect(url, id, pw);
	       
	        // DB 연결 완료	        
	        System.out.println("연결 성공");
	        
	        studentDao = new StudentDAOImp(dbTest.conn);
	        
	        // select문 사용
	        list = studentDao.selectAllStudent();
	       // System.out.println(list);
	        System.out.println(studentDao.selectStudentBySt_num("2022160001"));
//	        StudentVO1 std = new StudentVO1("2022130001", "고둘리", 1, "재학", "2022160001");
//	        if(studentDao.insertStudent(std)) {
//	        	System.out.println("추가 성공");
//	        }else {
//	        	System.out.println("추가 실패");
//	        }
//	        if(studentDao.deleteStudent("2022130001")) {
//	        	System.out.println("삭제 성공");
//	        }else {
//	        	System.out.println("삭제 실패");
//	        }
	        if(studentDao.updateStudent("2022160001", "가길동")) {
	        	System.out.println("수정 성공");
	        }else {
	        	System.out.println("수정 실패");
	        }
	       
	    }
	    catch(SQLException e){
	        System.out.println("연결 실패");
	    }
	    finally{
	       dbTest.closeConnect();
	    }

	}
	
	// 연결 
	public void connect(String url, String id, String pw) throws SQLException{
		 conn = DriverManager.getConnection(url, id, pw);
		 stmt = conn.createStatement();
	}
	
	// 연결 끊기
	public void closeConnect() {
		 try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	            if( pstmt != null && !pstmt.isClosed()){
	                pstmt.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	}
	

}
@Data
class StudentVO1{
	String st_num;
	String st_name;
	int st_semester;
	String st_state;
	String st_pr_num;
	
	public StudentVO1(String st_num, String st_name, int st_semester, String st_state, String st_pr_num) {
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_semester = st_semester;
		this.st_state = st_state;
		this.st_pr_num = st_pr_num;
	}

	@Override
	public String toString() {
		return "[학번 : " + st_num + ", 이름 : " + st_name + ", 학기 : " + st_semester + ", 상태 : "
				+ st_state + ", 지도교수 번호 : " + st_pr_num + "]";
	}
	
	
}