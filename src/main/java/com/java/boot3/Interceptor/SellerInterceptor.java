package com.java.boot3.Interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.java.boot3.member.MemberVO;
import com.java.boot3.member.RoleVO;

@Component
public class SellerInterceptor implements HandlerInterceptor {
	
	@Value("${member.role.seller}")
	private String roleName;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		boolean check = false;
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		if(memberVO != null) {			
			for(RoleVO roleVO: memberVO.getRoleVOs()) {
				if(roleVO.getRoleName().equals(roleName)) {
					check = true;
				}
			}
		}
		
		//check -> true 면 통과
		//check -> false 면 거절
		
		if(!check) {
			
			//servlet 방식 사용
			//redirect 방식 : response.sendRedirect("url") 
			//forward 방식
			request.setAttribute("message", "권한이 없습니다.");
			request.setAttribute("path", "../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			
		}
		return check;
	}
	
}
