package com.java.boot3.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.boot3.util.Pager;

@Mapper
public interface ProductMapper {

	public List<ProductVO> getList(Pager pager) throws Exception;
	
	public ProductVO getDetail(ProductVO productVO) throws Exception;
	
	public int setAdd(ProductVO productVO) throws Exception;
	
	public int setFileAdd(ProductFilesVO productFilesVO) throws Exception;
	
	public Long totalCount(Pager pager) throws Exception;
	
}
