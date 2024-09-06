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
			<c:choose>
				<c:when test="${community.co_num == pm.cri.co_num }">
					<c:set var="outline" value=""/>
				</c:when>
				<c:otherwise>
					<c:set var="outline" value="outline-"/>
				</c:otherwise>
			</c:choose>
			<a href="<c:url value="/post/list/${community.co_num}"/>" class="btn btn-${outline}info">${community.co_name}</a>
		</c:forEach>
	</div>
	<c:if test="${pm.cri.co_num != 0 }">
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
							<a href="<c:url value="/post/detail/${post.po_num }"/>">${post.po_title }</a>
						</td>
						<td>
							<c:url var="url" value="/post/list/${pm.cri.co_num}">
								<c:param name="type" value="po_me_id"/>
								<c:param name="search" value="${post.po_me_id }"/>
							</c:url>
							<a href="${url }">${post.po_me_id }</a>
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
		<ul class="pagination justify-content-center">
			<c:if test="${pm.prev }">
				<c:url var="url" value="/post/list/${pm.cri.co_num}">
					<c:param name="page" value="${pm.startPage - 1}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
				</c:url>
			    <li class="page-item">
			    	<a class="page-link" href="${url}">이전</a>
			    </li>
		    </c:if>
		    <c:forEach begin="${pm.startPage }" end="${pm.endPage}" var="i">
		    	<c:choose>
		    		<c:when test="${pm.cri.page == i }">
		    			<c:set var="active" value="active" />
		    		</c:when>
		    		<c:otherwise>
		    			<c:set var="active" value="" />
		    		</c:otherwise>
		    	</c:choose>
		    	<c:url var="url" value="/post/list/${pm.cri.co_num}">
					<c:param name="page" value="${i}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
				</c:url>
			    <li class="page-item ${active }">
			    	<a class="page-link" href="${url }">${i}</a>
			    </li>
		    </c:forEach>
		    <c:if test="${pm.next }">
		    	<c:url var="url" value="/post/list/${pm.cri.co_num}">
					<c:param name="page" value="${pm.endPage + 1}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
				</c:url>
			    <li class="page-item">
			    	<a class="page-link" href="${url}">다음</a>
			    </li>
		    </c:if>
		</ul>
		<form class="input-group mb-3" action="<c:url value="/post/list/${pm.cri.co_num}"/>" method="get">
			<select class="form-control" name="type">
				
				<option value="" <c:if test="${pm.cri.type == '' }">selected</c:if>>전체</option>
				<option value="po_me_id" <c:if test="${pm.cri.type == 'po_me_id' }">selected</c:if>>작성자</option>
				<option value="po_title" <c:if test="${pm.cri.type == 'po_title' }">selected</c:if>>제목</option>
			</select>
		    <input type="text" class="form-control" placeholder="검색어" name="search" value="${pm.cri.search}">
		    <div class="input-group-append">
				<button class="btn btn-outline-info">검색</button>
		    </div>
		</form>
		<a href="<c:url value="/post/insert/${pm.cri.co_num}"/>" class="btn btn-outline-info btn-insert">글쓰기</a>
	</c:if>
	
	<script type="text/javascript">
		$('.btn-insert').click(function(e){
			if('${user.me_id}' != ''){
				return;
			}
			e.preventDefault();
			if(confirm('로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하겠습니까?')){
				location.href = "<c:url value="/guest/login"/>"
			}
		});
	</script>
</body>
</html>
