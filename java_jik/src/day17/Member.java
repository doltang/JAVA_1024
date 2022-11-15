package day17;

import lombok.Data;

@Data
public class Member {
	private String pw, name, residentNum;
	private int age;
	
	// 생성자
	public Member(String pw, String name, String residentNum, int age) {
		this.pw = pw;
		this.name = name;
		this.residentNum = residentNum;
		this.age = age;
	}

	public void update(String newPw, String name, String residentNum, int age) {
		this.pw = newPw;
		this.name = name;
		this.residentNum = residentNum;
		this.age = age;		
	}
	
}
