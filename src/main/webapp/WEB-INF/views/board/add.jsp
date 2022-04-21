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
<title>Insert title here</title>
</head>
<body>
<!-- Header -->
<c:import url="../temp/header.jsp"></c:import>

<div class="container mt-5">
	<form action="./add" method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="alert alert-primary" role="alert">
			 	<h4 style="text-transform: capitalize;">${board} Add</h4>
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">글 제목</span>
			  <input type="text" name="title" class="form-control" placeholder="Title" aria-label="Username" aria-describedby="basic-addon1">
			  <span class="input-group-text" id="basic-addon1">작성자</span>
			  <input type="text" name="writer" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
			</div>
		</div>
		<div class="row">
			<div class="input-group">
			  <span class="input-group-text">글 내용</span>
			  <textarea name="contents" class="form-control" aria-label="With textarea"></textarea>
			</div>
		</div>
		<button id="fileAdd" type="button" class="btn btn-dark my-4">FileADD</button>
		<div class="row">
			<div id="fileResult"></div>
			<!-- <input type="file" class="form-control" name="files">
			<input type="file" class="form-control" name="files"> -->
		</div>
		<button type="submit" class="btn btn-outline-primary my-4">WRITE</button>
	</form>
</div>
<c:import url="../temp/header_script.jsp"></c:import>
<script type="text/javascript">
	let count = 0;
	$("#fileAdd").click(function() {
		if(count >= 5) {
			alert("파일은 5개까지만");
			return;
		}
		let result = '<div class="input-group">';
		result = result + '<input type="file" class="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">';
		result = result + '<button class="btn btn-outline-secondary del" type="button" id="inputGroupFileAddon04">X</button>';
		result = result + '</div>'
		
		$("#fileResult").append(result);
		count++;
	});
	
	$("#fileResult").on("click", ".del", function() {
		$(this).parent().remove();
		count--;
	});
</script>
</body>
</html>