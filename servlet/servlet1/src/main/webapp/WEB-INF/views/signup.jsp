<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 class="mt-3">회원가입</h1>
		<!-- 
		회원 가입을 위한 화면을 구성
		- 아이디, 비번, 비번확인, 이메일
		-->
		<form action="">
			<div class="form-group">
				<label for="usr">아이디:</label>
				<input type="text" class="form-control" id="usr">
			</div>
			<div class="form-group">
				<label for="pwd">비번:</label>
				<input type="password" class="form-control" id="pwd">
			</div>
			<div class="form-group">
				<label for="pwd">비번확인:</label>
				<input type="password" class="form-control" id="pwd">
			</div>
			<div class="form-group">
				<label for="pwd">이메일:</label>
				<input type="password" class="form-control" id="pwd">
			</div>
			<button type="submit" class="btn btn-outline-success col-12">회원가입</button>
		</form>
	</div>
</body>
</html>