package com.java.boot3.board;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.java.boot3.product.ProductFilesVO;
import com.java.boot3.util.Pager;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "board";
	}
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<BoardVO> ar = boardService.getList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@GetMapping("add")
	public void setAdd() throws Exception {
		
	}
	
	@PostMapping("add")
	public String setAdd(BoardVO boardVO, MultipartFile [] files) throws Exception {
		
		int result = boardService.setAdd(boardVO, files);
		return "redirect:./list";
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardVO = boardService.getDetail(boardVO);
		
		mv.addObject("vo", boardVO);
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView setUpdate(BoardVO boardVO, ModelAndView mv) throws Exception {
		boardVO = boardService.getDetail(boardVO);
		
		mv.addObject("vo", boardVO);
		mv.setViewName("board/update");
		
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView setUpdate(BoardVO boardVO, MultipartFile [] files) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = boardService.setUpdate(boardVO, files);
		if(result > 0) {	
			mv.setViewName("redirect:./list");
		}else {
			mv.setViewName("common/result");
			mv.addObject("message", "update 실패");
			mv.addObject("path", "./detail?num"+boardVO.getNum());
		}
		return mv; //"redirect:./list";
	}
	
	@GetMapping("delete")
	public String setDelete(BoardVO boardVO) throws Exception {
		int result = boardService.setDelete(boardVO);
		return "redirect:./list";
	}
	
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFilesVO boardFilesVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardFilesVO = boardService.getFileDetail(boardFilesVO);
		
		//fileDown 클래스에서 fileVO로 꺼낼 수 있도록 이름은 꼭 fileVO로
		mv.addObject("fileVO", boardFilesVO);
		//Bean(클래스) 이름과 동일하게
		mv.setViewName("fileDown");
		return mv;
	}
	
	@PostMapping("fileDelete")
	public ModelAndView setFileDelete(BoardFilesVO boardFilesVO) throws Exception {
		ModelAndView mv = new ModelAndView();
//		System.out.println(productFilesVO.getFileNum());
		int result = boardService.setFileDelete(boardFilesVO);
		mv.addObject("result", result);
		mv.setViewName("common/addResult");
		return mv;
	}
	
	@PostMapping("summerFileUpload")
	public ModelAndView setSummerFileUpload(MultipartFile files) throws Exception {
		ModelAndView mv = new ModelAndView();
		String fileName = boardService.setSummerFileUpload(files);
		mv.addObject("result", fileName);
		mv.setViewName("common/addResult");
		return mv;
	}
	
	@GetMapping("summerFileDelete")
	public ModelAndView setSummerFileDelete(String fileName) throws Exception {
		ModelAndView mv = new ModelAndView();
		boolean result = boardService.setSummerFileDelete(fileName);
		mv.addObject("result", result);
		mv.setViewName("common/addResult");
		return mv;
	}

}
