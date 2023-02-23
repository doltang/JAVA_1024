package kr.kh.test.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.AdminService;
import kr.kh.test.vo.BoardTypeVO;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/admin/boardTypeList")
	public ModelAndView adminBoardTypeList(ModelAndView mv, BoardTypeVO bt) {
		ArrayList<BoardTypeVO> boardTypeList = adminService.getBoardTypeList();
		mv.addObject("btList", boardTypeList);
		mv.setViewName("/admin/boardTypeList");
		return mv;
	}
}
