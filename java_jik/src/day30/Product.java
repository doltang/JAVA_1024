package day30;

import lombok.Data;

@Data
public class Product {
	private String section, name;
	int num, buyPrice, salePrice;
	
	public Product(String section, String name, int num, int buyPrice, int salePrice) {
		this.section = section;
		this.name = name;
		this.num = num;
		this.buyPrice = buyPrice;
		this.salePrice = salePrice;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	
	
}
