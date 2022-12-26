package db_day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAOImp implements StudentDAO {
	Connection conn;
	ResultSet rs;
	Statement stmt;
	PreparedStatement pstmt;
	
	// 생성자
	public StudentDAOImp(Connection conn) throws SQLException {
		this.conn = conn;
		if(conn != null)
			stmt = conn.createStatement(); // stmt를 conn을 통해서 만들어 준다. 나머지는 그때그때 필요한거라 안해도됨
	}
	
	// 모든 학생 정보 조회
	public ArrayList<StudentVO1> selectAllStudent() throws SQLException{
		// 연결이 안되었을 경우
			if(conn == null) {
				return null;
			}
		String sql = "select st_num, st_name, st_semester, st_state, st_pr_num from student";
        rs = stmt.executeQuery(sql);
        ArrayList<StudentVO1> list = new ArrayList<StudentVO1>();
        while(rs.next()) {
        	String st_num = rs.getString(1);
        	String st_name = rs.getString(2);
        	int st_semester = rs.getInt(3);
        	String st_state = rs.getString(4);
        	String st_pr_num = rs.getString(5);
        	StudentVO1 std = new StudentVO1(st_num, st_name, st_semester, st_state, st_pr_num);
        	list.add(std);
        }
        return list;
	}
	
	// 학번으로 학생 조회
	@Override
	public StudentVO1 selectStudentBySt_num(String st_num) throws SQLException {
		// 연결이 안되었을 경우
			if(stmt == null) {
				return null;
			}
		String sql = "select st_num, st_name, st_semester, st_state, st_pr_num" + 
				" from student where st_num = ?"; // ?에 어떤 값이 들어갈지 setString으로 설정해야 함
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, st_num); // 1번째 ?에 변수 st_num에 있는 값으로 이라는 문자열로 바꿔주세요
		rs = pstmt.executeQuery(); // 쿼리 실행
		if(rs.next()) {
			// 학번은 이미 알고 있으므로 제외
	    	String st_name = rs.getString(2);
	    	int st_semester = rs.getInt(3);
	    	String st_state = rs.getString(4);
	    	String st_pr_num = rs.getString(5);    	
	    	StudentVO1 std = new StudentVO1(st_num, st_name, st_semester, st_state, st_pr_num);
	    	return std;
		}
		return null;
	}
	
	// insert
	@Override
	public boolean insertStudent(StudentVO1 std) {
		// 연결이 안되었을 경우
			if(conn == null) {
				return false;
			}
		String sql = "insert into student values(?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, std.getSt_num());
			pstmt.setString(2, std.getSt_name());
			pstmt.setInt(3, std.getSt_semester());
			pstmt.setString(4, std.getSt_state());
			pstmt.setString(5, std.getSt_pr_num());
			int count = pstmt.executeUpdate();
			if(count == 0) {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	// 삭제
	@Override
	public boolean deleteStudent(String st_num) {
		// 연결이 안되었을 경우
			if(conn == null) {
				return false;
			}
		String sql = "delete from student where st_num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, st_num);
			int count = pstmt.executeUpdate();
			if(count == 0)
				return false;
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	// 수정
	@Override
	public boolean updateStudent(StudentVO1 std, int submenu) {
		// 연결이 안되었을 경우
		if(conn == null) {
			return false;
		}
		String sql = "update student set " +  
				"st_name = ?, st_semester = ?, st_state = ?, st_pr_num = ?"
				+ " where st_num = ?";
		try {
			StudentVO1 dbStd = selectStudentBySt_num(std.getSt_num());
			if(dbStd == null)
				return false;
			switch(submenu) {
			case 1 : dbStd.setSt_name(std.getSt_name()); break;
			case 2 : dbStd.setSt_semester(std.getSt_semester()); break;
			case 3 : dbStd.setSt_state(std.getSt_state()); break;
			case 4 : dbStd.setSt_pr_num(std.getSt_pr_num()); break;
			default : return false;
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dbStd.getSt_name());
			pstmt.setInt(2, dbStd.getSt_semester());
			pstmt.setString(3, dbStd.getSt_state());
			pstmt.setString(4, dbStd.getSt_pr_num());
			pstmt.setString(5, dbStd.getSt_num());
			int count = pstmt.executeUpdate();
			if(count == 0)
				return false;			
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

}
