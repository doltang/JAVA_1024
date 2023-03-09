package kr.kh.test.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.pagination.Criteria;
import kr.kh.test.pagination.PageMaker;
import kr.kh.test.service.BoardService;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	//@Resource
	private String uploadPath;
	
	@RequestMapping(value = "/board/insert", method = RequestMethod.GET)
	public ModelAndView boardInsert(ModelAndView mv, HttpSession session) {
		//로그인한 회원 정보를 가져옴
		MemberVO user = (MemberVO)session.getAttribute("user");
		//가져온 회원 정보를 서비스에게 주면서 권한에 맞는 게시판 타입을 가져오라고 요청
		ArrayList<BoardTypeVO> typeList = 
				boardService.getBoardTypeList(user);
		mv.addObject("typeList", typeList);
		mv.setViewName("/board/insert");
		return mv;
	}
	
	@RequestMapping(value = "/board/insert", method = RequestMethod.POST)
	public ModelAndView boardInsertPost(ModelAndView mv, HttpSession session,
			BoardVO board, MultipartFile[] files) {
		//로그인한 회원 정보를 가져옴
		MemberVO user = (MemberVO)session.getAttribute("user");
		System.out.println(board);
		String msg, url;
		
		if(boardService.insertBoard(board,user,files)) {
			msg = "게시글 등록 성공";
		}else {
			msg = "게시글 등록 실패";
		}
		mv.addObject("msg", msg);
		mv.addObject("url", "/board/list");
		mv.setViewName("/board/insert");
		
		return mv;
	}
	
	/* uploadFile에서 예외가 발생할 수 있으므로 throws 추가 */ 
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String boardRegisterPost(BoardVO board
				,HttpServletRequest request, MultipartFile file) throws Exception {
		/* ... 이전 코드 생략 */

		uploadFile(file.getOriginalFilename(),file.getBytes());
		return "redirect:/board/list";
	}

	private String uploadFile(String name, byte[] data)throws Exception {
		 /* 고유한 파일명을 위해 UUID를 이용 */
		UUID uid = UUID.randomUUID();
		String savaName = uid.toString() +"_" + name;
		File target = new File(uploadPath, savaName);
		FileCopyUtils.copy(data, target);
		return savaName;
		
	}
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv, Criteria cri) {
		cri.setPerPageNum(5);
		ArrayList<BoardVO> list = 
				boardService.getBoardList(cri);
		int totalCount = boardService.getTotalCountBoard(cri);
		int displayPageNum = 3;
		PageMaker pm = new PageMaker(totalCount, displayPageNum, cri);
		
		MemberVO user = new MemberVO();
		user.setMe_authority(10);
		ArrayList<BoardTypeVO> btList = boardService.getBoardTypeList(user);
		mv.addObject("btList", btList);
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	
}