package day24;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
	/* 학생 정보를 관리 프로그램을 작성하라
	 * 1. 학생 추가(이름, 학년, 반, 번호)
	 * 2. 학생 출력
	 * 3. 종료
	 * - 프로그램 시작 전 학생정보를 읽어오는 기능 추가(load)
	 * - 프로그램 종료 전 학생 정보를 저장하는 기능 추가(save)
	 * */
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String fileName = "student.txt";
		ArrayList<Student>list = new ArrayList<Student>();
		int menu = 0;
		load(list, fileName); // InputStream 파일 읽어오기
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu, list);
			
		}while(menu != 3);
		save(list, fileName);
	}
	private static void runMenu(int menu, ArrayList<Student> list) {
		switch(menu) {
		case 1 :
			sc.nextLine();
			if(addStudent(list)) {
				printSBar("학생정보가 추가되었습니다.");
			}else {
				printSBar("학생정보 추가에 실패했습니다.");
			}
			break;
		case 2 :
			sc.nextLine();
			printStudent(list);
			break;
		case 3 :
			printSBar("프로그램을 종료합니다.");
			break;
		default :
			printSBar("잘못된 메뉴입력입니다.");
		}
		
	}
	private static void printStudent(ArrayList<Student> list) {
		if(list == null) {
			throw new RuntimeException("예외 발생 : 학생을 관리할 리스트가 생성되지 않았습니다.");
		}
		if(list.size() == 0) {
			printSBar("학생 정보가 없습니다.");
			return;
		}
		for(Student tmp : list) {
			System.out.println(tmp);
		}
		printBar();		
	}
	private static boolean addStudent(ArrayList<Student> list) {
		if(list == null) {
			throw new RuntimeException("예외 발생 : 학생을 관리할 리스트가 생성되지 않았습니다.");
		}
		System.out.print("이름 :");
		String name = sc.nextLine();
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int classNum = sc.nextInt();
		System.out.print("번호 : ");
		int num = sc.nextInt();
		
		Student std = new Student(name, grade, classNum, num);
		int index = list.indexOf(std);
		if(index != -1) {
			return false;
		}
		
		// 학년, 반, 번호가 같으면 false
		for(Student tmp : list) {
			if(tmp.equals(std)) {
				return false;
			}				
		}
		list.add(std);
		return true;				
	}
	private static void printMenu() {
		System.out.println("=============메뉴=============");
		System.out.println("1. 학생 추가(이름, 학년, 반, 번호)");
		System.out.println("2. 학생 출력");
		System.out.println("3. 종료");
		System.out.println("------------------------------");		
		System.out.print("메뉴 선택 : ");
	}
	private static void printSBar(String str) {
		System.out.println(str);
		printBar();	
	}
	private static void printBar() {
		System.out.println("------------------------------");	
	}
	
	private static void save(ArrayList<Student> list, String fileName) {
		if(list == null) {
			throw new RuntimeException("예외 발생 : 학생을 관리할 리스트가 생성되지 않았습니다.");
		}
		
		try(ObjectOutputStream oos = 
				new ObjectOutputStream(new FileOutputStream(fileName))) {
			for(Student tmp : list) {
				oos.writeObject(tmp);
			}
			printSBar("저장했습니다.");
		} catch (FileNotFoundException e) { // 폴더가 없으면 파일을 생성 할 수 없다. (파일이 없으면 자동생성)
			printSBar(fileName + "을 생성할 수 없어서 저장에 실패했습니다.");
		} catch (IOException e) { // 파일 열기에 성공했지만 ObjectOutputStream으로 열 수 없을 때
			printSBar("저장에 실패했습니다.");
		}
		
//		ObjectOutputStream oos = null;
//		try {
//			oos = new ObjectOutputStream(new FileOutputStream(fileName));
//		} catch (FileNotFoundException e) { // 폴더가 없으면 파일을 생성 할 수 없다. (파일이 없으면 자동생성)
//			printSBar(fileName + "을 생성할 수 없어서 저장에 실패했습니다.");
//		} catch (IOException e) { // 파일 열기에 성공했지만 ObjectOutputStream으로 열 수 없을 때
//			printSBar("저장에 실패했습니다.");
//		}finally {
//				try {
//					if(oos != null)
//					oos.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//		}
		
	}
	private static void load(ArrayList<Student> list, String fileName) {
		if(list == null) {
			throw new RuntimeException("예외 발생 : 학생을 관리할 리스트가 생성되지 않았습니다.");
		}
		
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))) {
			while(true) {
				Student std = (Student)ois.readObject();
				list.add(std);
			}
		} catch (FileNotFoundException e) { // 폴더가 없으면 파일을 생성 할 수 없다. (파일이 없으면 자동생성)
			printSBar(fileName + "이 없어서 불러오기에 실패했습니다.");
		} catch(EOFException e) {
			printSBar("불러오기 완료");
		}
		catch (Exception e) { // 파일 열기에 성공했지만 ObjectOutputStream으로 열 수 없을 때
			printSBar("불러오기에 실패했습니다.");
		} 

		
	}

}
