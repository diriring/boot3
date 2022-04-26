<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<table class="table table-warning table-striped">
		<thead>
			<tr>
				<th>Num</th>
				<th>Name</th>
				<th>Price</th>
				<th>Count</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.productNum}</td>
					<td>${vo.productName}</td>
					<td>${vo.productPrice}</td>
					<td>${vo.productCount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="row mt-5 justify-content-center">
		<div class="col-3">
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item">
			      <a class="page-link pager" href="#" data-pn="${pager.pre?pager.startNum-1:1}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			    	<c:choose>
			    		<c:when test="${pager.pn eq i}">
			    			<li class="page-item active" aria-current="page">
						      <a class="page-link" href="#">${i}</a>
						    </li>
			    		</c:when>
			    		<c:otherwise>
			    			<li class="page-item"><a class="page-link pager" data-pn="${i}" href="#">${i}</a></li>
			    		</c:otherwise>
			    	</c:choose>
			    </c:forEach>
			    <li class="page-item">
			      <a class="page-link pager" href="#" data-pn="${pager.next?pager.lastNum+1:pager.lastNum}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
		</div>
	</div>