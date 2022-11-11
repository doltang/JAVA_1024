package day15;

import day14.Student;

public class Todo {
	private String todo;
	

	public Todo(String todo) {
		this.todo = todo;
	}
	
	@Override
	public String toString() {
		return "오늘의 할 일 : " + todo;
	}


}
