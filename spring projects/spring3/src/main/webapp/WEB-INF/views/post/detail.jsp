<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>게시글 상세</h1>
	<div>
		<div class="form-group">
			<label for="po_title">제목:</label>
			<input type="text" class="form-control" id="po_title" name="po_title" readonly value="${post.po_title }">
		</div>
		<div class="form-group">
			<label for="po_title">작성자:</label>
			<input type="text" class="form-control" id="po_title" name="po_title" readonly value="${post.po_title }">
		</div>
		<div class="form-group">
			<label for="po_title">작성일:</label>
			<input type="text" class="form-control" id="po_title" name="po_title" readonly value="${post.po_title }">
		</div>
		<div class="form-group">
			<label for="po_title">조회수:</label>
			<input type="text" class="form-control" id="po_title" name="po_title" readonly value="${post.po_title }">
		</div>
		<div class="form-group">
			<label for="po_title">제목:</label>
			<div class="form-control" id="po_title">${post.po_content }</div>
		</div>
	</div>
</body>
</html>
