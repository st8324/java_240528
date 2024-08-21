<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<h1 class="mt-3 mb-3">커뮤니티 목록</h1>
<ul class="list-group">
	<c:forEach items="${list}" var="co">
		<li class="list-group-item">
			<a href="<c:url value="/post/list?co_num=${co.co_num}"/>">${co.co_name}</a>
		</li>
	</c:forEach>
</ul>
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>