package day09;

public class HighStudent {
		//필드 : 멤버변수
		private int grade;
		private int classNum;
		private int num;
		private String name;
		private  int kor, eng, math;
		
		//메소드1 : 학생 정보 출력
		public void print() {
			System.out.println(grade + "학년 " + classNum + "반 " + num + "번 " + name);
			System.out.println("국어 : " + kor + " 영어 : " + eng + " 수학 : " + math);
		}
		//메소드2 : 성적 따로따로 수정
		public void updateKor(int kor1) { // 매개변수를 초기화할땐 void
			kor = kor1;
		}
		public void updateEng(int eng1) { 
			eng = eng1;
		}
		public void updateMath(int math1) { 
			math = math1;
		}
		//메소드3 : 성적 한꺼번에 수정
		public void updateScore(int kor1, int eng1, int math1) { 
			updateKor(kor1);
			updateEng(eng1);
			updateMath(math1);
		}
		//생성자 : 멤버변수 초기화
		public HighStudent () {
			this(1, 1, 1, "");
		}
		//생성자 오버로딩
		//생성자2 : 메인을 통해 초기화하는 생성자 std1,std2...의 정보를
		// Student std1 = new Student(1,1,1,"홍길동");로써 사용할 수 있다
		public HighStudent(int grade1, int classNum1, int num1, String name1) {
			grade = grade1;
			classNum = classNum1;
			num = num1;
			name = name1;
		}

	}


