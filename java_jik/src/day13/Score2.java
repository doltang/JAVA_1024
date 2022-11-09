package day13;

import lombok.Data;

@Data
public class Score2 {
	// 필드 : 과목, 학기, 중간, 기말, 수행평가, 총점
	private String title;
	private int term, midScore, finalScore, performance;
	private double total;
	private double midRate = 0.4, finalRate = 0.5, performanceRate= 0.1;
	
	// 메소드 : equals()옆에는 객체 '하나'가 와야한다 : 성적 추가 시 활용, toString() 성적 추력 시 활용
	// 		  getter, setter -> data로 대체
	
	
	// 학기별 성적을 문자열로 출력
	@Override
	public String toString() {
		return "[" + term + "학기 " + "title" + " 중간 : " + midScore + " 기말 : " +  finalScore+ " 수행 : "
				+ performance + "총점 :  "+ total +"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + term;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score2 other = (Score2) obj;
		if (term != other.term)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	// 생성자 : 과목, 학기, 중간, 기말, 수행평가가 필요한 생성자
	public Score2(String title, int term, int midScore, int finalScore, int performance) {
		super();
		this.title = title;
		this.term = term;
		this.midScore = midScore;
		this.finalScore = finalScore;
		this.performance = performance;
		this.total = midRate*midScore + finalScore*finalRate + performance*performanceRate;
	}
	
	// 생성자2 : 과목, 학기가 필요한 생성자 (성적이 같은지 확인할 때) equals 사용시 과목과 학기를 하나로 만들어 줘야함
	public Score2(String title, int term) {
		super();
		this.title = title;
		this.term = term;
	}
	
	// 복사 생성자
	public Score2(Score2 s) {
		this(s.title, s.term, s.midScore, s.finalScore, s.performance);
	}
	
	
}
