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
	<!-- 
	2. 게시글 목록을 이용해서 화면을 구성
	3. 페이지네이션 정보를 이용해서 화면을 구성
	4. 검색 기능 구현
	 -->
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
						${post.po_title }
					</td>
					<td>${post.po_me_id}</td>
					<td>
						<fmt:formatDate value="${post.po_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>${post.po_view}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul class="pagination justify-content-center">
		<c:if test="${!pm.prev}">
			<c:set var="prev" value="disabled"/>
		</c:if>
		<c:url var="url" value="/post/list">
			<c:param name="co_num" value="${pm.cri.co_num}"/>
			<c:param name="page" value="${pm.startPage - 1 }"/>
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
		</c:url>
	   	<li class="page-item ${next}">
	   		<a class="page-link" href="${url }">다음</a>
	   	</li>
	</ul>
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>