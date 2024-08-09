<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${co.co_name} 커뮤니티</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="container">
	<h1>${co.co_name} 커뮤니티 목록</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>추천</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="post">
				<tr>
					<td>${post.po_num}</td>
					<td>
						<a href="">${post.po_title }</a>
					</td>
					<td>${post.po_me_id}</td>
					<td>${post.po_date }</td>
					<td>${post.po_view }</td>
				</tr>
			</c:forEach>
			<c:if test="${list.size() == 0 }">
				<tr>
					<th colspan="6" class="text-center">등록된 게시글이 없습니다.</th>
				</tr>
			</c:if>
		</tbody>
	</table>
	<ul class="pagination justify-content-center">
		<c:if test="${pm.prev}">
			<li class="page-item">
				<c:url var="url" value="/post/list">
					<c:param name="co_num" value="${pm.cri.co_num}"/>
					<c:param name="page" value="${pm.startPage-1}"/>
				</c:url>
				<a class="page-link" href="${url}">이전</a>
			</li>
		</c:if>
		<c:forEach begin="${pm.startPage}" end="${pm.endPage }" var="i">
			<c:choose>
				<c:when test="${pm.cri.page == i}">
					<c:set var="active" value="active"/>
				</c:when>
				<c:otherwise>
					<c:set var="active" value=""/>
				</c:otherwise>
			</c:choose>
			<li class="page-item ${active}">
				<c:url var="url" value="/post/list">
					<c:param name="co_num" value="${pm.cri.co_num}"/>
					<c:param name="page" value="${i}"/>
				</c:url>
				<a class="page-link" href="${url}">${i}</a>
			</li>
		</c:forEach>
		<c:if test="${pm.next}">
			<li class="page-item">
				<c:url var="url" value="/post/list">
					<c:param name="co_num" value="${pm.cri.co_num}"/>
					<c:param name="page" value="${pm.endPage+1}"/>
				</c:url>
				<a class="page-link" href="${url}">다음</a>
			</li>
		</c:if>
	</ul>
</div>
</body>
</html>