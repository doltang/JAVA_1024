package day07;

public class ClassTestEx01 {

	public static void main(String[] args) {
		/* 인스턴스화 방법(객체를 만드는 방법)
		 * 클래스명 객체명 = new 클래스명();
		 * 
		 * */
		String str = new String("apple"); //String도 객체
		Person person1 = new Person();
		//pNo에 private을 추가하기 전에는 외부에서 접근이 가능했지만
		// 캡슐화를 통해 pNo의 접근제한자를 private으로 설정하면 직접 접근이 불가능 -> 에러 발생
		//person1.name = "홍길동"; // 객체의 멤버변수에 접근하는 방법 // 객체.멤버변수명
		//캡슐화된 pNo에 접근하려면 getter와 setter를 통해 접근해야 한다
		person1.setpNo("000101 - 321212"); // setter
		//System.out.println("이름 : " + person1.name);
		System.out.println("주민번호 : " + person1.getpNo()); // getter
		System.out.println(str.charAt(0)); // charAt()은 str객체의 메소드
	}

}
/*
class 클래스 명{
	접근제한자 자료형 변수명; // 멤버변수
}
*/
/* 접근제한자 종류
 * - private	: 본인 클래스 //일반적으로 멤버변수는 private
 * - (default)	: 본인 클래스 + 같은 패키지(접근제한자를 안쓴 상태가 default)
 * - protected	: 본인 클래스 + 같은 패키지 + 자식 클래스
 * - public		: 본인 클래스 + 같은 패키지 + 자식 클래스 + 외부 클래스 => 전부
 * */
class Person{
	private String pNo;
	private String name;
	private char gender;
	private String address;
	private String phone;
	private int age;
	
	public String getpNo() {
		return pNo;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
//	// setter : 외부에서 접근하려면 필요
//	public void setPNo(String personNumber) {
//		pNo = personNumber;
//	}
//	//getter
//	public String getPNo() {
//		return pNo;
//	}
}