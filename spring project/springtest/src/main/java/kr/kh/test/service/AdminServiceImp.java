package kr.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.test.dao.BoardDAO;
import kr.kh.test.vo.BoardTypeVO;

@Service
public class AdminServiceImp implements AdminService{
	@Autowired
	BoardDAO boardDao;

	@Override
	public boolean boardCheck(int bt_num, String bt_type, String bt_name, int bt_r_authority, int bt_w_authority) {
		BoardTypeVO btype = new BoardTypeVO(bt_num, bt_type, bt_name, bt_r_authority, bt_w_authority);
		boardDAO.boardcheck
		return false;
	}
}
