package day19;

import lombok.Data;

@Data
public class Student {
	private int grade;
	private int classNum;
	private int num;
	private String name;
	private int kor, eng, math;
	
	public Student(int grade, int classNum, int num, String name) {
		// 중복이 거슬리므로 아래 생성자 호출 ( 성적 값은 0으로 처리)
		this(grade, classNum, num, name, 0, 0, 0);
	}

	public Student(int grade, int classNum, int num, String name, int kor, int eng, int math) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public Student(int grade, int classNum) {
		this.grade = grade;
		this.classNum = classNum;
	}

	public Student(int grade) {
		this.grade = grade;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	
	
}
