package com.java.boot3.board;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.boot3.util.Pager;

@SpringBootTest
class BoardMapperTest {
	
	@Autowired
	private BoardMapper boardMapper;
	
	//@Test
	void setFileAddTest() throws Exception {
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setNum(3L);
		boardFilesVO.setFileName("fileName");
		boardFilesVO.setOriName("oriName");
		
		int result = boardMapper.setFileAdd(boardFilesVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void setFileDeleteTest() throws Exception {
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setFileNum(2L);
		
		int result = boardMapper.setFileDelete(boardFilesVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void getFileDetailTest() throws Exception {
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setFileNum(2L);
		
		boardFilesVO = boardMapper.getFileDetail(boardFilesVO);
		
		assertNotNull(boardFilesVO);
	}
	
	//@Test
	void getFileListTest() throws Exception {
		List<BoardFilesVO> ar = boardMapper.getFileList();
		assertNotEquals(0, ar.size());
	}
	
	@Test
	void getDetailTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(107L);
		boardVO = boardMapper.getDetail(boardVO);

		assertNotNull(boardVO);
	}
	
	//@Test
	void getListTest() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardVO> ar = boardMapper.getList(pager);
		assertEquals(10, ar.size());
	}
	
	//@Test
	void setAddTest() throws Exception {
		
		for(int i=0;i<100;i++) {
			if(i%10 == 0) {
				Thread.sleep(1000);
			}
			
			BoardVO boardVO = new BoardVO();
			boardVO.setTitle("addTitle"+i);
			boardVO.setWriter("addWriter"+i);
			boardVO.setContents("addContents"+i);
			
			int result = boardMapper.setAdd(boardVO);
		}
		
		System.out.println("Finish");
		
//		assertEquals(1, result);
	}
	
	//@Test
	void setUpdateTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(4L);
		boardVO.setTitle("titleUpdate");
		boardVO.setContents("contentsUpdate");
		
		int result = boardMapper.setUpdate(boardVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void setDeleteTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(4L);
		
		int result = boardMapper.setDelete(boardVO);
		
		assertEquals(1, result);
	}

}
