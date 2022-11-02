package day08;

public class ClassEx01 {

	public static void main(String[] args) {
		Point pt = new Point();
		pt.print(); // 0, 0 멤버변수는 자동으로 초기화 되어있음
		pt.move(5, 3);
		pt.print();
		//생성자 오버로딩 호출
		Point pt1 = new Point(3,1);
		pt1.print();
		//복사 생성자 호출(생성자 오버로딩)
		Point pt2 = new Point(pt1);
		pt2.print();

	}

}

/* 2차원 좌표 평면의 점을 나타내는 클래스
 * - 필드(멤버변수)
 * 	x 좌표, y 좌표
 * - 메소드(기능)
 * 	좌표 출력 기능 
 *  좌표 이동 기능
 * */
// 클래스
 class Point{
	 // 필드
	 private int x, y;
	 public void print() { // 필드에 있는 정보일 경우, 매개변수가 필요없음
		 System.out.println("좌표 : " +  x + "," + y);
	 }
	 // 메소드
	 public void move(int x1, int y1) {
		 x = x1;
		 y = y1;
	 }
	 // 생성자 // void 필요 없음, 필드의 기본값이 됨
	 public Point() {
		 x = 3;
		 y = 3; 
	 }
	 public Point(int x1, int y1) {
		 x = x1;
		 y = y1;
	 }
	 public Point(java.awt.Point pt) {
		 x = pt.x;
		 y = pt.y;
	 }
 }