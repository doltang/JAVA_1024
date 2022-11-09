package day13;

public class Student {
	// 필드 : 학년, 반, 번호, 이름, 성적들
	private int grade;
	private int classNum;
	private int num;
	private String name;
	private Score [] scoreList; // 성적이 여러 개 들어가야하니까 배열로 만들어 줌
	private int maxSize; // 최대 저장 가능한 성적 수
	private int count; // 현재 저장된 성적 수
	
	/**
	 * 학생 정보에 성적을 추가하는메소드
	 * @param 추가할 성적
	 * @return 추가 여부
	 * */
	public boolean addScore(Score score) {
		// 예외 처리 : 학생정보가 비어있으면 false
		if(score == null) {
			return false;
		}
		// 예외 처리 : 배열에 성적들이 꽉 찼을 때
		if(count == maxSize) {
			return false;
		}
		// 선택한 학생의 성적 정보들 중에서 과목, 학기가 같은 정보가 없으면 추가
		for(int i = 0; i < count; i++) {
			if(score.equals(scoreList[i])) {
				return false;
			}
		}
		scoreList[count] = new Score(score); 
		count++;
		return true;
	}
	
	// getter와  setter (게터 세터의 필수조건 : public)
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	// 학년 반 번호를 비교하는 equals > 소스 활용 자동완성
	// Object 조상 클래스에서 오버라이딩 해온 메소드
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
		maxSize = 30; // 배열의 최대 크기 지정
		scoreList = new Score[maxSize]; // 배열의 크기를 지정
	}
	
	// 학년, 반, 번호, 이름이 필요한 생성자(학생 정보 추가 시 활용)
	public Student(int grade, int classNum, int num) {
		super();
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
	}

	public void printScore() {
		for(int i = 0; i < count; i++) {
			System.out.println(scoreList[i]);
		}
		
	}

	// 학년, 반, 번호가 필요한 생성자(성적 추가 시 학생이 있는지 없는지 판별할 때 활용)
	
}
