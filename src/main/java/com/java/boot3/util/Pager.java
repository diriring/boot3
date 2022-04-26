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
	
	private Long startNum;
	private Long lastNum;
	private boolean pre;
	private boolean next;
	
	public void makeRow() {
		//pn : 1, perPage : 10, startRow : 0
		//pn : 2, perPage : 10, startRow : 10
		//pn : 3, perPage : 10, startRow : 20
		this.startRow = (this.getPn() - 1) * this.getPerPage();
	}
	
	public void makeNum(Long totalCount) {
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}
		
		Long perBlock=5L;
		Long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		
		Long curBlock = this.getPn()/perBlock;
		if(this.getPn()%perBlock != 0) {
			curBlock++;
		}
		
		this.startNum = (curBlock-1) * perBlock + 1;
		this.lastNum = curBlock * perBlock;
		
		this.pre=false;
		if(curBlock > 1) {
			this.pre=true;
		}
		
		this.next=false;
		if(totalBlock > curBlock) {
			this.next=true;
		}
		
		if(curBlock == totalBlock) {
			this.lastNum=totalPage;
		}
		
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
			this.perPage=9;
		}
		return this.perPage;
	}
	
}
