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
	<div class="row">
		<div class="alert alert-primary" role="alert">
		 	<h4 style="text-transform: capitalize;">board List</h4>
		</div>
	</div>

	<div class="row mt-5">
		<form action="./list" method="get">
			<div class="col-2" style="display: inline-block">
				<select class="form-select" name="kind" aria-label="Default select example">
				  <option value="col1">제목</option>
				  <option value="col2">내용</option>
				  <option value="col3">작성자</option>
				</select>
			</div>
			<div class="col-3" style="display: inline-block">
				<div class="input-group mb-3">
				  <input type="text" name="search" value="${pager.search}" class="form-control" placeholder="검색어를 입력하세요." aria-label="Recipient's username" aria-describedby="button-addon2">
				  <button class="btn btn-outline-secondary" type="submit" id="button-addon2">검색</button>
				</div>
			</div>
		</form>
	</div>
	
		<table class="table table-striped table-hover">
			<colgroup>
				<col width="12%"/>
				<col width="52%"/>
				<col width="12%"/>
				<col width="12%"/>
				<col width="12%"/>
			</colgroup>
			<thead>
				<tr>
					<th>글 번호</th>
					<th>글 제목</th>
					<th>작성자</th>
					<th>작성날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.num}</td>
					<td>${vo.title}</td>
					<td>${vo.writer}</td>
					<td>${vo.regDate}</td>
					<td>${vo.hit}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="row justify-content-end">
		<a href="./add" class="col-1 btn btn-outline-primary">WRITE</a>
	</div>
</div>

 <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>