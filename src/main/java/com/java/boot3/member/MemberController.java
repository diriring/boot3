package com.java.boot3.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@GetMapping("join")
	public ModelAndView setAdd(@ModelAttribute MemberVO memberVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join");
		return mv;
	}
	
	@PostMapping("join")
	public ModelAndView setAdd(@Valid MemberVO memberVO, BindingResult bindingResult,MultipartFile mf) throws Exception {
		ModelAndView mv = new ModelAndView();
		
//		if(bindingResult.hasErrors()) {
//			mv.setViewName("member/join");
//			return mv;
//		}
		
		//사용자 정의 검증 메서드 호출
		if(memberService.memberError(memberVO, bindingResult)) {
			mv.setViewName("member/join");
			return mv;
		}
		
		
		int result = memberService.setAdd(memberVO, mf);
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	@GetMapping("login")
	public ModelAndView getLogin(@ModelAttribute MemberVO memberVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		//mv.addObject("vo", new MemberVO());
		mv.setViewName("member/login");
		return mv;
	}
	
	@PostMapping("login")
	public ModelAndView getLogin(MemberVO memberVO, HttpSession session, String remember, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(remember != null && remember.equals("1")) {
			Cookie cookie = new Cookie("remember", memberVO.getId());
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		memberVO = memberService.getLogin(memberVO);
		
		mv.setViewName("member/login");
		
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		}

		return mv;
	}
	
	@GetMapping("logout")
	public String getLogout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}
	
	@GetMapping("mypage")
	public ModelAndView getDetail(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		memberVO = memberService.getDetail(memberVO);
		
		mv.addObject("vo", memberVO);
		
		return mv;
	}
	
	@GetMapping("delete")
	public ModelAndView setDelete(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		int result = memberService.setDelete(memberVO);
		
		String message = "탈퇴 실패";
		String path = "redirect:../";
		
		if(result == 1) {
			session.invalidate();
			message = "탈퇴 성공";
			path = "../";
		}
		
		mv.addObject("message",message);
		mv.addObject("path",path);
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView setUpdate(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		memberVO = memberService.getDetail(memberVO);
		
		mv.addObject("vo", memberVO);
		
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView setUpdate(MemberVO memberVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = memberService.setUpdate(memberVO);
		
		String message = "Update Fail";
		String path = "redirect:../";
		
		if(result == 1) {
			message = "Update Success";
			path = "./mypage";
		}
		
		mv.addObject("message",message);
		mv.addObject("path",path);
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("findId")
	public void findId() throws Exception {
		
	}
	
	@PostMapping("findId")
	public ModelAndView getFindId(MemberVO memberVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		memberVO = memberService.getFindId(memberVO);
		mv.addObject("vo", memberVO);
		mv.setViewName("member/findIdResult");
		
		return mv;
	}
	
}
