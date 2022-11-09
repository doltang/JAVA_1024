package day13;

import java.util.Scanner;

public class StudentManagerTest_2 {

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
		Student [] stds = new Student[30];
		int count = 0; // 현재 저장된 학생 수
		int menu = -1;
		// 반복문을 통해 메뉴를 출력
		for( ;menu != 4 ; ) {
			// 메뉴를 출력
			printMenu();
			// 메뉴 선택(입력)
			menu = sc.nextInt();			
			// 선택한 메뉴에 맞는 기능 실행
			count = runMenu(menu, stds, count); // count(현재저장된 학생 수)를 return하는 이유는? 메소드안에서 증가된 수를 기본 자료형으로 돌려줘야되기 때문				
		}	
	}

	private static int runMenu(int menu, Student[] stds, int count) {
		Scanner sc = new Scanner(System.in);
		
		switch(menu) {
		case 1:
			if(addStudent(stds, count)) { // 조건식(참, 거짓이 결과로 나오는식)만 넣으면 됨
				System.out.println("학생을 추가했습니다.");
				count++;
			}else {
				System.out.println("추가하지 못했습니다");
			}
			break;
		case 2: 		
			if(addScore(stds, count)) {
				System.out.println("성적을 등록했습니다");
			}else {
				System.out.println("성적 등록에 실패했습니다");
			}
			break;
		case 3 :
			printStudentList(stds, count);
			break;
		case 4 :
			System.out.println("프로그램 종료");
			break;
		default : 
			System.out.println("잘못된 메뉴!!");
		}
		return count;
	}


	private static void printStudentList(Student[] stds, int count) {
		for(int i = 0; i < count; i++) {
			System.out.println(stds[i]);
			stds[i].printScore();
		}
		
	}

	private static boolean addScore(Student[] stds, int count) {
		System.out.println("성적을 추가할 학생 정보 입력");
		Student tmp = scanStudentBaseInfo();
		int index = indexOfStudent(stds, count, tmp);
		
		if(index == -1) {
			return false; // continue는 반복문이 사라졌기 때문에 사용안함
		}
		
		System.out.println("성적 정보를 입력하세요");		
		return stds[index].addScore(scanScore());
	}

	private static boolean addStudent(Student[] stds, int count) {
		Scanner sc = new Scanner(System.in);
		System.out.println("추가할 학생 정보 입력");
					
		Student tmp = scanStudentBaseInfo(); //학년 반 번호를 입력받는 메소드
					
		System.out.print("이름 : ");
		tmp.setName(sc.next());

					
		int index = indexOfStudent(stds, count, tmp);
					
		// 일치하는 학생이 없고 학생 배열이 꽉 찬 상태가 아니면 stds[] 학생정보 리스트에 추가
		if(index == -1 && count < stds.length) {
			stds[count] = tmp;
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

	private static int indexOfStudent(Student[] stds, int count, Student tmp) {
		int index = -1; // 학생정보가 있으면 몇 번지에 있는지 알려주는 변수 
		// 현재 입력한 학생 정보를 tmp에 저장
		for(int i = 0; i < count; i++) {
			if(stds[i].equals(tmp)) { // equals를 통해 tmp가 stds[i]에 있는 학생정보와 같은지 아닌지 판단
				return i; // 일치하는 학생의 위치(번지)
			}
		}
		return -1 ; // 반복문이 끝날때까지 못찾았다 -> 없는거
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