<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="/WEB-INF/views/common/head.jsp"/>
<title>메인</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<div class="container" style="min-height: calc(100vh - 240px)">
	<h1 class="mt-3 mb-3">${co.co_name } 게시글 목록</h1>
	<form action="">
		<div class="input-group mb-3">
			<select class="form-control" name="type">
				<option value="all" <c:if test="${pm.cri.type == 'all' }">selected</c:if>>전체</option>
				<option value="title" <c:if test="${pm.cri.type == 'title' }">selected</c:if>>제목</option>
				<option value="writer" <c:if test="${pm.cri.type == 'writer' }">selected</c:if>>작성자</option>
			</select>
		    <input type="text" class="form-control" placeholder="검색어를 입력하세요." name="search" value="${pm.cri.search}">
		    <div class="input-group-append">
				<button type="submit" class="btn btn-outline-success">검색</button>
		    </div>
		    <input type="hidden" name="co_num" value="${pm.cri.co_num}">
		  </div>
	</form>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="post">
				<tr>
					<td>${post.po_num }</td>
					<td>
						<a href="<c:url value="/post/detail?po_num=${post.po_num }"/>">${post.po_title }</a>
					</td>
					<td>
						<c:url value="/post/list" var="url">
							<c:param name="type" value="writer"/>
							<c:param name="search" value="${post.po_me_id }"/>
							<c:param name="co_num" value="${pm.cri.co_num }"/>
						</c:url>
						<a href="${url}">${post.po_me_id}</a>
					</td>
					<td>
						<fmt:formatDate value="${post.po_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>${post.po_view}</td>
				</tr>
			</c:forEach>
			<c:if test="${list.size() == 0 }">
				<tr>
					<th colspan="5" class="text-center">등록된 게시글이 없습니다.</th>
				</tr>
			</c:if>
		</tbody>
	</table>
	<c:if test="${pm.endPage ne 0 }">
		<ul class="pagination justify-content-center">
			<c:if test="${!pm.prev}">
				<c:set var="prev" value="disabled"/>
			</c:if>
			<c:url var="url" value="/post/list">
				<c:param name="co_num" value="${pm.cri.co_num}"/>
				<c:param name="page" value="${pm.startPage - 1 }"/>
				<c:param name="type" value="${pm.cri.type }"/>
				<c:param name="search" value="${pm.cri.search }"/>
			</c:url>
		   	<li class="page-item ${prev}">
		   		<a class="page-link" href="${url}">이전</a>
	   		</li>
	   		<c:forEach begin="${pm.startPage}" end="${pm.endPage }" var="i">
	   			<c:if test="${pm.cri.page == i}">
					<c:set var="active" value="active"/>
				</c:if>
				<c:if test="${pm.cri.page != i}">
					<c:set var="active" value=""/>
				</c:if>
				<c:url var="url" value="/post/list">
					<c:param name="co_num" value="${pm.cri.co_num}"/>
					<c:param name="page" value="${i}"/>
					<c:param name="type" value="${pm.cri.type }"/>
				<c:param name="search" value="${pm.cri.search }"/>
				</c:url>
			   	<li class="page-item ${active }">
			   		<a class="page-link" href="${url}">${i}</a>
			   	</li>
		   	</c:forEach>
		   	<c:if test="${!pm.next}">
				<c:set var="next" value="disabled"/>
			</c:if>
			<c:url var="url" value="/post/list">
				<c:param name="co_num" value="${pm.cri.co_num}"/>
				<c:param name="page" value="${pm.endPage + 1 }"/>
				<c:param name="type" value="${pm.cri.type }"/>
				<c:param name="search" value="${pm.cri.search }"/>
			</c:url>
		   	<li class="page-item ${next}">
		   		<a class="page-link" href="${url }">다음</a>
		   	</li>
		</ul>
	</c:if>
	<div class="clearfix">
		<a class="btn btn-outline-success float-right" href="<c:url value="/post/insert?co_num=${co.co_num}"/>">게시글 등록</a>
	</div>
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>