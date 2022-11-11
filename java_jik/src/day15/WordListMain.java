package day15;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import day14.Student;

public class WordListMain {
	/* 영어 단어장 프로그램을 구현하세요.
	 * 메뉴
	 * 1. 단어 추가
	 * 2. 단어 확인
	 * 3. 단어 수정
	 * 4. 단어 삭제
	 * 5. 종료
	 * -----------
	 * 메뉴 선택 : 1
	 * -----------
	 * 단어 : apple [한 단어, 공백 입력 안함]
	 * 뜻 : 사가	[한 문장]
	 * -----------
	 * 메뉴
	 * 1. 단어 추가
	 * 2. 단어 확인
	 * 3. 단어 수정
	 * 4. 단어 삭제
	 * 5. 종료
	 * -----------
	 * 메뉴 선택 : 2
	 * -----------
	 * 단어 입력 : apple
	 * -----------
	 * 뜻 : 사가
	 * 메뉴
	 * 1. 단어 추가
	 * 2. 단어 확인
	 * 3. 단어 수정
	 * 4. 단어 삭제
	 * 5. 종료
	 * -----------
	 * 메뉴 선택 : 3
	 * -----------
	 * 단어 입력 : apple
	 * -----------
	 * 1. apple : 사가
	 * 수정할 번호 : 1
	 * 뜻 : 사과
	 * 수정이 완료되었습니다
	 * 메뉴
	 * 1. 단어 추가
	 * 2. 단어 확인
	 * 3. 단어 수정
	 * 4. 단어 삭제
	 * 5. 종료
	 * -----------
	 * 메뉴 선택 : 4
	 * -----------
	 * 단어 입력 : apple
	 * -----------
	 * 1. apple : 사과
	 * 삭제할 번호 : 1
	 *  메뉴
	 * 1. 단어 추가
	 * 2. 단어 확인
	 * 3. 단어 수정
	 * 4. 단어 삭제
	 * 5. 종료
	 * -----------
	 * 메뉴 선택 : 5
	 * -----------
	 * 프로그램 종료
	 * */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<WordList> wordList = new ArrayList<WordList>();
		int menu = -1; // 예외처리를 하기때문에 -1로 초기화하는것, 1미만의  숫자만 입력하면 된다 (기능에 포함 안되는 숫자)
		do {
			printMenu();
			
			try {
				menu = sc.nextInt();
				runMenu(menu, wordList);
			}catch(InputMismatchException e) {
				System.out.println("-------------");
				System.out.println("예외 발생 : 정수를 입력하세요");
				System.out.println("-------------");
				sc.nextLine(); // 잘못 입력한 문자를 없애주는 역할
			}catch(Exception e) {
				System.out.println("-------------");
				System.out.println(e.getMessage());
				System.out.println("-------------");
			}
			
		}while(menu != 5);
	}

	private static void runMenu(int menu, ArrayList<WordList> wordList) throws Exception {
		Scanner sc = new Scanner(System.in);
		switch(menu) {
		case 1 :
			insertWord(wordList);
			break;
		case 2 :
			printWord(wordList);
			break;
		case 3 :
			updateWord(wordList);
			break;
		case 4 :
			deleteWord(wordList);
			break;
		case 5 :
			System.out.println("프로그램을 종료합니다");
			break;
		default :
			throw new Exception("예외 발생 : 잘못된 입력입니다");
		}
		
	}
	private static void deleteWord(ArrayList<WordList> wordList) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 단어 입력 : ");
		String word = sc.next();
		ArrayList<Integer> indexList = findWordList(wordList, word);
		System.out.println(indexList);
		if(indexList == null || indexList.size()== 0) {
			throw new Exception("예외 발생 : 삭제하려는 단어가 단어장에 없습니다.");
		}
		for(int i = 0; i < indexList.size(); i++) {
			int index = indexList.get(i);
			System.out.println(i+1 + ". " + wordList.get(index));
		}
		System.out.print("삭제할 단어 번호 : ");
		int index = sc.nextInt()-1;
		
		if(index < 0 || index >= indexList.size()) {
			throw new Exception("삭제할 번호를 잘못 선택했습니다.");
		}
		wordList.remove((int)indexList.get(index)); // 번지를 의미하는 int로 바꿔야 한다
		System.out.println("삭제가 완료되었습니다.");
	}

	/*
	 * apple : 사과
	 * play : 놀다
	 * play : 놀이
	 * boy : 소년
	 * play : 수행하다
	 * */
	private static void updateWord(ArrayList<WordList> wordList) throws Exception { // 예외가 발생할수있다는 것을 명시
		Scanner sc = new Scanner(System.in);
		// 수정할 단어 입력 : play
		System.out.print("수정할 단어 입력 : ");
		String word = sc.next();
		// 단어장에서 입력 단어와 일치하는 단어 객체들을 가져옴(???)
		// 실제 단어 번지 : 1, 2, 4
		// 0번지 : 1, 1번지 : 2, 2번지 : 4
		ArrayList<Integer> indexList = findWordList(wordList, word);
		System.out.println(indexList);
		// 가져온 단어 객체들을 출력
		// 화면에서 보여준 단어 번호 : 1, 2, 3
		if(indexList == null || indexList.size()== 0) {
			throw new Exception("예외 발생 : 수정할 번호를 잘못 입력했습니다.");
		}
		for(int i = 0; i < indexList.size(); i++) {
			int index = indexList.get(i);
			System.out.println(i+1 + ". " + wordList.get(index));
		}
		// 수정할 단어 번호를 입력 : 3번 입력 => 4번지 객체
		System.out.print("수정할 단어 번호 : ");
		int index = sc.nextInt()-1;
		
		if(index < 0 || index >= indexList.size()) {
			throw new Exception("번호를 잘못 선택했습니다.");
		}
		sc.nextLine();
		// 수정할 뜻을 입력
		System.out.print("수정할 뜻 입력 : ");
		String mean = sc.nextLine();
		
		// 선택된 단어의 뜻을 수정
		WordList tmp = wordList.get(indexList.get(index));
		tmp.setMean(mean);
		System.out.println("수정이 완료되었습니다.");
		// wordList.set(indexList.get(index),tmp); -> 이 과정 대신 tmp로 가져오는것이 더 간편
	}

	private static ArrayList<Integer> findWordList(ArrayList<WordList> wordList, String word) {
		ArrayList<Integer> list = new ArrayList<Integer>(); // 같은 단어들을 가진 번지수를 저장하는 list
		for(int i = 0; i < wordList.size(); i++) {
			if(wordList.get(i).equals(word)) {
				list.add(i); // 중복되는 번지수를 list에 저장
			}
		}
		
		return list;
	}

	private static void insertWord(ArrayList<WordList> wordList) {
		Scanner sc = new Scanner(System.in);
		// 단어 입력
		System.out.println("단어 입력 : ");
		String word = sc.next(); // 공백을 제외한 부분(엔터 포함)을 가져간다 
		sc.nextLine(); // 위에서 입력한 엔터를 처리
		// 뜻 입력
		System.out.println("뜻 입력 : ");
		String mean = sc.nextLine(); // 엔터를 흡수 -> 엔터를 입력한걸로 처리해서 문자열을 못가져감
		// 단어 객체
		WordList tmp = new WordList(word, mean);
		// 리스트에 단어 객체를 추가
		wordList.add(tmp);
		
	}


	private static void printWord(ArrayList<WordList> wordList) {
		if(wordList == null || wordList.size() == 0) {
			System.out.println("------------------");
			System.out.println("저장된 단어가 없습니다");
			System.out.println("------------------");
			return;
		}
		System.out.println("------------------");
		for(WordList tmp : wordList) {
			System.out.println(tmp);
		}
		System.out.println("------------------");
		
	}

	private static void printMenu() {
		System.out.println("---- 메뉴 ----");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 확인");
		System.out.println("3. 단어 수정");
		System.out.println("4. 단어 삭제");
		System.out.println("5. 종료");
		System.out.println("-------------");
		System.out.print("메뉴 입력 : ");
		
	}
	

}
