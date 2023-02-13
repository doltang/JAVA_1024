package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.vo.MemberOkVO;
import kr.kh.spring.vo.MemberVO;

public interface MemberDAO {
	
	int insertMember(@Param("m")MemberVO member);

	void insertMemberOk(@Param("mok")MemberOkVO mok);

}
