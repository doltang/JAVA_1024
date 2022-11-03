package day09;

import java.util.Scanner;

public class ConstructorEx01 {

	public static void main(String[] args) {
		Test01 t1 = new Test01(); // 기본 생성자, 생성자가 따로 없고 안에 아무내용도 없을 경우 자동으로 생성
		// Test02 클래스는 기본 생성자가 없기 때문에 기본 생성자로 초기화 할 수 없다
		// Test02 t2 = new Test02(); 
		Test02 t2 = new Test02(1);
		// Scanner 클래스는 기본 생성자를 구현하지 않았기 때문에 기본생성자를 이용하여
		// 초기화 할 수 없다 => 기본생성자는 상황에 따라 쓸 수도 있고 안 쓸수도 있다
		// Scanner scan = new Scanner();
	}

}
/* 클래스에 생성자를 하나도 구현하지않으면 기본 생성자가 자동으로 추가 됨
 * 클래스에 생성자가 하나라도 있으면 기본생성자가 자동으로 추가되지 않음
 * */
class Test01{
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}

class Test02{
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	//생성자
	public Test02(int num1) {
		num = num1;
	}
	
	
}