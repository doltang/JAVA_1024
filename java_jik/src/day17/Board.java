package day17;

import lombok.Data;

@Data
public class Board {
	public int num, view;
	private String title, content, writer;
	
	public Board(int num, int view, String title, String content, String writer) {
		num = 0;
		view = 0;
		title = null;
		content = null;
		writer = null;
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
