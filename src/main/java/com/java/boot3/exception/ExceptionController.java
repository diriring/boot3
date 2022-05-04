package com.java.boot3.exception;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(BindException.class)
	public ModelAndView ex1(Exception e) {
		ModelAndView mv = new ModelAndView();
		System.out.println(e.getMessage());
		System.out.println("=========================");
		e.printStackTrace();
		System.out.println("예외발생");
		mv.addObject("message", "불편을 끼쳐드려 죄송합니다.");
		mv.addObject("path", "../");
		mv.setViewName("common/result");
		return mv;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView ex2() {
		ModelAndView mv = new ModelAndView();
		System.out.println("NullPointer 예외발생");
		mv.setViewName("error/error");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView ex3() {
		ModelAndView mv = new ModelAndView();
		System.out.println("Exception 예외발생");
		mv.setViewName("error/error");
		return mv;
	}
	
	@ExceptionHandler(Throwable.class)
	public ModelAndView ex4() {
		ModelAndView mv = new ModelAndView();
		System.out.println("Throwable 예외발생");
		mv.setViewName("error/error");
		return mv;
	}
	
	//400대 에러
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView ex5() {
		ModelAndView mv = new ModelAndView();
		System.out.println("400번대 예외발생");
		mv.addObject("message", "요청하신 페이지를 찾을 수 없습니다.");
		mv.setViewName("error/error");
		return mv;
	}
	
}
