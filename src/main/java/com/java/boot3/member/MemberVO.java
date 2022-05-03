package com.java.boot3.member;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemberVO {
	
	@NotBlank(message="ID는 필수입니다.")
	private String id;
	@Size(min=3, max=8, message="PW는 3글자 이상 8글자 이하")
	private String pw;
	
	private String checkPw;
	
	@NotBlank(message="이름은 필수입니다.")
	private String name;
	@Email(message="이메일 형식을 확인해주세요.")
	private String email;
	private String phone;
	
	private MemberFilesVO memberFilesVO;
	
	private List<RoleVO> roleVOs;
}
