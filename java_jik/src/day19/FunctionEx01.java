package day19;

import java.util.ArrayList;
import java.util.function.Function;

public class FunctionEx01 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student> ();
		list.add(new Student(1, 1, 1, "홍길동", 100, 70, 60));
		list.add(new Student(1, 2, 1, "임꺽정", 40, 50, 100));
		list.add(new Student(1, 1, 2, "고길동", 40, 50, 30));
		
		/* 학생들의 국어 성적만 출력하는 코드를 작성하라
		 * 학생들의 영어 성적만 출력하는 코드를 작성하라
		 * 학생들의 수학 성적만 출력하는 코드를 작성하라*/
		
		// 기존에 하던 방식
//		System.out.print("국어 성적 : ");printKor(list);
//		System.out.println();
//		System.out.print("영어 성적 : ");printEng(list);
//		System.out.println();
//		System.out.print("수학 성적 : ");printMath(list);
		
		// Function
		print(list, "국어", s -> s.getKor());
		print(list, "영어", s -> s.getEng());
		print(list, "수학", s -> s.getMath());
		print(list, "총합", s -> s.getKor()+ s.getEng() + s.getMath());
	}
	// Function 사용
	public static void print(ArrayList<Student> list, String subject, Function<Student, Integer> f){
		for(Student tmp : list) {
			System.out.println(subject + " : " + f.apply(tmp)); // f고 위에는 s인데 관계업는건가>
		}
	}
	// 기존에 하던 방식
	public static void printKor(ArrayList<Student> list) {
		for(Student tmp : list) {
			System.out.print(tmp.getKor() + " ");
		}
	}
	
	public static void printEng(ArrayList<Student> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getEng()+ " ");
		}
	}
	
	public static void printMath(ArrayList<Student> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getMath()+ " ");
		}
	}
	
}
