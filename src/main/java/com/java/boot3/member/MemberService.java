package com.java.boot3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.boot3.board.BoardFilesVO;
import com.java.boot3.util.FileManager;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FileManager fileManager;
	
	//회원가입
	public int setAdd(MemberVO memberVO, MultipartFile mf) throws Exception {
		int result = memberMapper.setAdd(memberVO);
		result = memberMapper.setMemberRole(memberVO);
		
		String fileName = fileManager.fileSave(mf, "resources/upload/member/");
		System.out.println(fileName);
		
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setFileName(fileName);
		memberFilesVO.setOriName(mf.getOriginalFilename());
		memberFilesVO.setId(memberVO.getId());
		
		memberMapper.setFileAdd(memberFilesVO);
		
		
		return result;
	}
	
	//로그인
	public MemberVO getLogin(MemberVO memberVO) throws Exception {
		return memberMapper.getLogin(memberVO);
	}
	
	//마이페이지
	public MemberVO getDetail(MemberVO memberVO) throws Exception {
		return memberMapper.getDetail(memberVO);
	}
	
	//회원탈퇴
	public int setDelete(MemberVO memberVO) throws Exception {
		MemberFilesVO memberFilesVO = memberMapper.getFileDetail(memberVO);
		int result = memberMapper.setDelete(memberVO);
		
		if(result > 0) {
			boolean check = fileManager.remove("resources/upload/member/", memberFilesVO.getFileName());
		}
		return result;
	}
	
	//회원수정
	public int setUpdate(MemberVO memberVO) throws Exception {
		return memberMapper.setUpdate(memberVO);
	}

}
