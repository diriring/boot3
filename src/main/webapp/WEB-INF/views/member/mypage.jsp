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
           <div class="col-3">
               <div class="sidebar">
                   <div class="sidebar__item">
                       <h4>마이페이지</h4>
                       <ul>
                           <li><a href="./update">회원정보 수정</a></li>
                           <li><a href="./delete">회원탈퇴</a></li>
                       </ul>
                   </div>
                  </div>
			</div>
			<div class="col-9">
				<table class="table">
					<colgroup>
						<col width="35%"/>
						<col width="65%"/>
					</colgroup>
					<tr>
						<td rowspan="4">
							<img src="/resources/upload/member/${vo.memberFilesVO.fileName}" class="img-thumbnail" style="width:200px;">
						</td>
						<td>${vo.id}</td>
					</tr>
					<tr>
						<td>${vo.name}</td>
					</tr>
					<tr>
						<td>${vo.email}</td>
					</tr>
					<tr>
						<td>${vo.phone}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
<!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>