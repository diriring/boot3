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
			 	<h4 style="text-transform: capitalize;">member join</h4>
			</div>
		</div>
		<div class="row mt-5">
			<form action="./join" method="post" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">ID</label>
					<input type="text" class="form-control" id="exampleFormControlInput1" name="id" placeholder="User ID">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Password</label>
					<input type="password" class="form-control" id="exampleFormControlInput2" name="pw" placeholder="User Password">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Name</label>
					<input type="text" class="form-control" id="exampleFormControlInput3" name="name" placeholder="Name">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Email address</label>
					<input type="email" class="form-control" id="exampleFormControlInput4" name="email" placeholder="name@example.com">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Phone Number</label>
					<input type="text" class="form-control" id="exampleFormControlInput5" name="phone" placeholder="010-@@@@-@@@@">
				</div>
				<div class="mb-3">
					<label for="formFile" class="form-label">Profile Picture</label>
					<input class="form-control" type="file" id="formFile" name="mf">
				</div>
				<button type="submit" class="btn btn-primary">JOIN!</button>
			</form>
		</div>
		<div class="row">
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="all">
			  <label class="form-check-label" for="all">
			    checkbox-All
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input ch" type="checkbox" value="" id="check1">
			  <label class="form-check-label" for="check1">
			    checkbox1
			  </label>
			</div>
			
			<div class="form-check">
			  <input class="form-check-input ch" type="checkbox" value="" id="check2">
			  <label class="form-check-label" for="check2">
			    checkbox2
			  </label>
			</div>
			
			<div class="form-check">
			  <input class="form-check-input ch" type="checkbox" value="" id="check3">
			  <label class="form-check-label" for="check3">
			    checkbox3
			  </label>
			</div>
		</div>
	</div>
 <c:import url="../temp/header_script.jsp"></c:import>
 <script type="text/javascript">
 	$("#all").click(function() {
		$(".ch").prop("checked", $("#all").prop("checked"));
 	});
 	$(".ch").change(function() {
 		let check = true;
	 	$(".ch").each(function(idx, item) {
	 		if(!$(item).prop("checked")) {
	 			check = false;
	 		}
	 	})
		$("#all").prop("checked", check);
 	})
 </script>
</body>
</html>