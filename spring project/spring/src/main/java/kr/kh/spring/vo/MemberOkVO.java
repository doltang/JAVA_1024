package kr.kh.spring.vo;

import java.util.Date;

public class MemberOkVO {
	String mo_me_id;
	String mo_num;
	Date mo_valid_time;
	public MemberOkVO(String mo_me_id, String mo_num) {
		this.mo_me_id = mo_me_id;
		this.mo_num = mo_num;
		this.mo_valid_time = new Date();
	}
}
