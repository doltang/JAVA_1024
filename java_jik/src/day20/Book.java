package day20;

import lombok.Data;

@Data
public class Book {
	// 필드 => 객체를 나타내는 정보
	private String title, author, publisher, genre, isbn;
	private int price;
	
	// 생성자 => 필드 초기화 // 생성자는 거의 public, private이면 외부에서 객체를 생성하지 못한다
	public Book(String title, String author, String publisher, String genre, String isbn, int price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
		this.isbn = isbn;
		this.price = price;		
	}

	// 메소드 => 기능
	// getter, setter => @Data으로 처리(또는 @Getter, @Setter로 처리)
	// toString 오버라이드 => 도서 정보를 간단하게 문자열로 만들기 위해 => @Data, @ToString
	// equals 오버라이드 => 상황에 따라 오버라이딩 => @Data, @EqualsAndHashCode
	// isbn만 중복비교를 해주기 위해서 isbn 항목만 체크하고 equals를 다시 오버라이드해준다. (따로 안하면 필드 전체가 같아야만 중복으로 처리)
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}
	
	
}
