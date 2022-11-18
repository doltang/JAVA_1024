package day20;

import lombok.Data;

@Data
public class PhoneNumber {
	private String label, num;

	public PhoneNumber(String label, String num) {
		this.label = label;
		this.num = num;
	}
	
}
