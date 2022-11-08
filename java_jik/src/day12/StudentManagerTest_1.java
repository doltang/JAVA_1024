package day12;

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
			
			if(menu == 1) {
				System.out.println("1. 학생 정보 추가 기능 구현 예정");
				// 선택한 메뉴에 맞는 기능 실행
				// 1. 학생 정보 추가
				// 학생 정보를 입력(학년, 반, 번호, 이름)
				// 입력한 학생 정보가 없으면 추가
			}else if(menu == 2) {
				System.out.println("2. 학생 성적 추가 기능 구현 예정");
				// 2. 학생 성적 추가
				// 학생 정보를 입력(학년, 반, 번호)
				// 입력한 학생 정보가 없으면 끝
				
				// 성적 정보를 입력(과목, 학기, 중간, 기말, 수행평가)
				// 입력한 성적 정보가 없으면 추가
			}else if(menu == 3) {
				// 3. 학생 정보 출력
				// 저장된 학생 정보를 출력
				System.out.println("3. 학생 정보 출력 기능 구현 예정");
			}else if(menu == 4) {
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("잘못된 메뉴!!");
			}
				
		}	
	}
}