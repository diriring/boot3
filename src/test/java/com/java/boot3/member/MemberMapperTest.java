package com.java.boot3.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberMapperTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	//@Test
	void setFileAdd() throws Exception {
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setFileName("fileName");
		memberFilesVO.setOriName("oriName");
		memberFilesVO.setId("id1234");
		
		int result = memberMapper.setFileAdd(memberFilesVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void joinTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("id1234");
		memberVO.setPw("asdf1234");
		memberVO.setName("name1");
		memberVO.setEmail("id1234@gmail.com");
		memberVO.setPhone("010-1111-1111");
		
		int result = memberMapper.setAdd(memberVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void loginTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("id1234");
		memberVO.setPw("asdf1234");
		
		memberVO = memberMapper.getLogin(memberVO);
		
		System.out.println(memberVO.toString());
	}
	
	@Test
	void mypageTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("id1234");
		
		memberVO = memberMapper.getDetail(memberVO);
		
		System.out.println(memberVO.getMemberFilesVO().getFileName());
		
	}
	
	//@Test
	void setUpdateTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("id1234");
		memberVO.setName("name2424");
		memberVO.setEmail("id2424@gmail.com");
		memberVO.setPhone("010-2222-2222");
		
		int result = memberMapper.setUpdate(memberVO);
		
		System.out.println(memberVO.toString());
		
		assertEquals(1, result);
	}
	
	//@Test
	void SetDeleteTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("id1234");
		
		int result = memberMapper.setDelete(memberVO);
		
		assertEquals(1, result);
	}

}
