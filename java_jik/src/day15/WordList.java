package day15;


public class WordList {
	private String word;
	private String mean;
	
	public WordList(String word, String mean) {
		this.word = word;
		this.mean = mean;
	}
	
	public WordList(String word){
		this.word = word;
	}
	
	@Override
	public String toString() {
		return "[" + word +  " : " + mean + "]";
	}

// @Data 쓰면 hashcode 남겨놔야 한다
// word만 같아도 같다고 처리할거기떄문에 word만 체크
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
			return word.equals(obj); // 타입변환이 가능한 경우 비교하기
		}
		WordList other = (WordList) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	public void setMean(String mean) {
		this.mean = mean;
		
	}

}
