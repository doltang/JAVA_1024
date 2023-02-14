package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.vo.MemberOkVO;
import kr.kh.spring.vo.MemberVO;

public interface MemberDAO {
	
	int insertMember(@Param("m")MemberVO member);

	void insertMemberOk(@Param("mok")MemberOkVO mok);

	MemberOkVO selectMemberOk(@Param("mok")MemberOkVO mok);

	void deleteMemberOk(@Param("mok")MemberOkVO mok);

	void updateAuthority(@Param("me_id")Object mo_me_id, @Param("me_authority")int i);

	MemberVO selectMemberById(@Param("me_id")String me_id);

}
