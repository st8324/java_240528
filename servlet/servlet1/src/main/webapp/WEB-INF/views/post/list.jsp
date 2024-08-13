<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	<form class="input-group mb-3" action="<c:url value="/post/list"/>">
		<div class="input-group-prepend">
			<select class="form-control" name="type">
				<c:if test="${pm.cri.type == 'all' }">selected</c:if>
				<option value="all" <c:if test="${pm.cri.type == 'all' }">selected</c:if>>전체</option>
				<option value="title" <c:if test="${pm.cri.type == 'title' }">selected</c:if>>제목</option>
				<option value="id" <c:if test="${pm.cri.type == 'id' }">selected</c:if>>작성자</option>
			</select>
		</div>
		<input type="text" class="form-control" placeholder="검색어를 입력하세요." name="search" value="${pm.cri.search}">
		<div class="input-group-append">
			<button class="btn btn-primary" type="submit">검색</button>
		</div>
		<input type="hidden" name="co_num" value="${pm.cri.co_num}">
	</form>
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
			<c:forEach items="${list}" var="post" varStatus="vs">
				<tr>
					<!-- 전체 게시글 수에 맞춰서 게시글 번호를 배정 -->
					<td>${pm.totalCount - vs.index - pm.cri.pageStart }</td>
					<!-- 실제 게시글 번호를 배정 -->
					<!-- <td>${post.po_num }</td> -->
					<td>
						<a href="<c:url value="/post/detail?num=${post.po_num}"/>">${post.po_title }</a>
					</td>
					<td>${post.po_me_id}</td>
					<td><fmt:formatDate value="${post.po_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>
					<c:choose>
						<c:when test="${post.po_up eq 0 && post.po_down eq 0 }">0</c:when>
						<c:otherwise>
							${post.po_up }/
							<c:choose>
								<c:when test="${post.po_down == 0}">0</c:when>
								<c:otherwise>-${post.po_down}</c:otherwise>
							</c:choose>
							
						</c:otherwise>
					</c:choose>
					
					</td>
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
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
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
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
				</c:url>
				<a class="page-link" href="${url}">${i}</a>
			</li>
		</c:forEach>
		<c:if test="${pm.next}">
			<li class="page-item">
				<c:url var="url" value="/post/list">
					<c:param name="co_num" value="${pm.cri.co_num}"/>
					<c:param name="page" value="${pm.endPage+1}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
				</c:url>
				<a class="page-link" href="${url}">다음</a>
			</li>
		</c:if>
	</ul>
	<a href="<c:url value="/post/insert?co_num=${pm.cri.co_num}"/>" class="btn btn-outline-danger">게시글 등록</a>
</div>
</body>
</html>