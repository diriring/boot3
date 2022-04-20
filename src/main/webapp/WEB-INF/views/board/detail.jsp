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
	<table class="table">
		<tr>
			<td>${vo.title}</td>
			<td>조회수</td>
			<td>${vo.hit}</td>
		</tr>
		<tr>
			<td colspan="2">${vo.writer}</td>
			<td>${vo.regDate}</td>
		</tr>
		<tr>
			<td colspan="3">${vo.contents}</td>
		</tr>
		<tr>
			<td colspan="3">
				<ul class="list-group">
					<c:forEach items="${vo.filesVOs}" var="f">
						<li class="list-group-item"><a href="./fileDown?fileNum=${f.fileNum}">${f.oriName}</a></li>
					</c:forEach>
				</ul>
			</td>
		</tr>
	</table>
	<div>
		<a class="btn btn-outline-primary" href="./update?num=${vo.num}">수정</a>
		<a class="btn btn-outline-primary" href="./delete?num=${vo.num}">삭제</a>
	</div>
	
	

	
	
</div>

 <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>