<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<%-- <form action="./add" method="post" id="addForm" enctype="multipart/form-data"> --%>
	<form:form modelAttribute="productVO" method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="alert alert-primary" role="alert">
			 	<h4 style="text-transform: capitalize;">${board} Add</h4>
			</div>
			
			<div class="row" id="list">
				<!-- ajax로 상품 리스트, name price count -->
			</div>
			
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">상품명</span>
			  <!-- <input type="text" id="productName" name="productName" class="form-control" placeholder="상품명"> -->
			  <form:input path="productName" cssClass="form-control" placeholder="상품명"/>
			</div>
			<div>
				<form:errors path="productName"></form:errors>
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">가격</span>
			  <!-- <input type="text" id="productPrice" name="productPrice" class="form-control" placeholder="가격"> -->
			  <form:input path="productPrice" cssClass="form-control" placeholder="가격"/>
			</div>
			<div>
				<form:errors path="productPrice"></form:errors>
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">수량</span>
			  <!-- <input type="text" id="productCount" name="productCount" class="form-control" placeholder="수량"> -->
			  <form:input path="productCount" cssClass="form-control" placeholder="수량"/>
			</div>
			<div>
				<form:errors path="productCount"></form:errors>
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">상세설명</span>
			  <!-- <textarea class="form-control" id="productDetail" name="productDetail"></textarea> -->
			  <form:textarea path="productDetail" id="productDetail" cssClass="form-control"/>
			</div>
			<div>
				<form:errors path="productDetail"></form:errors>
			</div>
		</div>
		
		<div class="row mb-3">
			<div class="form-check">
			  <!-- <input class="form-check-input sale" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="1"> -->
			  <form:radiobutton path="sale" cssClass="form-check-input" id="sale1" value="1"/>
			  <label class="form-check-label" for="sale1">
			    판매
			  </label>
			</div>
			<div class="form-check">
			  <!-- <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" value="0" checked> -->
			  <form:radiobutton path="sale" cssClass="form-check-input" id="sale0" value="0"/>
			  <label class="form-check-label" for="sale0">
			    판매중지
			  </label>
			</div>
			<div>
				<form:errors path="sale"></form:errors>
			</div>
		</div>
		
		<button id="fileAdd" type="button" class="btn btn-dark my-4">FileADD</button>
		<div class="row">
			<div id="fileResult"></div>
			<!-- <input type="file" class="form-control" name="files">
			<input type="file" class="form-control" name="files"> -->
		</div>
		<button type="submit" class="btn btn-outline-primary my-4" id="addBtn2">INSERT</button>
	</form:form>
	<%-- </form> --%>
</div>

<script type="text/javascript" src="../resources/js/fileAdd.js"></script>
<script type="text/javascript" src="../js/summernote.js"></script>
<script type="text/javascript">
	ajaxList();
	
	summernoteInit("productDetail", "");
	fileAddInit(0);
	
	$("#addBtn").click(function() {
		let formData = new FormData();
		let productName = $("#productName").val();
		let productPrice = $("#productPrice").val();
		let productCount = $("#productCount").val();
		let productDetail = $("#productDetail").summernote("code"); //$("#productDetail").val();
		$(".files").each(function(idx, item) {
			if(item.files.length>0){
				//formData.append("파라미터명", 값);
				formData.append("files", item.files[0]);
			}
		});//each 끝
		let sale=0;
		$(".sale").each(function(idx, item) {
			if($(item).prop("checked")) {
				sale=$(item).val();
			}
		});
		formData.append("sale", sale);
		formData.append("productName", productName);
		formData.append("productPrice", productPrice);
		formData.append("productCount", productCount);
		formData.append("productDetail", productDetail);
 		
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