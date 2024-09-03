<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<h1>로그인</h1>
	<form action="<c:url value="/login"/>" method="post" id="form">
		<div class="form-group">
			<label for="id">아이디:</label>
			<input type="text" class="form-control" id="id" name="me_id">
		</div>
		<div class="form-group">
			<label for="pw">비번:</label>
			<input type="password" class="form-control" id="pw" name="me_pw">
		</div>
		<div class="form-check">
			<label class="form-check-label">
				<input type="checkbox" class="form-check-input" value="true" name="autoLogin">자동로그인
			</label>
		</div>
		<button type="submit" class="btn btn-outline-success col-12">로그인</button>
	</form>
	<a href="<c:url value="/find/pw"/>">비번찾기</a>
</body>
</html>