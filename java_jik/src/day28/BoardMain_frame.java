package day28;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BoardMain_frame {
	
	/* 게시글 관리 프로그램
	 * - 회원가입
	 *  - 처음 가입한 회원이 관리자, 그외 회원은 일반회원
	 * - 로그인
	 * - 게시글 등록/수정/삭제 => 회원만 가능
	 * - 카테고리 관리 (공지, 자유)
	 * - 카테고리 추가/수정/삭제 (관리자만 가능)
	 * 
	 * - 기능
	 *  - 회원관리
	 *   - 로그인
	 *   - 회원가입
	 *  - 게시글 관리
	 *   - 게시글 등록 (회원만)
	 *   - 게시글 수정 (회원 + 작성자 본인)
	 *   - 게시글 삭제 (회원 + 작성자 본인)
	 *   - 게시글 목록
	 *    - 게시글 검색 (검색 번호는 게시글 번호로)
	 *    - 게시글 확인
	 *  - 카테고리 관리 (회원 + 관리자만)
	 *   - 카테고리 추가
	 *   - 카테고리 수정
	 *   - 카테고리 삭제  
	 * */
	private static Scanner sc = new Scanner(System.in);
	private static List<Object> memberList = new ArrayList<Object>();
	private static List<Object> boardList = new ArrayList<Object>();
	
	public static void main(String[] args) {
		int menu = 0;
		do {
			try {
				printMenu();
				menu = sc.nextInt();
				sc.nextLine(); // 위에서 입력한 엔터를 비움
				printBar();
				runMenu(menu);
			}catch (InputMismatchException e) {
				sc.nextLine(); // 잘못된 문자열들을 비워 줌
				printStr("숫자를 입력하세요.");
			}
			catch(Exception e) {
				printStr(e.getMessage());
			}
		}while(menu != 4);

	}
	
	private static void runMenu(int menu) {
		switch(menu) {
		case 1 :
			Object obj = new Object();
			// 로그인 체크 => 로그인한 사람은 로그인/회원가입 시도 x
			if(isLogin(obj)) {
				printStr("이미 로그인이 되어있습니다.");
				return;
			}
			// 서브 메뉴 출력
			
			// 서브 메뉴 선택 및 선택한 서브 메뉴에 맞는 기능 실행 => 반복
				// 1. 회원가입
					// 회원 정보 입력
			
					// 가입된 아이디인지 체크
					
					// 가입된 아이디가 아니면 회원가입 진행
				
				// 2. 로그인
					// 회원 정보 입력(아이디,비번)
			
					// 일치하는 회원이 있으면 회원 정보를 가져옴(로그인 성공)
			
					// 로그인 성공하면 서브 메뉴를 3으로 수정하여 자동으로 메인 이동
			
				// 3. 이전
				
			break;
		case 2 : 
			// 서브 메뉴 출력
			
			// 서브 메뉴 선택 및 선택한 서브 메뉴에 맞는 기능 실행
				// 1. 게시글 등록
					// 회원 체크 => 회원(로그인한 사용자)이 아니면 게시글 등록 못함
			
					// 게시글 정보(제목, 내용) 입력
				// 2. 게시글 수정
					// 회원 체크 => 회원(로그인한 사용자)이 아니면 게시글 등록 못함
			
					// 수정할 게시글 번호 입력
			
					// 해당 게시글이 존재하지 않거나 작성자가 회원과 같지 않으면 수정 못함
			
					// 게시글 정보(제목, 내용) 입력
			
					// 게시글 수정
			
				// 3. 게시글 삭제
					// 회원 체크 => 회원(로그인한 사용자)이 아니면 게시글 등록 못함
					
					// 삭제할 게시글 번호 입력
			
					// 해당 게시글이 존재하지 않거나 작성자가 회원과 같지 않으면 삭제 못함
			
					// 해당 게시글 삭제
				// 4. 게시글 목록
					// 서브 메뉴 출력
			
					// 서브 메뉴 선택 및 기능 실행
						// 1. 게시글 목록 확인
							// 모든 게시글 확인
			
						// 2. 게시글  검색
							// 검색어 입력 후 게시글 확인
			
						// 3. 게시글 확인
							// 게시글 번호를 입력
			
							// 입력한 게시글이 있으면 확인
			
						// 4. 이전
				// 5. 이전
			
			break;
		case 3 :
			// 관리자 체크 => 관리자가 아니면 메인 메뉴로
			
			// 서브 메뉴 출력
			
			// 서브 메뉴 선택 및 선택한 서브 메뉴에 맞는 기능 실행
				// 1. 카테고리 추가
					// 새 카테고리명 입력
			
					// 기존 카테고리에 있는지 확인하녀 없으면 추가
			
				// 2. 카테고리 수정
					// 수정할 카테고리명 입력
			
					// 새 카테고리명 입력
			
					// 기존 카테고리에 있는지 확인하여 없으면 수정
			
				// 3. 카테고리 삭제
					// 삭제할 카테고리명 입력
			
					// 기존 카테고리에 있으면 삭제
			
				// 4. 카테고리 확인
					// 모든 카테고리 출력
			
				// 5. 이전
			break;
		case 4 :
			printStr("프로그램을 종료합니다.");
			break;
		default :
			throw new RuntimeException("잘못된 메뉴를 선택했습니다.");
		}
		
	}
	
	private static boolean isLogin(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	private static void printMenu() {
		System.out.println("==========메뉴==========");
		System.out.println("1. 회원 관리");
		System.out.println("2. 게시글 관리");
		System.out.println("3. 카테고리 관리");
		System.out.println("4. 종료");
		printBar();
		System.out.print("메뉴 선택 : ");
		
	}
	
	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}
	
	private static void printBar() {
		System.out.println("------------------------");
	}
			
}
