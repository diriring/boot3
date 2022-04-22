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
		 	<h4 style="text-transform: capitalize;">${board} List</h4>
		</div>
	</div>

	<div class="row mt-5">
 		<form action="./list" method="get">
			<div class="col-2" style="display: inline-block">
				<select class="form-select" name="kind" aria-label="Default select example">
				  <option value="col1">상품명</option>
				  <option value="col2">상세설명</option>
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
		
	<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3 d-flex align-items-center">
		<c:forEach items="${list}" var="vo">
			<div class="col">
				<div class="card justify-content-center">
					<c:choose>
						<c:when test="${empty vo.productFilesVO}">
							<img src="/resources/upload/product/no-image.png" class="card-img-top" alt="...">
						</c:when>
						<c:otherwise>
							<img src="/resources/upload/product/${vo.productFilesVO[0].fileName}" class="card-img-top" alt="...">
						</c:otherwise>
					</c:choose>
				  <div class="card-body">
				    <h5 class="card-title">${vo.productName}</h5>
				    <h5 class="card-title">${vo.productPrice}원</h5>
				    <p class="card-text">${vo.productDetail}</p>
				    <a href="#" class="btn btn-primary">Detail View</a>
				  </div>
				</div>
			</div>
		</c:forEach>
	</div>

	<div class="row mt-5 justify-content-between">
		<div class="col-3">
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item">
			      <a class="page-link" href="./list?pn=${pager.pre?pager.startNum-1:1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			    	<c:choose>
			    		<c:when test="${pager.pn eq i}">
			    			<li class="page-item active" aria-current="page">
						      <a class="page-link" href="./list?pn=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
						    </li>
			    		</c:when>
			    		<c:otherwise>
			    			<li class="page-item"><a class="page-link" href="./list?pn=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
			    		</c:otherwise>
			    	</c:choose>
			    </c:forEach>
			    <li class="page-item">
			      <a class="page-link" href="./list?pn=${pager.next?pager.lastNum+1:pager.lastNum}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
		</div>
	 	<div class="col-9">
			<div class="d-grid justify-content-end">
				<a href="./add" class="btn btn-outline-primary">ADD</a>
			</div>
		</div>
	</div>

</div>

<c:import url="../temp/header_script.jsp"></c:import>
</body>
</html>