package com.java.boot3.Interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.java.boot3.board.BoardMapper;
import com.java.boot3.board.BoardVO;
import com.java.boot3.member.MemberVO;

@Component
public class WriterCheckIntercptor implements HandlerInterceptor {

	@Autowired
	private BoardMapper boardMapper;
	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		
//		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
//		
//		Map<String, Object> map = modelAndView.getModel();
//		BoardVO boardVO = (BoardVO)map.get("vo");
//		
//		if(!boardVO.getWriter().equals(memberVO.getId())) {
//			//modelAndView.setViewName("redirect:./list");
//			modelAndView.addObject("message", "작성자만 가능");
//			modelAndView.addObject("path", "./list");
//			modelAndView.setViewName("common/result");
//		}
//	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String method = request.getMethod();
		System.out.println(method);
		
		String num = request.getParameter("num");
		
		//작성자와 로그인 한 사용자의 id가 일치하면 통과
		//일치하지 않으면 list로 redirect
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(Long.parseLong(num));
		boardVO = boardMapper.getDetail(boardVO);
		
		if(memberVO.getId().equals(boardVO.getWriter())) {
			return true;
		}else {
			response.sendRedirect("./list");
			return false;
		}
	}
	
	
	
}
