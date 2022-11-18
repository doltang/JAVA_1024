package day20;

import lombok.Data;

@Data
public class PhoneList2 {
	String lastName, firstName, office, num;
	
	public PhoneList2(String lastName, String firstName, String office, String num) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.office = office;
		this.num = num;
	}

	public PhoneList2(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneList2 other = (PhoneList2) obj;
		if (num != other.num)
			return false;
		return true;
	}

	
}
