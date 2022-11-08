package day12;

public class Student {
	public int grade, classNum, num;
	public String name;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classNum;
		result = prime * result + grade;
		result = prime * result + num;
		return result;
	}
	@Override
	// 내 객체 참조변수 == 참조변수
	public boolean equals(Object obj) { 
		// 같은 객체를 공유
		if (this == obj)
			return true;
		// null과 비교 불가능
		if (obj == null)
			return false;
		// obj가 같은 클래스의 객체가 아닌 경우
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
	// 소스로 자동생성 toString
	@Override
	public String toString() {
		return "Student [grade=" + grade + ", classNum=" + classNum + ", num=" + num + ", name=" + name + "]";
	}
	
	
}
