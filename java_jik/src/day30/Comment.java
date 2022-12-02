package day30;

import lombok.Data;

/* 필드 : 댓글 번호, 내용, 작성자
 * getter, setter
 * toString
 * 생성자 : 댓글 번호, 내용, 작성자
 * */
@Data
public class Comment {
	private int commentNum;
	private String content, commentor;
	private int boardNum;
	
	
	@Override
	public String toString() {
		return commentNum + ". " + commentor + " :  " + content;
	}


	public Comment(int commentNum, String commentor, String content, int boardNum) {
		this.commentNum = commentNum;
		this.commentor = commentor;
		this.content = content;
		this.boardNum = boardNum;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (commentNum != other.commentNum)
			return false;
		return true;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commentNum;
		return result;
	}


	
}
