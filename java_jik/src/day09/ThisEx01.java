package day09;

public class ThisEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test03 t1 = new Test03();
		
		Test03 t2 = new Test03(10);
	}

}
/* this : 해당 클래스를 나타내는 참조 변수
 *	- 주로 매개변수의 이름과 필드의 이름이 같으면서 메소드안에서 같이 사용될 때
 * 		=> 메소드에서 매개변수의 이름과 필드의 이름이 같으면 변수를 호출했을 때 매개변수가 불려진다
 *  - 메소드명이 길때 자동완성을 위해서 사용
 *  this() : 해당 클래스의 생성자를 호출, 생성자에서 첫번쨰 줄에 추가*/
 class Test03 {
	 private int num;
	 public void setNum(int num) {
		// num = num; // 매개변수 = 매개변수 -> 효과없음
		this.num = num; // 필드 안의 num = 매개변수
		this.print();
	 }
	 public int getNum() {
		 return num;
	 }
	 public void print() {
		 System.out.println(this.getNum());
	 }
	 //생성자
	 public Test03() {
		 this(10); // 다른 생성자를 호출할때
		 num = 20;
	 }
	 public Test03(int num) {
		 this.num = num;
	 }
 }