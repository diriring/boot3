package com.java.boot3.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.boot3.util.FileManager;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FileManager fileManager;
	
	//properties 파일의 member.role.member 속성값 반환
	@Value("${member.role.member}")
	private String memberRole;
	
	//회원가입
	public int setAdd(MemberVO memberVO, MultipartFile mf) throws Exception {
		int result = memberMapper.setAdd(memberVO);
		
		Map<String, String> map = new HashMap<>();
		map.put("id", memberVO.getId());
		map.put("roleName", memberRole);
		result = memberMapper.setMemberRole(map);
		
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
	
	public MemberVO getFindId(MemberVO memberVO) throws Exception {
		return memberMapper.getFindId(memberVO);
	}

}
