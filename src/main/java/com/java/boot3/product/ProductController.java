package com.java.boot3.product;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	public void setAdd(@ModelAttribute ProductVO productVO) throws Exception {
		
	}
	
	@PostMapping("add")
	public ModelAndView setAdd(@Valid ProductVO productVO, BindingResult bindingResult, MultipartFile [] files, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("product/add");
			return mv;
		}
		
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
	
	@GetMapping("update")
	public ModelAndView setUpdate(ProductVO productVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		productVO = productService.getDetail(productVO);
		mv.addObject("vo", productVO);
		mv.setViewName("product/update");
		
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView setUpdate(ProductVO productVO, ModelAndView mv, MultipartFile [] files) throws Exception {		
		int result = productService.setUpdate(productVO, files);
		
		if(result > 0) {	
			mv.setViewName("redirect:./manage");
		}else {
			mv.setViewName("common/result");
			mv.addObject("message", "update ??????");
			mv.addObject("path", "./manageDetail?productNum"+productVO.getProductNum());
		}
		
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
		
		//parameter??? productNum
		//?????? ???????????? ?????? ?????????
		productVO = productService.getDetail(productVO);
		mv.addObject("vo", productVO);
		
		mv.setViewName("product/detail");
		return mv;
	}
	
	@GetMapping("manageDetail")
	public ModelAndView getManageDetail(ProductVO productVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		//parameter??? productNum
		//???????????? ?????? ?????????
		productVO = productService.getDetail(productVO);
		mv.addObject("vo", productVO);
		
		mv.setViewName("product/manageDetail");
		return mv;
	}
	
	@PostMapping("fileDelete")
	public ModelAndView setFileDelete(ProductFilesVO productFilesVO) throws Exception {
		ModelAndView mv = new ModelAndView();
//		System.out.println(productFilesVO.getFileNum());
		int result = productService.setFileDelete(productFilesVO);
		mv.addObject("result", result);
		mv.setViewName("common/addResult");
		return mv;
	}
	
	@PostMapping("summerFileUpload")
	public ModelAndView setSummerFileUpload(MultipartFile files) throws Exception {
		ModelAndView mv = new ModelAndView();
		String fileName = productService.setSummerFileUpload(files);
		mv.addObject("result", fileName);
		mv.setViewName("common/addResult");
		return mv;
	}
	
	@GetMapping("summerFileDelete")
	public ModelAndView setSummerFileDelete(String fileName) throws Exception {
		ModelAndView mv = new ModelAndView();
		boolean result = productService.setSummerFileDelete(fileName);
		mv.addObject("result", result);
		mv.setViewName("common/addResult");
		return mv;
	}
	
	//???????????? ?????????
//	@ExceptionHandler(BindException.class)
//	public ModelAndView ex1() {
//		ModelAndView mv = new ModelAndView();
//		System.out.println("????????????");
//		mv.setViewName("error/error");
//		return mv;
//	}
//	
//	@ExceptionHandler(NullPointerException.class)
//	public ModelAndView ex2() {
//		ModelAndView mv = new ModelAndView();
//		System.out.println("NullPointer ????????????");
//		mv.setViewName("error/error");
//		return mv;
//	}
//	
//	@ExceptionHandler(Exception.class)
//	public ModelAndView ex3() {
//		ModelAndView mv = new ModelAndView();
//		System.out.println("Exception ????????????");
//		mv.setViewName("error/error");
//		return mv;
//	}
//	
//	@ExceptionHandler(Throwable.class)
//	public ModelAndView ex4() {
//		ModelAndView mv = new ModelAndView();
//		System.out.println("Throwable ????????????");
//		mv.setViewName("error/error");
//		return mv;
//	}

}
