package studentDB_homework;

import lombok.Data;

@Data
public class Student1 {
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
