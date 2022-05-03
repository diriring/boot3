package com.java.boot3.product;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductVO {
	
	private Long productNum;
	@NotBlank
	private String productName;
	@Min(value=100)
	private Integer productPrice;
	@Min(value=1)
	@Max(value=1000)
	private Integer productCount;
	@NotBlank
	private String productDetail;
	private String id;
	@NotNull
	private Integer sale;
	
	private List<ProductFilesVO> productFilesVO;
	
}
