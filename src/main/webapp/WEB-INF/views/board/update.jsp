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
		<input type="hidden" name="num" value="${vo.num}">
		<div class="row">
			<div class="alert alert-primary" role="alert">
			 	<h4 style="text-transform: capitalize;">${board} Add</h4>
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">글 제목</span>
			  <input type="text" name="title" class="form-control" placeholder="Title" aria-label="Username" aria-describedby="basic-addon1" value="${vo.title}">
			  <span class="input-group-text" id="basic-addon1">작성자</span>
			  <input type="text" name="writer" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" value="${vo.writer}" readonly="readonly">
			</div>
		</div>
		<div class="row">
			<div class="input-group">
			  <span class="input-group-text">글 내용</span>
			  <textarea id="contents" name="contents" class="form-control" aria-label="With textarea"></textarea>
			</div>
		</div>
		<button id="fileAdd" type="button" class="btn btn-dark my-4">FileADD</button>
		<div class="row">
			<c:forEach items="${vo.filesVOs}" var="fileVO">
				<h4>${fileVO.oriName}<button type="button" class="del" data-num="${fileVO.fileNum}">DELETE</button></h4>
			</c:forEach>
			<div id="fileResult"></div>
			<!-- <input type="file" class="form-control" name="files">
			<input type="file" class="form-control" name="files"> -->
		</div>
		<div class="row">
			<div class="row justify-content-end">
				<button type="submit" class="col-1 btn btn-outline-primary">수정</button>
			</div>
		</div>
	</form>
</div>

<script type="text/javascript" src="../resources/js/fileAdd.js"></script>
<script type="text/javascript" src="../js/summernote.js"></script>
<script type="text/javascript">
 	summernoteInit("contents", '${vo.contents}');
	fileAddInit(${vo.filesVOs.size()});
	fileDeleteInit();
</script> 
</body>
</html>