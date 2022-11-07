package day11;

public class InheritanceEx01 {

	public static void main(String[] args) {
		/* A is a B로 표현이 가능하면 상속이 가능하다
		 * A가 자식 클래스, B가 부모 클래스
		 * 스마트폰은 폰이다 => O
		 * 스마트 폰은 카메라이다 => X
		 * 폰은 스마트 폰이다 => X
		 * 현대차는 자동차이다 => O
		 * A has a B로 표현이 가능하면 포함을 한다 => B가 A클래스의 필드로 선언
		 * 스마트폰은 카메라를 가지고 있다 => o
		 * 자동차는 바퀴를 가지고 있다 => o*/
		Child1 c = new Child1();
		c.print(); // Parent1 에서 상속받았기 때문에 Child1에서 사용이 가능!

	}

}
class Child1 extends Parent1{
	//  생성자
	public Child1() {
		super(1,2,3); // 만일 부모 생성자가 추가되면 기본 생성자가 없어지기 때문에 
					  // 반드시 자식 클래스의 맨 첫 줄에 써줘야 한다
		// super(); 부모 생성자를 명시하지 않아도 자동으로 super()가 추가가 된다
		//num1 = 10; // 접근 제한자가 private이어서 자식 클래스에서 사용하지 못함
		num2 = 20; // 접근 제한자가 디폴트이어서 같은 패키지에 있기 때문에 가능
				   // 상속 여부와 상관이 없다 (같은 패키지냐 아니냐가 중요)
		num3 = 30; // 접근제한자가 protected여서 자식 클래스에서 사용할 수있다
				   // 다른 패키지여도 사용 가능
	}
	@Override // 생략해도 괜찮지만 이렇게 해주면 이름을 변경하거나 매개변수를 추가할때 에러표시를 표시한다
			  // 오버라이딩 메소드 인것을 표시, 만약 오버라이드 안할 거면 지워주면된다
	public void print() {
		super.print(); // 부모의 메소드를 호출해서 가져온다
		System.out.println("자식 클래스의 메소드 입니다.");
	}
}
class Parent1{
	private int num1 =1;
	int num2 = 2;
	protected int num3 = 3;
	
	public void print() {
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
	}
	public Parent1(int num1, int num2, int num3) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}
	
	
	
	
}
