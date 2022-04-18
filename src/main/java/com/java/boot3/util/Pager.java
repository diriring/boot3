package com.java.boot3.util;

import lombok.Data;

@Data
public class Pager {
	
	// DB에서 몇개씩 조회
	private Integer perPage;
	// DB에서 조회할 때 시작 인덱스 번호
	private Integer startRow;
	
	// 페이지 번호 (파라미터의 값)
	private Integer pn;
	
	private String kind;
	private String search;
	
	public void makeRow() {
		//pn : 1, perPage : 10, startRow : 0
		//pn : 2, perPage : 10, startRow : 10
		//pn : 3, perPage : 10, startRow : 20
		this.startRow = (this.getPn() - 1) * this.getPerPage();
	}
	
	public String getSearch() {
		//검색어가 넘어오지 않을 때 (search=null일 때)
		if(search==null) {
			this.search="";
		}
		
//		this.search="%"+this.search+"%";
		
		return search;
	}

	
	public Integer getPn() {
		if(this.pn == null || this.pn < 1) {
			this.pn = 1;
		}
		return this.pn;
	}
	
	public Integer getPerPage() {
		if(this.perPage == null || this.perPage < 1) {
			this.perPage=10;
		}
		return this.perPage;
	}
	
}
