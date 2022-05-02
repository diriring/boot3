<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<ul class="list-group">
		<li class="list-group-item">${vo.productName}</li>
		<li class="list-group-item">${vo.id}</li>
		<li class="list-group-item">${vo.productPrice}</li>
		<li class="list-group-item">${vo.productDetail}</li>
	</ul>
	<c:forEach items="${vo.productFilesVO}" var="file">
		<img alt="" src="/resources/upload/product/${file.fileName}">
	</c:forEach>