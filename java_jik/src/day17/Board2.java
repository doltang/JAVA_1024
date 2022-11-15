package day17;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data // getter setter 추가
public class Board2 {
	// 게시글 번호를 위한 클래스 변수
	private static int count = 0;
	// 게시글에 필요한 정보
	private String title, content, writer;
	private int views, num;
	private Date date;
	
	public Board2(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		date = new Date(); // 현재시간
		++count; // 오로지 해당 생성자에서만 count를 증가시킨다!
		num = count;
	}
	public Board2(int num) {
		this.num = num;
	}
	//date=Tue Nov 15 19:26:43 KST 2022 -> date의 출력방식을 바꾸고 싶음
	// @Date로 이미 게터세터가 있지만 출력형식이 마음에 안드므로 새로 만들어준다
	// getter를 새로 생성해서 date의 출력 방식을 바꾼다
	public String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
	// 출력방식이 마음에 안드므로 toString의 출력 방식을 깔끔하게 바꾼다
	@Override
	public String toString() {
		return num + "\t" + title + "  " + writer + "  " + views + "  " + getDate();
	}
	
	public String print() {
		return "-------------------\n"
				+ "제목 : " + title + "\n"
				+ "내용 : " + content + "\n"
				+ "작성자 : " + writer + "\n" 
				+ "조회수 : " + views + "\n" 
				+ "작성일 : " + getDate() + "\n" //그냥 date하면 읽기 힘든 영문으로 나오므로get으로 가져온다
				+ "-------------------";
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
				if(num == (Integer)obj) {
					return true;
				}
			}
			// Integer, Board2 클래스가 아니거나 게시글 번호가 다른경우
			return false;
		}
		Board2 other = (Board2) obj;
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
	public void update(String title, String content) {
		this.title = title;
		this.content = content;
		
	}
	//조회수가 증가하는메소드
	public void updateViews() {
		views++;
		
	}
	
}
