package com.java.boot3.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.boot3.util.Pager;

@Mapper
public interface BoardMapper {
	
	//insert : setFileAdd
	public int setFileAdd(BoardFilesVO boardFilesVO) throws Exception;

	//delete : setFileDelete
	public int setFileDelete(BoardFilesVO boardFilesVO) throws Exception;
	
	//detail : getFileDetail
	public BoardFilesVO getFileDetail(BoardFilesVO boardFilesVO) throws Exception;
	
	//list : getFileList
	public List<BoardFilesVO> getFileList() throws Exception;
	
	//detail
	public BoardVO getDetail(BoardVO boardVO) throws Exception;
	
	//list : getList
	public List<BoardVO> getList(Pager pager) throws Exception;
	
	//insert : setAdd
	public int setAdd(BoardVO boardVO) throws Exception;
	
	//update : setUpdate
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	//delete : setDelete
	public int setDelete(BoardVO boardVO) throws Exception;
	
	//total
	public Long total(Pager pager) throws Exception;
	
}
