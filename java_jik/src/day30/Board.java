package day30;

import lombok.Data;

/* 필드 : 게시글 번호, 제목, 내용, 작성자
 * - 게시글 번호는 게시글 등록할 때 입력해 줌.
 * - getter/setter
 * - toString : 번호, 제목, 작성자 순으로 출력
 * - equals/hashCode : 게시글 번호를 이용하여 같다고 판별
 * - print : 게시글 번호, 제목, 작성자, 내용 순으로 콘솔에 출력하는 메소드
 * - 생성자
 *  - 생성자(번호) : 번호를 이용하여 게시글 객체 생성
 *  - 생성자(번호, 제목, 내용, 작성자) : 번호, 제목, 내용, 작성자를 이용하여 게시글 객체 생성
 *  
 * */
@Data
public class Board {
	private int num;
	private String title, content, writer;
	
	@Override
	public String toString() {
		return  num + ". | 제목 : " + title + " | 작성자 : " + writer;
	}
	
	public void print() {
		System.out.println("번호 :" + num);
		System.out.println("제목 :" + title);
		System.out.println("작성자 :" + writer);
		System.out.println("내용 :" + content);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}

	public Board(int num, String title, String content, String writer) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public Board(int num) {
		this.num = num;
	}
	
	
}
