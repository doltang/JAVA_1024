package day13;

import java.util.Scanner;

public class StudentManagerTest_1 {

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
		// 반복문을 통해 메뉴를 출력
		for( ; ; ) {
			// 메뉴를 출력
			System.out.println("------메뉴------");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 성적 추가");
			System.out.println("3. 학생 정보 출력");
			System.out.println("4. 프로그램 종료");
			System.out.println("메뉴 선택 : ");
			// 메뉴 선택(입력)
			int menu = sc.nextInt();
			
			// 선택한 메뉴에 맞는 기능 실행
			if(menu == 1) {
				// 1. 학생 정보 추가
				// 학생 정보를 입력(학년, 반, 번호, 이름)
				System.out.println("추가할 학생 정보 입력");
				System.out.print("학년 : ");
				int grade = sc.nextInt();
				System.out.print("반 : ");
				int classNum = sc.nextInt();
				System.out.print("번호 : ");
				int num = sc.nextInt();
				System.out.print("이름 : ");
				String name = sc.next();
				
				// 입력한 학생 정보가 없으면 추가
				// 학생 정보들 중에서 하나씩 비교하여 학년, 반, 번호가 같은 학생이 있는지 확인해서
				// 없으면 마지막 학생 뒤에 추가
				int index = -1; // 학생정보가 있으면 몇 번지에 있는지 알려주는 변수 
				// 현재 입력한 학생 정보를 tmp에 저장
				Student tmp = new Student(grade, classNum, num, name);
				for(int i = 0; i < count; i++) {
					if(stds[i].equals(tmp)) { // equals를 통해 tmp가 stds[i]에 있는 학생정보와 같은지 아닌지 판단
						index = i; // 일치하는 학생의 위치(번지)
					}
				}
				// 일치하는 학생이 없고 학생 배열이 꽉 찬 상태가 아니면 stds[] 학생정보 리스트에 추가
				if(index == -1 && count < stds.length) {
					stds[count] = tmp;
					count++; // 저장된 학생 수 추가
				}
				
			}else if(menu == 2) {
				// 2. 학생 성적 추가
				// 학생 정보를 입력(학년, 반, 번호)
				System.out.println("성적을 추가할 학생 정보 입력");
				System.out.print("학년 : ");
				int grade = sc.nextInt();
				System.out.print("반 : ");
				int classNum = sc.nextInt();
				System.out.print("번호 : ");
				int num = sc.nextInt();
				System.out.println(grade + "학년 " + classNum + "반 " + num + "번 ");
				// 입력한 학생 정보가 없으면 끝
				// 입력한 성적 정보가 없으면 추가
				// 학생 정보들 중에서 하나씩 비교하여 학년, 반, 번호가 같은 학생이 있는지 확인해서
				// 없으면 조건문 종료 (continue)
				int index = -1; // 학생정보가 있으면 몇 번지에 있는지 알려주는 변수
				Student tmp = new Student(grade, classNum, num); // 현재 입력된 학생 정보
				for(int i = 0; i < count; i++) {
					if(stds[i].equals(tmp)) {
						index = i; // 일치하는 학생의 위치(번지)
					}
				}
				if(index == -1) {
					continue; // 조건식으로 바로 건너 뛰기 -> 왜 break가 아니지? 그럼 했던거 또 하는거 아닌가?
				}
				// 성적 정보를 입력(과목, 학기, 중간, 기말, 수행평가)
				System.out.println("성적 정보를 입력하세요");
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
				// 입력한 성적 정보가 없으면 추가
				// 선택한 학생의 성적 정보들 중에서 과목, 학기가 같은 정보가 없으면 추가
				boolean res = stds[index].addScore(new Score(title, term, midScore, finalScore, performance));
				if(res) {
					System.out.println("성적을 등록했습니다");
				}else {
					System.out.println("성적 등록에 실패했습니다");
				}
				stds[index].printScore();
			}else if(menu == 3) {
				// 3. 학생 정보 출력
				for(int i = 0; i < count; i++) {
					System.out.println(stds[i]);
				}
				// 저장된 학생 정보를 출력
			}else if(menu == 4) {
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("잘못된 메뉴!!");
			}
				
		}	
	}
}