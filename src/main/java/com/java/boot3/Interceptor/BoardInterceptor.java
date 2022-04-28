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
public class BoardInterceptor implements HandlerInterceptor {

	@Value("${member.role.member}")
	private String roleName;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Board Interceptor");
		boolean check = false;
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		if(memberVO != null) {			
			for(RoleVO roleVO: memberVO.getRoleVOs()) {
				if(roleVO.getRoleName().equals(roleName)) {
					check = true;
				}
			}
		}
		if(!check) {
			
			request.setAttribute("message", "로그인 해주세요.");
			request.setAttribute("path", "../member/login");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			
		}
		
		return check;
	}
	
}
