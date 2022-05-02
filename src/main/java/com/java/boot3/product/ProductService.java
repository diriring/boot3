package com.java.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.boot3.util.FileManager;
import com.java.boot3.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private FileManager fileManager;
	
	public List<ProductVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(productMapper.totalCount(pager));
		System.out.println("Service : " + pager.getStartRow());
		List<ProductVO> ar = productMapper.getList(pager);
		
		return ar;
	}
	
	public ProductVO getDetail(ProductVO productVO) throws Exception {
		return productMapper.getDetail(productVO);
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
	
	public int setUpdate(ProductVO productVO, MultipartFile [] files) throws Exception {
		int result = productMapper.setUpdate(productVO);
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
	
	public int setFileDelete(ProductFilesVO productFilesVO) throws Exception {
		productFilesVO = productMapper.getFileDetail(productFilesVO);
		
		//db 삭제
		int result = productMapper.setFileDelete(productFilesVO);
		
		//hdd 삭제
		if(result > 0) {
			boolean check = fileManager.remove("/resources/upload/product/", productFilesVO.getFileName());
		}
		return result;
	}
	
	public String setSummerFileUpload(MultipartFile files) throws Exception {
		
		String fileName = fileManager.fileSave(files, "resources/upload/product/");
		fileName = "/resources/upload/product/"+fileName;
		return fileName;
	}
	
	public boolean setSummerFileDelete(String fileName) throws Exception {
		fileName = fileName.substring(fileName.lastIndexOf("/")+1);
		System.out.println(fileName);
		return fileManager.remove("resources/upload/product/", fileName);
	}
	
}
