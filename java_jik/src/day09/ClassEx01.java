package day09;

public class ClassEx01 {

	public static void main(String[] args) {
		//클래스 이용 안하는 경우
		int size = 3;
		int [] x = new int [size];
		int [] y = new int [size];
		for(int i = 0; i < size; i++) {
			x[i] = i;
			y[i] = i;
		}
		for(int i = 0; i < size; i++) {
			System.out.println(x[i] + "," + y[i]);
		}
		
		//클래스 이용하는 경우
		Point [] pts = new Point [size]; // 좌표들을 저장할 배열을 할당
		for(int i = 0; i < size; i++) {
			pts[i] = new Point(i, i); // 생성자 : 좌표 하나를 저장할 객체를 생성
		}
		for(Point pt : pts) { // 클래스를 통해 pt 변수를 만들 수 있는거??
			pt.print();
		}
	}

}

class Point {
	//필드 : 멤버변수
	private int x, y;
	//생성자 : 멤버변수 초기화
	public Point() {} //혹시라도 기본생성자로 쓸 수 있기 때문에 만든거임
	public Point(int x1, int y1) {
			x = x1;
			y = y1;
	}
	//메소드 : 기능 (x + y를 출력)
	public void print() {
		System.out.println(x + " , " + y);
	}
	public void move(int x1, int y1) {
		x = x1;
		y = y1;
	}
}
