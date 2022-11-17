package day19;

import lombok.Data;

@Data
public class Book {
	private String name, writer, editor, translator, publisher, genre;
	private int price, isbn;
	private Book author;
	
	public Book(String name, String writer, String editor, String translator, String publisher, String genre, int price,
			int isbn) {
		super();
		this.name = name;
		this.writer = writer;
		this.editor = editor;
		this.translator = translator;
		this.publisher = publisher;
		this.genre = genre;
		this.price = price;
		this.isbn = isbn;
	}

	public Book(String writer, String editor, String translator) {
		this.writer = writer;
		this.editor = editor;
		this.translator = translator;
	}

	public Book(String name, String publisher, String genre, int price, int isbn, Book author) {
		this.name = name;
		this.publisher = publisher;
		this.genre = genre;
		this.price = price;
		this.isbn = isbn;
		this.author = author;
	}

	public Book(String name) {
		this.name = name;
	}
	
	public Book(int isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "------------------------------------------------------------------------------------------------------------------------------\n"
			   + "도서명 : " + name + " | 지은이 : " + writer + " | 엮은이 : " + editor + " | 옮긴이 : " + translator
			   + " | 출판사 : " + publisher + " | 장르 : " + genre + " | 가격 : " + price + " | ISBN : " + isbn
			   + "\n--------------------------------------------------------------------------------------------------------------------------";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// 클래스가 다른 경우 
		if (getClass() != obj.getClass()) {
			// obj가 Integer로 클래스 변환이 가능하면 게시글 번호와 obj를 비교 -> 이해 안됨
			if(obj instanceof Integer) {
				if(isbn == (Integer)obj) {
					return true;
				}
			}
			// Integer, Board2 클래스가 아니거나 게시글 번호가 다른경우
			return false;
		}
		Book other = (Book) obj;
		if (isbn != other.isbn)
			return false;
		return true;
	}


	
	
}
