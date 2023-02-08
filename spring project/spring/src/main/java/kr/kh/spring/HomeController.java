package kr.kh.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public ModelAndView home(ModelAndView mv,String name, Integer age) {
		mv.addObject("name", name);
		mv.addObject("age", age);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value = "/board/{num}")
	public ModelAndView board(ModelAndView mv, @PathVariable("num")Integer num) {
		System.out.println("게시글 번호 : " + num);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value = "/test")
	public ModelAndView home(ModelAndView mv, InfoVO info) {
		mv.addObject("info1", info);
		System.out.println(info);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public ModelAndView login(ModelAndView mv) {
//		mv.addObject("id", id);
//		mv.addObject("pw", pw);
//		System.out.println("아이디 : " + id);
//		System.out.println("비밀번호 : " + pw);
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public ModelAndView login(ModelAndView mv, String id, String pw) {
//		mv.addObject("id", id);
//		mv.addObject("pw", pw);
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		mv.setViewName("login");
		return mv;
	}
	
}
