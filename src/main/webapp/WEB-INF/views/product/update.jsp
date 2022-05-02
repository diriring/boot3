<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<c:import url="../temp/header_script.jsp"></c:import>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<!-- Header -->
<c:import url="../temp/header.jsp"></c:import>

<div class="container mt-5">
	<form action="./update" method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="alert alert-primary" role="alert">
			 	<h4 style="text-transform: capitalize;">${board} Update</h4>
			</div>
			
			<div class="row" id="list">
				<!-- ajax로 상품 리스트, name price count -->
			</div>
			
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">상품명</span>
			  <input type="text" id="productName" name="productName" class="form-control" placeholder="상품명" value="${vo.productName}">
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">가격</span>
			  <input type="text" id="productPrice" name="productPrice" class="form-control" placeholder="가격" value="${vo.productPrice}">
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">수량</span>
			  <input type="text" id="productCount" name="productCount" class="form-control" placeholder="수량" value="${vo.productCount}">
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">상세설명</span>
			  <textarea class="form-control" id="productDetail" name="productDetail"></textarea>
			</div>
		</div>
		
		<div class="row mb-3">
			<div class="form-check">
			  <input class="form-check-input sale" type="radio" name="sale" id="flexRadioDefault1" value="1" ${vo.sale eq '1'?"checked":''}>
			  <label class="form-check-label sale" for="flexRadioDefault1">
			    판매
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="sale" id="flexRadioDefault2" value="0" ${vo.sale eq '0'?"checked":''}>
			  <label class="form-check-label" for="flexRadioDefault2">
			    판매중지
			  </label>
			</div>
		</div>
		
		<button id="fileAdd" type="button" class="btn btn-dark my-4">FileADD</button>
		<div class="row">
			<c:forEach items="${vo.productFilesVO}" var="fileVO">
				<h4>${fileVO.oriName}<button type="button" class="del" data-num="${fileVO.fileNum}">DELETE</button></h4>
			</c:forEach>
			<div id="fileResult"></div>
			<!-- <input type="file" class="form-control" name="files">
			<input type="file" class="form-control" name="files"> -->
		</div>
		<input type="hidden" name="productNum" value="${vo.productNum}">
		<button type="submit" class="btn btn-outline-primary my-4" id="addBtn">UPDATE</button>
	</form>
</div>

<script type="text/javascript" src="../resources/js/fileAdd.js"></script>
<script type="text/javascript" src="../js/summernote.js"></script>
<script type="text/javascript">
	summernoteInit("productDetail", "${vo.productDetail}");
	fileAddInit(${vo.productFilesVO.size()});
	fileDeleteInit();
</script>
</body>
</html>