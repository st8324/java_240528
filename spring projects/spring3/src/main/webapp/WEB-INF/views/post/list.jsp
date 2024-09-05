<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>게시글 목록</h1>
	<div class="mt-3 mb-3">
		<c:forEach items="${communities}" var="community">
			<a href="<c:url value="/post/list/${community.co_num}"/>" class="btn btn-outline-info">${community.co_name}</a>
		</c:forEach>
	</div>
	<table class="table table-striped">
	    <thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>추천수</th>
				<th>조회수</th>
			</tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${list }" var="post">
				<tr>
					<td>${post.po_num}</td>
					<td>
						<a href="">${post.po_title }</a>
					</td>
					<td>
						<a href="">${post.po_me_id }</a>
					</td>
					<td>
						<fmt:formatDate value="${post.po_date }" pattern="yyyy-MM-dd"/>
					</td>
					<td>추천수</td>
					<td>${post.po_view }</td>
				</tr>
			</c:forEach>
			<c:if test="${list.size() eq 0 }">
				<tr>
					<td colspan="6" class="text-center">등록된 게시글이 없습니다.</td>
				</tr>
			</c:if>
	    </tbody>
	</table>
</body>
</html>
