package com.java.boot3.product;

import java.util.List;

import lombok.Data;

@Data
public class ProductVO {
	
	private Long productNum;
	private String productName;
	private Integer productPrice;
	private Integer productCount;
	private String productDetail;
	private String id;
	private Integer sale;
	
	private List<ProductFilesVO> productFilesVO;
	
}
