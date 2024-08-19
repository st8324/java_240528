<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="container">
	<h1>게시글 수정</h1>
	<form action="<c:url value="/post/update"/>" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="title">제목:</label>
			<input type="text" class="form-control" id="title" name="title" value="${post.po_title }">
		</div>
		<div class="form-group">
			<label for="content">내용:</label>
			<textarea class="form-control" id="content" name="content">${post.po_content }</textarea>
		</div>
		<div class="form-group attachment-box">
			<label for="content">첨부파일:</label>
			<c:if test="${fileList.size() == 0 }">
				<div class="form-control">첨부파일 없음</div>
			</c:if>
			<c:if test="${fileList.size() != 0 }">
				<c:forEach items="${fileList}" var="file">
					<div class="form-control">
						<span>${file.fi_ori_name}</span>
						<span class="btn-del" style="cursor: pointer;" data-num="${file.fi_num}">X</span>
					</div>
				</c:forEach>
				<c:forEach begin="1" end="${3 - fileList.size() }">
					<input type="file" class="form-control" name="fileList">
				</c:forEach>
			</c:if>
		</div>
		<button type="submit" class="btn btn-outline-success col-12">등록</button>
		<input type="hidden" name="po_num" value="${post.po_num}">
	</form>
</div>
<script>
	$('#content').summernote({
		placeholder: '게시글을 작성해주세요.',
		tabsize: 2,
		height: 400
	});
	$('.btn-del').click(function(){
		var inputFile = `<input type="file" class="form-control" name="fileList">`;
		var fi_num = $(this).data('num');
		var inputHidden = `<input type="hidden" name="fi_num" value="\${fi_num}">`;
		
		$('.attachment-box').append(inputFile);
		$('.attachment-box').append(inputHidden);
		$(this).parent().remove();
	});
</script>
</body>
</html>