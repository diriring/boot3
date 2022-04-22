package com.java.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.boot3.board.BoardFilesVO;
import com.java.boot3.util.FileManager;
import com.java.boot3.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private FileManager fileManager;
	
	public List<ProductVO> getList(Pager pager) throws Exception {
		pager.setPerPage(9);
		pager.makeRow();
		pager.makeNum(productMapper.totalCount(pager));
		List<ProductVO> ar = productMapper.getList(pager);
		
		return ar;
	}
	
	public int setAdd(ProductVO productVO, MultipartFile [] files) throws Exception {
		int result = productMapper.setAdd(productVO);
		if(files != null) {
			for(MultipartFile mf : files) {
			
				if(mf.isEmpty()) {
					continue;
				}
				
				// File을 HDD에 저장
				String fileName = fileManager.fileSave(mf, "resources/upload/product/");
				System.out.println(fileName);
				// 저장된 정보를 DB에 저장
				ProductFilesVO productFilesVO = new ProductFilesVO();
				productFilesVO.setProductNum(productVO.getProductNum());
				productFilesVO.setFileName(fileName);
				productFilesVO.setOriName(mf.getOriginalFilename());
				
				productMapper.setFileAdd(productFilesVO);
			}
		}
		
		
		return result;
	}
	
}
