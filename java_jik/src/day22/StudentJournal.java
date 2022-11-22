package day22;

import java.util.ArrayList;

import lombok.Data;

	// 학생 클래스 : 이름, 생년월일
	// 학생 일지 클래스 : 이름, 생년월일, 출결
	// 일지 클래스 : 날짜, 학생일지들(이름, 생년월일, 출결)
	// 출석부 클래스 : 학생들, 일지들
@Data
public class StudentJournal {
	private ArrayList<Student> sList;
	private char attendence;
	
	public StudentJournal(ArrayList<Student> sList, char attendence) {
		this.sList = sList;
		this.attendence = attendence;
	}
	
}
