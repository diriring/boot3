<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
				<h4 style="text-transform: capitalize;">member login</h4>
			</div>
		</div>
		<div class="row mt-5">
			<form:form modelAttribute="memberVO" method="post">
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">ID</label>
					<%-- <input type="text" class="form-control" id="exampleInputEmail1" name="id" value="${cookie.remember.value}"> --%>
					<form:input path="id" cssClass="form-control" id="id"/>
					<div>
						<form:errors path="id"></form:errors>
					</div>
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">Password</label>
					<!-- <input type="password" class="form-control" id="exampleInputPassword1" name="pw"> -->
					<form:password path="pw" cssClass="form-control" id="pw"/>
					<div>
						<form:errors path="pw" cssStyle="color: red;"></form:errors>
					</div>
				</div>
 				<div class="mb-3 form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1" name="remember" value="1">
					<label class="form-check-label" for="exampleCheck1">Check me out</label>
				</div>
				<button type="submit" class="btn btn-primary">Login</button>
				<div class="row">
					<button id="find" type="button" class="btn btn-danger">ID ??????</button>
				</div>
			</form:form>
		</div>
	</div>

<c:import url="../temp/header_script.jsp"></c:import>
<script type="text/javascript">
	$("#find").click(function() {
		location.href="./findId";
	});
</script>
</body>
</html>