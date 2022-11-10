package day14;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagerTest {

	public static void main(String[] args) {
		/* 학생 성적 관리 프로그램을 작성하세요.
		 * - 작성하기 위해 필요한 작업들을 주석으로 정리하라
		 * 
		 * 1. 프로그램에 필요한 기능을 정리
		 * 메뉴
		 * 1. 학생 정보 추가
		 * 2. 학생 성적 추가
		 * 3. 학생 정보 출력
		 * 4. 프로그램 종료
		 * 
		 * 2. 프로그램 실행 과정은 어떻게 할 건지?
		 * 기능 (확실히 정해져야 함)
		 * 1. 학생 정보 추가
		 *  - 학년, 반, 번호, 이름을 입력하여 학생 정보 추가
		 *  - 학년, 반, 번호가 같은 학생이 이미 있으면 추가하지 않음(1학년 1반 1번 홍길동이 있으면 1학년 1반 1번 임꺽정이 들어오는걸 막는다)
		 * 2. 학생 성적 추가
		 *  - 학년, 반, 번호로 학생을 검색 한 후 있으면 성적을 추가
		 *  - 성적 추가시 과목명, 학기, 중간, 기말, 수행 평가를 입력하여 추가한다
		 *  - 이미 추가된 과목(학기랑 과목명이 같으면)이면 추가하지 않음
		 * 3. 학생 정보 출력
		 *  
		 * 3. 정보를 효율적으로 관리하기 위해 클래스를 만들 것인가? 만든다면 어떤 클래스를 만들건지?
		 *  - 학생 클래스 HighStudent
		 *  - 성적 클래스 Score
		 *  
		 * 4. 프로그램 실행 과정을 주석으로 작성  
		 * */
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> stds = new ArrayList<Student>();
		
		int menu = -1;
		// 반복문을 통해 메뉴를 출력
		for( ;menu != 4 ; ) {
			// 메뉴를 출력
			printMenu();
			// 메뉴 선택(입력)
			menu = sc.nextInt();			
			// 선택한 메뉴에 맞는 기능 실행
			runMenu(menu, stds); // count(현재저장된 학생 수)를 return하는 이유는? 메소드안에서 증가된 수를 기본 자료형으로 돌려줘야되기 때문				
		}	
	}

	private static void runMenu(int menu, ArrayList<Student> stds) {
		Scanner sc = new Scanner(System.in);
		
		switch(menu) {
		case 1:
			if(addStudent(stds)) { // 조건식(참, 거짓이 결과로 나오는식)만 넣으면 됨
				System.out.println("학생을 추가했습니다.");
			}else {
				System.out.println("추가하지 못했습니다");
			}
			break;
		case 2: 		
			if(addScore(stds)) {
				System.out.println("성적을 등록했습니다");
			}else {
				System.out.println("성적 등록에 실패했습니다");
			}
			break;
		case 3 :
			printStudentList(stds);
			break;
		case 4 :
			System.out.println("프로그램 종료");
			break;
		default : 
			System.out.println("잘못된 메뉴!!");
		}
	}


	private static void printStudentList(ArrayList<Student> stds) {
		for(Student tmp : stds) {
			System.out.println(tmp);
			tmp.printScore();
		}

	}

	private static boolean addScore(ArrayList<Student> stds) {
		System.out.println("성적을 추가할 학생 정보 입력");
		Student tmp = scanStudentBaseInfo();
		int index = stds.indexOf(tmp);
		
		if(index == -1) {
			return false;
		}
		
		System.out.println("성적 정보를 입력하세요");		
		return stds.get(index).addScore(scanScore());
	}

	private static boolean addStudent(ArrayList<Student> stds) {
		Scanner sc = new Scanner(System.in);
		System.out.println("추가할 학생 정보 입력");
					
		Student tmp = scanStudentBaseInfo(); //학년 반 번호를 입력받는 메소드
					
		System.out.print("이름 : ");
		tmp.setName(sc.next());
		
		int index 
		if(index == -1 ) {
			stds.add = tmp;
			return true;
		}
		return false;
	}

	private static Score scanScore() {
		Scanner sc = new Scanner(System.in);
		System.out.print("과목 : ");
		String title = sc.next();
		System.out.print("학기 : ");
		int term = sc.nextInt();
		System.out.print("중간 : ");
		int midScore = sc.nextInt();
		System.out.print("기말 : ");
		int finalScore = sc.nextInt();
		System.out.print("수행평가 : ");
		int performance = sc.nextInt();
		return new Score(title, term, midScore, finalScore, performance);
	}

	private static Student scanStudentBaseInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int classNum = sc.nextInt();
		System.out.print("번호 : ");
		int num = sc.nextInt();
		return new Student(grade, classNum, num);
	}


	private static void printMenu() {
		System.out.println("------메뉴------");
		System.out.println("1. 학생 정보 추가");
		System.out.println("2. 학생 성적 추가");
		System.out.println("3. 학생 정보 출력");
		System.out.println("4. 프로그램 종료");
		System.out.println("메뉴 선택 : ");
		
	}
}