package day22;

import lombok.Data;

@Data
public class Student {
	private String name;
	private int dateOfBirth;
	
	public Student(String name, int dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public void update(String name, int dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		
	}




	
}
