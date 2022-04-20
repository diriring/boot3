package com.java.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.boot3.util.FileManager;
import com.java.boot3.util.Pager;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private FileManager fileManager;
	
	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(boardMapper.total(pager));
		return boardMapper.getList(pager);
	}
	
	public int setAdd(BoardVO boardVO, MultipartFile [] files) throws Exception {
		int result = boardMapper.setAdd(boardVO);
		
		for(MultipartFile mf : files) {
			
			if(mf.isEmpty()) {
				continue;
			}
			
			// File을 HDD에 저장
			String fileName = fileManager.fileSave(mf, "resources/upload/board/");
			System.out.println(fileName);
			// 저장된 정보를 DB에 저장
			BoardFilesVO boardFilesVO = new BoardFilesVO();
			boardFilesVO.setNum(boardVO.getNum());
			boardFilesVO.setFileName(fileName);
			boardFilesVO.setOriName(mf.getOriginalFilename());
			
			boardMapper.setFileAdd(boardFilesVO);
		}
		
		return  result;
	}

	public BoardVO getDetail(BoardVO boardVO) throws Exception {
		return boardMapper.getDetail(boardVO);
	}

	public int setUpdate(BoardVO boardVO) throws Exception {
		return boardMapper.setUpdate(boardVO);
	}

	public int setDelete(BoardVO boardVO) throws Exception {
		List<BoardFilesVO> ar = boardMapper.getFileList();
		int result = boardMapper.setDelete(boardVO);
		
		if(result > 0) {
			for(BoardFilesVO vo : ar) {
				boolean check = fileManager.remove("resources/upload/board/", vo.getFileName());
			}
		}
		return result;
	}
	
	public BoardFilesVO getFileDetail(BoardFilesVO boardFilesVO) throws Exception {
		return boardMapper.getFileDetail(boardFilesVO);
	}
	
}
