package day19;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateEx01 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student> ();
		list.add(new Student(1, 1, 1, "홍길동", 100, 70, 60));
		list.add(new Student(1, 2, 1, "임꺽정", 40, 50, 100));
		list.add(new Student(1, 1, 2, "고길동", 40, 50, 30));
		/* 1학년 1반 학생들을 출력하는 코드를 작성하라
		 * 1학년 2반 학생들을 출력하는 코드를 작성하라
		 * 1학년 학생들을 출력하는 코드를 작성하라*/
//		print(list, 1, 1);
//		print(list, 1);
	//	print(list, (s)->s.getGrade()==1 && s.getClassNum()==1);
	//	print(list, (s)->s.getGrade()==1);
		print(list, (s)->s.getName().charAt(0) == '홍');
	}
	public static void print(ArrayList<Student> list, Predicate<Student> p) {
		for(Student tmp: list) {
			if(p.test(tmp)) { // boolean 을 리턴하는 Predicate
				System.out.println(tmp);
			}
		}
	}
	public static void print(ArrayList<Student> list, int grade, int classNum) {
		for(Student tmp : list) {
			if(tmp.getGrade() == grade && tmp.getClassNum() == classNum) {
				System.out.println(tmp);
			}
		}
	}
		
	public static void print(ArrayList<Student> list, int grade) {
			for(Student tmp : list) {
				if(tmp.getGrade() == grade) {
					System.out.println(tmp);
				}
	}
		
//		int grade = 1;
//		int classNum = 1;
//		int classNum2 = 2;
//		for(int i = 0; i < list.size(); i++) {
//			if(list.get(i).getGrade() == grade) {
//				System.out.println("1학년 학생 명단 : " + list.get(i).getName());
//			}
//		}
//		
//		for(int i = 0; i < list.size(); i++) {
//			if(list.get(i).getClassNum() == classNum) {
//				System.out.println("1학년 1반 학생 명단 : " + list.get(i).getName());
//			}
//		}
//		
//		for(int i = 0; i < list.size(); i++) {
//			if(list.get(i).getClassNum() == classNum2) {
//				System.out.println("1학년 2반 학생 명단 : " + list.get(i).getName());
//			}
//		}
		
	}
		
		
		
}

	
