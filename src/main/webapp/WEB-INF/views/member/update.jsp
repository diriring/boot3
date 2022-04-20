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
			 	<h4 style="text-transform: capitalize;">member update</h4>
			</div>
		</div>
		<div class="row mt-5">
			<form action="./update" method="post">
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">ID</label>
					<input type="text" readonly class="form-control-plaintext" id="exampleFormControlInput1" name="id" value="${vo.id}">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Name</label>
					<input type="text" class="form-control" id="exampleFormControlInput3" name="name" placeholder="Name" value="${vo.name}">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Email address</label>
					<input type="email" class="form-control" id="exampleFormControlInput4" name="email" placeholder="name@example.com" value="${vo.email}">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Phone Number</label>
					<input type="text" class="form-control" id="exampleFormControlInput5" name="phone" placeholder="010-@@@@-@@@@" value="${vo.phone}">
				</div>
				<button type="submit" class="btn btn-primary">Update</button>
			</form>
		</div>
	</div>
<!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>