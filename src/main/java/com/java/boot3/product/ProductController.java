package com.java.boot3.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.java.boot3.board.BoardService;
import com.java.boot3.member.MemberVO;
import com.java.boot3.util.Pager;

@Controller
@RequestMapping(value="/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "product";
	}
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<ProductVO> ar = productService.getList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("product/list");
		
		return mv;
	}
	
	@GetMapping("add")
	public void setAdd() throws Exception {
		
	}
	
	@PostMapping("add")
	public ModelAndView setAdd(ProductVO productVO, MultipartFile [] files, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(productVO.getSale());
//		for(MultipartFile f:files) {
//			System.out.println(f.getOriginalFilename());
//		};
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		productVO.setId(memberVO.getId());
		int result = productService.setAdd(productVO, files);
		mv.addObject("result", result);
		mv.setViewName("common/addResult");
		return mv;
	}
	
	@GetMapping("ajaxList")
	public ModelAndView getAjaxList(Pager pager, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		pager.setId(memberVO.getId());
		
		List<ProductVO> ar = productService.getList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("common/ajaxList");
		
		return mv;
	}
	
	@GetMapping("manage")
	public ModelAndView manage(HttpSession session, Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		pager.setId(memberVO.getId());
		pager.setPerPage(5);
		List<ProductVO> ar = productService.getList(pager);
		mv.addObject("list", ar);
		mv.setViewName("product/manage");
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(ProductVO productVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		//parameter는 productNum
		//모든 구매자가 보는 페이지
		productVO = productService.getDetail(productVO);
		mv.addObject("vo", productVO);
		
		mv.setViewName("product/detail");
		return mv;
	}
	
	@GetMapping("manageDetail")
	public ModelAndView getManageDetail(ProductVO productVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		//parameter는 productNum
		//판매자가 보는 페이지
		productVO = productService.getDetail(productVO);
		mv.addObject("vo", productVO);
		
		mv.setViewName("product/manageDetail");
		return mv;
	}

}
