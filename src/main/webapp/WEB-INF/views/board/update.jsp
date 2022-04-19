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
	<form action="./update" method="post">
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
			  <textarea name="contents" class="form-control" aria-label="With textarea">${vo.contents}</textarea>
			</div>
		</div>
		<div class="row">
			<div class="row justify-content-end">
				<button type="submit" class="col-1 btn btn-outline-primary">수정</button>
			</div>
		</div>
	</form>
</div>

 <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>