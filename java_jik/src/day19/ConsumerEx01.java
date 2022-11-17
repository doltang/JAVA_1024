package day19;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ConsumerEx01 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student> ();
		list.add(new Student(1, 1, 1, "홍길동"));
		list.add(new Student(1, 2, 1, "임꺽정"));
		list.add(new Student(1, 1, 2, "고길동"));
		
		// 하나의 메소드로 결과를 다양하게 사용자 마음대로 할 수 있는 람다식 Consumer
		print(list, (a) -> System.out.println(a));
		
		print(list, (a) -> {
			System.out.println("-----------------------");
			System.out.println("학년 : " + a.getGrade());
			System.out.println("반 : " + a.getClassNum());
			System.out.println("번호 : " + a.getNum());
			System.out.println("이름 : " + a.getName());
			System.out.println("-----------------------");
		});
	}
	
	public static void print(ArrayList<Student> list, Consumer<Student> con) {
		for(Student tmp : list) {
			con.accept(tmp);
		}
		
	}
}
