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
	<form action="./add" method="post" id="addForm" enctype="multipart/form-data">
		<div class="row">
			<div class="alert alert-primary" role="alert">
			 	<h4 style="text-transform: capitalize;">${board} Add</h4>
			</div>
			
			<div class="row" id="list">
				<!-- ajax로 상품 리스트, name price count -->
			</div>
			
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">상품명</span>
			  <input type="text" id="productName" name="productName" class="form-control" placeholder="상품명">
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">가격</span>
			  <input type="text" id="productPrice" name="productPrice" class="form-control" placeholder="가격">
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">수량</span>
			  <input type="text" id="productCount" name="productCount" class="form-control" placeholder="수량">
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">상세설명</span>
			  <textarea class="form-control" id="productDetail" name="productDetail"></textarea>
			</div>
		</div>
		<button id="fileAdd" type="button" class="btn btn-dark my-4">FileADD</button>
		<div class="row">
			<div id="fileResult"></div>
			<!-- <input type="file" class="form-control" name="files">
			<input type="file" class="form-control" name="files"> -->
		</div>
		<button type="button" class="btn btn-outline-primary my-4" id="addBtn">INSERT</button>
	</form>
</div>

<script type="text/javascript">
	ajaxList();
	
	$("#productDetail").summernote({
		height: 400
	});

	let count = 0;
	$("#fileAdd").click(function() {
		if(count >= 5) {
			alert("파일은 5개까지만");
			return;
		}
		let result = '<div class="input-group">';
		result = result + '<input type="file" class="form-control files" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload" name="files">';
		result = result + '<button class="btn btn-outline-secondary del" type="button" id="inputGroupFileAddon04">X</button>';
		result = result + '</div>'
		
		$("#fileResult").append(result);
		count++;
	});
	
	$("#fileResult").on("click", ".del", function() {
		$(this).parent().remove();
		count--;
	});
	
	$("#addBtn").click(function() {
		
/* 		let formData = new FormData($("#addForm")[0]); */

		let formData = new FormData();

   		formData.append('productName', $("#productName").val());
		formData.append('productPrice', $("#productPrice").val());
		formData.append('productCount', $("#productCount").val());
		formData.append('productDetail', $("#productDetail").val());
		//productDetail: $("#productDetail").summernote("code")
		$(".files").each(function(idx, item) {
			if(item.files.length>0) {
				formData.append('files', item.files[0]);
				//input 태그의 file List의 첫번째 항목이 file 정보	
			}
		});
		$.ajax({
			type: "POST",
			url: "./add",
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			data: formData,
			success: function(d) {
				if(d.trim() == '1') {
					alert("상품 등록 완료");
					ajaxList();
					$("#productName").val("");
					$("#productPrice").val("");
					$("#productCount").val("");
					$("#productDetail").val("");
				}else {
					alert("상품 등록 실패");
				}
			},
			error: function() {
				alert("error");
			}
		});
	});
	
	//list
	//url: ajaxList, GET
	function ajaxList(pn) {
		$.ajax({
			type: "GET",
			url: "./ajaxList",
			data: {
				perPage: 5,
				pn: pn
			},
			success: function(result) {
				$("#list").html(result.trim());
			}
		});
	};
	
	$("#list").on("click", ".pager", function() {
		ajaxList($(this).attr("data-pn"))
	});
</script>
</body>
</html>