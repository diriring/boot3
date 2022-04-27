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
<c:import url="./temp/header.jsp"></c:import>
	<div class="container mt-5">
		<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
		  <div class="carousel-indicators">
		    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
		    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
		    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
		  </div>
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="https://fncent.com/files/2022/02/23/95c2c0687206848f8f867241a1115b1a180649.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="https://fncent.com/files/2022/02/23/c1ef220da543b3d053290efcb3dd2581180649.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="https://fncent.com/files/2022/02/23/875ea9925cc4988746519d241fd2b78a180649.jpg" class="d-block w-100" alt="...">
		    </div>
		  </div>
		  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Previous</span>
		  </button>
		  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Next</span>
		  </button>
		</div>
	</div>
	<div class="container">
		<c:if test="${not empty member}">
			<c:forEach items="${member.roleVOs}" var="role">
				${role.roleName}
			</c:forEach>
		</c:if>
		
	</div>
	<div class="container">
		<input type="text" id="v1">
		
		<input type="checkbox" class="num" name="num" value="a">
		<input type="checkbox" class="num" name="num" value="b">
		<input type="checkbox" class="num" name="num" value="c">
		<input type="checkbox" class="num" name="num" value="d">
		
		<button id="btn1">GET</button>
		<button id="btn2">POST</button>
		<button id="btn3">AJAX</button>
	</div>
	
	<c:import url="./temp/header_script.jsp"></c:import>
	
	<script type="text/javascript">
		$("#btn1").click(function() {
			let v = $("#v1").val();
			console.log(v);
			$.get("./getTest?msg="+v, function(data) {
				console.log("응답 완료");
				console.log(data.trim());
			});
		});
		
		$("#btn2").click(function() {
			$.post("./postTest", {msg: $("#v1").val()},function(result) {
				console.log(result.trim());
			});
		});
		
		$("#btn3").click(function() {
			let ar = [];
			$(".num").each(function(idx, item) {
		 		if($(item).prop("checked")) {
		 			ar.push($(item).val());
		 		}
		 	});
			
			let v = $("#v1").val();
			$.ajax({
				type: "POST",
				url: "./arrayTest",
				traditional: true,
				data: {
					msg: v,
					numbers: ar
				},
				success: function(d) {
					console.log(d.trim());	
				},
				error: function() {
					alert("error");
				}
			});
		});
	</script>
</body>
</html>