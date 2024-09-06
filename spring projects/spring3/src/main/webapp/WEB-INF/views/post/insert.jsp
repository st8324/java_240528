<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<link href="<c:url value="/resources/summernote/"/>summernote.min.css" rel="stylesheet">
    <script src="<c:url value="/resources/summernote/"/>summernote.min.js"></script>
</head>
<body>
	<h1>게시글 등록</h1>
	<form action="<c:url value="/post/insert/${co_num}"/>" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="po_title">제목:</label>
			<input type="text" class="form-control" id="po_title" name="po_title">
		</div>
		<div class="form-group">
			<label for="po_title">내용:</label>
			<textarea class="form-control" id="po_content" name="po_content" style="min-height: 400px; height: auto"></textarea >
		</div>
		<div class="form-group">
			<label>첨부파일</label>
			<input type="file" class="form-control" name="fileList"/>
			<input type="file" class="form-control" name="fileList"/>
			<input type="file" class="form-control" name="fileList"/>
		</div>
		<button type="submit" class="btn btn-outline-info col-12">글 등록</button>
	</form>
	<script>
		$('#po_content').summernote({
			placeholder: '내용을 작성하세요.',
			tabsize: 4,
			height: 400
		});
    </script>
</body>
</html>
