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

<div class="container">
<h1>Manage Detail Page</h1>
	<div class="row">
		<c:import url="../temp/detail.jsp"></c:import>
	</div>
	<div class="row mt-3">
		<div class="d-flex justify-content-end">
			<a href="./update?productNum=${vo.productNum}" class="btn btn-outline-primary">UPDATE</a>
		</div>
	</div>
</div>


<c:import url="../temp/header_script.jsp"></c:import>
</body>
</html>