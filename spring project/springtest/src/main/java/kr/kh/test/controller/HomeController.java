package kr.kh.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.MemberService;
import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;


@Controller
public class HomeController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, Integer num) {
		String name = memberService.selectMemberName(num);
		mv.setViewName("/main/home");
		return mv;
	}
	
	 @RequestMapping(value= "/signup", method = RequestMethod.GET)
	 public ModelAndView signup(ModelAndView mv) {
		 mv.setViewName("/member/signup");
		 return mv;
	 }
	 
	 @RequestMapping(value= "/signup", method = RequestMethod.POST)
	 public ModelAndView signuPost(ModelAndView mv, MemberVO member) {
		boolean isSignup = memberService.signup(member);
		if(isSignup) {				
			//성공했다고 알림 메세지(추후 구현 예정)
			System.out.println("회원가입이 완료되었습니다.");
			mv.setViewName("redirect:/");
		}else {
			//성공했다고 알림 메세지(추후 구현 예정)
			System.out.println("회원가입에 실패했습니다.");
			mv.setViewName("redirect:/signup");
		}
		return mv;
	 }
	 
	 @RequestMapping(value= "/login", method = RequestMethod.GET)
	 public ModelAndView login(ModelAndView mv) {
		 mv.setViewName("/member/login");
		 return mv;
	 }
	 
	 
	 @RequestMapping(value = "/login", method=RequestMethod.POST)
		public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
			MemberVO user = memberService.login(member);
			mv.addObject("user", user);
			if(user != null)
				mv.setViewName("redirect:/");
			else
				mv.setViewName("redirect:/login");
			return mv;
		}
	
	 
		@RequestMapping(value = "/logout", method=RequestMethod.POST)
		public ModelAndView logoutPost(ModelAndView mv, HttpSession session) {
			if(session != null)
				session.removeAttribute("user");
			mv.setViewName("redirect:/");
			return mv;
		}
		
		 @RequestMapping(value= "/email/authentication", method = RequestMethod.GET)
		 public ModelAndView emailAuthentication(ModelAndView mv, MemberOKVO mok) {
			 if(memberService.emailConfirm(mok)) {
				 System.out.println("인증성공");
			 }else {
				 System.out.println("인증 실패");
			 }				 
			 mv.setViewName("redirect:/");
			 return mv;
		 }
	
}
