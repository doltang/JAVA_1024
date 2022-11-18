package day20;

import lombok.Data;

@Data
public class PhoneList {
	private String lastName, firstName, office;
	private PhoneNumber number;
	
	public PhoneList(String lastName, String firstName, String office) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.office = office;
		this.number = number;
	}

	public PhoneList(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public PhoneList() {
		// TODO Auto-generated constructor stub
	}

	public void update1(String newLastName, String newFirstName, String newOffice, PhoneNumber number) {
		this.lastName = newLastName;
		this.firstName = newFirstName;
		this.office = newOffice;
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneList other = (PhoneList) obj;
		if (number != other.number)
			return false;
		return true;
	}

	
}
