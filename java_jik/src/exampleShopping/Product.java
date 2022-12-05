package exampleShopping;

import lombok.Data;

@Data
public class Product {
	private String type;
	private String title;
	private int amount;
	private final int buyPrice; // 상수로 지정하게되면 set으로 값 못바꿈, 오직 생성자로만 값 바꿀 수 있음
	private final int sellPrice;
	
	public Product(String type, String title, int buyPrice, int sellPrice) {
		this.type = type;
		this.title = title;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}
	
	// 수량을 증가, 감소 시키는 메소드
	public void addAmount(int amount) {
		this.amount += amount;
	}

	@Override
	public String toString() {
		return "[ 분류 : " + type 
				+ " | 제품명 : " + title 
				+ " | 수량 : " + amount 
				+ " | 판매가 : " + buyPrice
				+ " | 구매가 : " + sellPrice + "]";
	}

	// 분류와 제품명으로 같은 제품인지 판별
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
	// 깊은 복사해주는 생성자
	public Product (Product p) {
		this.type = p.type;
		this.title = p.title;
		this.amount = p.amount;
		this.buyPrice = p.buyPrice;
		this.sellPrice = p.sellPrice;
	}
	
}
