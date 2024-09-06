<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			<label>작성자:</label>
			<input type="text" class="form-control" readonly value="${post.po_me_id }">
		</div>
		<div class="form-group">
			<label>작성일:</label>
			<input type="text" class="form-control" readonly value="${post.po_date }">
		</div>
		<div class="form-group">
			<label>조회수:</label>
			<input type="text" class="form-control" readonly value="${post.po_view }">
		</div>
		<div class="form-group">
			<label for="po_title">내용:</label>
			<div class="form-control" id="po_title" style="min-height: 400px; height: auto">${post.po_content }</div>
		</div>
		<div class="form-group">
			<label>첨부파일</label>
			<c:forEach items="${list}" var="file">
				<a href="<c:url value="/download${file.fi_name}"/>" class="form-control" download="${file.fi_ori_name}">${file.fi_ori_name}</a>
			</c:forEach>
		</div>
		<c:if test="${post.po_me_id == user.me_id }">
			<a href="<c:url value="/post/update/${post.po_num}"/>" class="btn btn-outline-info">수정</a>
			<a href="<c:url value="/post/delete/${post.po_co_num}/${post.po_num}"/>" class="btn btn-outline-info">삭제</a>
		</c:if>
	</div>
</body>
</html>
