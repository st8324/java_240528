<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="/WEB-INF/views/common/head.jsp"/>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<title>게시글 등록</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<div class="container" style="min-height: calc(100vh - 240px)">
	<h1>게시글 등록</h1>
	<form action="<c:url value="/post/insert"/>" method="post">
		<input type="hidden" name="po_co_num" value="${co_num}">
		<div class="form-group">
			<label for="title">제목:</label>
			<input type="text" class="form-control" id="title" name="po_title">
		</div>
		<div class="form-group">
			<label for="content">내용 : </label>
			<textarea class="form-control"name="po_content" id="content"></textarea>
		</div>
		<button type="submit" class="btn btn-outline-success col-12">게시글 등록</button>
	</form>
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
<script type="text/javascript">
$('#content').summernote({
	placeholder: 'Hello Bootstrap 4',
	tabsize: 2,
	height: 400
});
</script>
</body>
</html>