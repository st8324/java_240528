<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<div class="container">
		<h1 class="mt-3">로그인</h1>
		<form action="<%=request.getContextPath()%>/login" method="post" id="form">
			<div class="form-group">
				<label for="id">아이디:</label>
				<input type="text" class="form-control" id="id" name="id">
			</div>
			<div class="form-group">
				<label for="pw">비번:</label>
				<input type="password" class="form-control" id="pw" name="pw">
			</div>
			<button type="submit" class="btn btn-outline-success col-12">로그인</button>
		</form>
	</div>
</body>
</html>