package kr.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping(value = "/board") 이걸 추가하면 이 아래애들은 전부 /board 아래에 놓이게 된다
public class BoardController {

	@RequestMapping(value = "/board/list", method=RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv) {
		mv.setViewName("/board/list");
		return mv;
	}
}
