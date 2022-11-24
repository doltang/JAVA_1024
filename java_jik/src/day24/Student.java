package day24;

import java.io.Serializable;

import lombok.Data;

@Data
public class Student implements Serializable { // 직렬화
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int grade, classNum, num;
	public Student(String name, int grade, int classNum, int num) {
		this.name = name;
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
	}
	@Override
	// 학년, 반, 번호가 같으면 false가 나도록 equals를 name빼고 오버라이드
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classNum;
		result = prime * result + grade;
		result = prime * result + num;
		return result;
	}
	
	public String toString() {
		return grade + " 학년 | " + classNum + " 반 | " + num + " 번 | " + name + "\n";
	}
}
