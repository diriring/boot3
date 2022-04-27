package com.java.boot3.aop;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	
	public void bus() {
		System.out.println("Bus 타기");
	}
	
	public void subway() {
		System.out.println("Subway 타기");
	}

}
