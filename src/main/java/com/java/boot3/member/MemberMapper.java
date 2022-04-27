package com.java.boot3.member;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	
	//회원가입
	public int setAdd(MemberVO memberVO) throws Exception;
	public int setMemberRole(Map<String, String> map) throws Exception;
	//로그인
	public MemberVO getLogin(MemberVO memberVO) throws Exception;
	//마이페이지
	public MemberVO getDetail(MemberVO memberVO) throws Exception;
	//수정
	public int setUpdate(MemberVO memberVO) throws Exception;
	//회원탈퇴
	public int setDelete(MemberVO memberVO) throws Exception;
	//파일등록
	public int setFileAdd(MemberFilesVO memberFilesVO) throws Exception;
	//파일조회
	public MemberFilesVO getFileDetail(MemberVO memberVO) throws Exception;
}
