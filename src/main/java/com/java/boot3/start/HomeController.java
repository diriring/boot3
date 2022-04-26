package com.java.boot3.start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/getTest")
	public String getTest(String msg) {
		System.out.println("getTest 요청 발생");
		System.out.println("msg : "+ msg);
		return "common/getResult";
	}
	
	@PostMapping("/postTest")
	public String postTest(String msg) {
		System.out.println("postTest 요청 발생");
		System.out.println("msg : "+ msg);
		return "common/getResult";
	}
	
	@PostMapping("/arrayTest")
	public String arrayTest(String msg, String [] numbers) {
		System.out.println("arrayTest 요청 발생");
		System.out.println("msg : "+ msg);
		for(String str : numbers) {
			System.out.println(str);
		}
		return "common/getResult";
	}
	
}
