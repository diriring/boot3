package com.java.boot3.member;

import com.java.boot3.util.FileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MemberFilesVO extends FileVO {
	
	private String id;
	
}
