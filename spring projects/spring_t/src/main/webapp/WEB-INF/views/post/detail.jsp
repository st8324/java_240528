<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<c:if test="${post ne null }">
		<h1>게시글 상세</h1>
		
		<div class="form-group">
			<label>제목:</label>
			<div class="form-control">${post.po_title }</div>
		</div>
		<div class="form-group">
			<label>작성자:</label>
			<div class="form-control">${post.po_me_id }</div>
		</div>
		<div class="form-group">
			<label>작성일:</label>
			<div class="form-control">${post.po_date }</div>
		</div>
		<div class="form-group">
			<label>조회수:</label>
			<div class="form-control">${post.po_view }</div>
		</div>
		<div class="form-group">
			<label for="content">내용:</label>
			<div class="form-control" style="min-height: 400px; height: auto">${post.po_content }</div>
		</div>
		<c:if test="${list.size() != 0 }">
			<div class="form-group">
				<label>첨부파일:</label>
				<c:forEach items="${list }" var="file">
					<a 	href="<c:url value="/download${file.fi_name}"/>" class="form-control" 
						download="${file.fi_ori_name }">${file.fi_ori_name }</a>
				</c:forEach>
			</div>
		</c:if>
	</c:if>
	<c:if test="${post eq null }">
		<h3>삭제되거나 잘못된 게시글입니다.</h3>
	</c:if>
	<c:url var="url" value="/post/list">
		<c:param name="co_num" value="${cri.co_num }"/>
		<c:param name="page" value="${cri.page }"/>
		<c:param name="type" value="${cri.type }"/>
		<c:param name="search" value="${cri.search}"/>
	</c:url>
	<a href="${url}" class="btn btn-outline-info">목록</a>
</body>
</html>
