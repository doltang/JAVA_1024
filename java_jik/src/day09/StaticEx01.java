package day09;

public class StaticEx01 {

	public static void main(String[] args) {
		//ClassEx01.main(null); // static을 통해 클래스 이름으로 메소드나 필드 호출 가능
		kiaCar k1 = new kiaCar("모닝");
		kiaCar k2 = new kiaCar("레이");
		kiaCar k3 = new kiaCar("k3");
		k1.print();
		k2.print();
		k3.print();
		k1.name = "k5";
		k1.logo = "k5";
		// k1.logo = "kia"; // 가능은 하지만 일반적이진 않다
		kiaCar.logo = "kia";
		System.out.println("----------");
		k1.print();
		k2.print();
		k3.print();
	}

}
class kiaCar{
	public static String logo = "KIA"; 
	public String name;
	public kiaCar(String name) {
		this.name = name;
	}
	public void print() {
		System.out.print(logo);
		System.out.println(":" + name + " ");
	}
	public static void printLogo() {
		System.out.print(logo);
		//System.out.println(":" + name + " "); //에러 발생 :static이 안붙은 필드이기 때문
	}
}