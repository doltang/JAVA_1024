package exampleAccountBook;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data // 외부에서 getter setter로 필드에 접근할 수 있다
public class Item {
// 내역 필드
	private String type, purpose, content;
	private int money;
	private Date date;
	
	// 생성자는 객체로 호출할때 쓸 수 있지 한번하고 끝난다.
	public Item(String type, String purpose, String content, int money, String date) throws ParseException {
		this.type = type;
		this.purpose = purpose;
		this.content = content;
		this.money = money;
		setDate(date);
	}
	
	public void setDate(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.date = format.parse(date);
	}
	
	public String getDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	public String getMoneyStr() {
		// 10진수 포맷
		DecimalFormat df = new DecimalFormat("###, ###");
		return df.format(money);
	}
	public void print() {
		System.out.println("=======================");
		System.out.println("구분 : " + type);
		System.out.println("분류 : " + purpose);
		System.out.println("내용 : " + content);
		System.out.println("금액 : " + getMoneyStr() + "원");
		System.out.println("일시 : " + getDateStr());
		System.out.println("=======================");
	}
	@Override
	public String toString() {
		return type + " | " + getDateStr() + " | "
				+ purpose + " | " + getMoneyStr() + "원" + " | " + content;
	}
}
