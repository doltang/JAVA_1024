package day27;

import lombok.Data;

@Data
public class Member {
	private String name, id, ps, state;

	public Member(String name, String id, String ps) {
		this.name = name;
		this.id = id;
		this.ps = ps;
	}

	public Member(String name, String id, String ps, String state) {
		this.name = name;
		this.id = id;
		this.ps = ps;
		this.state = state;
	}
	
}
