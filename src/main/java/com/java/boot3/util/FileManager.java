package com.java.boot3.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	@Autowired
	private ServletContext servletContext;
	
	public boolean remove(String path, String fileName) throws Exception {
		//파일을 HDD에서 삭제
		//저장된 파일명, 저장된 경로
		path = servletContext.getRealPath(path);
		File file = new File(path, fileName);
		
		return file.delete();
	}
	
	public String fileSave(MultipartFile mf, String path) throws Exception {
		
		// path는 프로젝트 상의 파일을 저장할 폴더 명 path="/resources/upload/board"
		// 파일을 HDD에 저장
		// 저장된 파일명을 리턴 (파일명은 중복되지 않도록)
		path = servletContext.getRealPath(path);
		System.out.println(path);
		
		File file = new File(path);
		
		if(!file.exists()) {
			//file.mkdir(); //중간 폴더가 없으면 에러 발생
			file.mkdirs(); //중간 폴더가 없으면 중간 폴더도 생성
		}
		
		String oriName = mf.getOriginalFilename();
		String fileName = UUID.randomUUID().toString(); //static이 들어간 class method라서 객체 생성하지 않고 method를 쓸 수 있음
		fileName = fileName + "_" + oriName;
		
		file = new File(path, fileName);
		mf.transferTo(file);
		
		return fileName;
	}
	
}
