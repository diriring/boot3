package com.java.boot3.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.boot3.util.Pager;

@SpringBootTest
class ProductMapperTest {

	@Autowired
	private ProductMapper productMapper;
	
	//@Test
	void setAddTest() throws Exception {
		for(int i=0;i<10;i++) {
			ProductVO productVO = new ProductVO();
			productVO.setProductName("name"+i);
			productVO.setProductPrice(20000);
			productVO.setProductCount(1000);
			productVO.setProductDetail("detail"+i);
			
			int result = productMapper.setAdd(productVO);
		}
		
		
		System.out.println("finish");
	}
	
	//@Test
	void getListTest() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
		List<ProductVO> ar = productMapper.getList(pager);
		
		assertEquals(10, ar.size());
	}
	
	//@Test
	void productNumTest() throws Exception {
		ProductVO productVO = new ProductVO();
		productVO.setProductName("test");
		productVO.setProductPrice(50000);
		productVO.setProductCount(1000);
		productVO.setProductDetail("detail test");
		
		productMapper.setAdd(productVO);
		
		System.out.println(productVO.getProductNum());
	}
	
	@Test
	void setFileAddTest() throws Exception {
		ProductFilesVO productFilesVO = new ProductFilesVO();
		productFilesVO.setFileName("fileName");
		productFilesVO.setOriName("oriName");
		productFilesVO.setProductNum(12L);
		
		int result = productMapper.setFileAdd(productFilesVO);
		
		assertEquals(1, result);
	}

}
