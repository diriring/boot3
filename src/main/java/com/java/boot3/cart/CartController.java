package com.java.boot3.cart;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.java.boot3.member.MemberVO;

//@Controller
@RestController //모든 method가 @Responsebody 이면 선언, method의 @Responsebody를 생략 가능
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/cart/{productNum}/{count}")
//	@ResponseBody
	public int setAdd(HttpSession session, @PathVariable Long productNum, @PathVariable Long count) throws Exception {
		System.out.println("productNum : " + productNum);
		
		CartVO cartVO = new CartVO();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		cartVO.setId(memberVO.getId());
		cartVO.setProductNum(productNum);
		cartVO.setCount(count);
		
		int result = cartService.setAdd(cartVO);
		
		//result를 JSON 형태로 바꿔주는 라이브러리 사용
		
		return result;
	}

	@DeleteMapping("/cart/{cartNum}")
	public ModelAndView setDelete(@PathVariable Long cartNum) throws Exception {
		System.out.println("CartNum : " + cartNum);
		return null;
	}
	
	@GetMapping("/cart/{pn}")
//	@ResponseBody
	public List<CartVO> getList(@PathVariable Long pn, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("PN : " + pn);
		CartVO cartVO = new CartVO();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		cartVO.setId(memberVO.getId());
		
		List<CartVO> ar = cartService.getList(cartVO);
		
		System.out.println(ar);
		
		return ar;
	}
	
}
