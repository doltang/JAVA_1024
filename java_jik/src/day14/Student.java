package day14;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Student {
	// 필드 : 학년, 반, 번호, 이름, 성적들
	private int grade;
	private int classNum;
	private int num;
	private String name;
	private ArrayList<Score> scoreList = new ArrayList<Score>();
	
	/**
	 * 학생 정보에 성적을 추가하는메소드
	 * @param 추가할 성적
	 * @return 추가 여부
	 * */
	public boolean addScore(Score score) {
		// 예외 메시지 지정
		if(score == null) {
			throw new RuntimeException("성적 정보가 없어서 추가할 수 없습니다.");
		}

		// 선택한 학생의 성적 정보들 중에서 과목, 학기가 같은 정보가 없으면 추가
		boolean res = scoreList.contains(score);
		if(res) {
			return false;
		}
		scoreList.add(new Score(score)); 
		return true;
	}
	
	

	// 학년 반 번호를 비교하는 equals > 소스 활용 자동완성
	// Object 조상 클래스에서 오버라이딩 해온 메소드

	// 문자열로 변환해주는 toString() > 소스 활용
	@Override
	public String toString() {
		return "["+ grade + "학년" + classNum + "반" + num + "번 "+ name + "]";
	}
	
	// 메소드 : getter/setter, equals() : 같은 객체인지 비교하기 위해, 
	// 		   toString() : 객체를 쉽게 문자열로 만들기 위해
	
	
	// 생성자 : 초기화
	public Student(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;

	}
	


	public void printScore() {
	for(Score tmp : scoreList) {
		System.out.println(tmp);
	}
	}



	@Override
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

	// 학년, 반, 번호가 필요한 생성자(성적 추가 시 학생이 있는지 없는지 판별할 때 활용)
	
}
