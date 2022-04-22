package com.java.boot3.product;

import com.java.boot3.board.BoardFilesVO;
import com.java.boot3.util.FileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductFilesVO extends FileVO {

	private Long productNum;
	
}
