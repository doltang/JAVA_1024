package practice;

public class UserManager {
	private String id;
	private String pw;
	private String name;
	private int age;
	private int socialNum;
	
	public UserManager(String id, String pw, String name, int age, int socialNum) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.socialNum = socialNum;
	}
	
	
	public UserManager(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "[ id : " + id +  "/ pw : " + pw + 
				"/ name : " +  name + "/ age : " + age + "/ 주민번호 : " + socialNum +  "]" ;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSocialNum(int socialNum) {
		this.socialNum = socialNum;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) { // 클래스가 다른 경우
			if(!(obj instanceof String)) { // 문자열이 아닌경우(타입변환이 불가능한 경우) 비교하지 말고
				return false;
			}
			return id.equals(obj); // 타입변환이 가능한 경우 비교하기
		}
		UserManager other = (UserManager) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
}
