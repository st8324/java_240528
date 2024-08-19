<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- Brand/logo -->
		<a class="navbar-brand" href="<c:url value="/"/>">Home</a>
		
		<!-- Links -->
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/community"/>">커뮤니티</a>
			</li>
			<c:if test="${user ne null && user.me_authority eq 'ADMIN' }">
				<li class="nav-item">
					<a class="nav-link" href="<c:url value="/admin/community"/>">커뮤니티 관리</a>
				</li>
			</c:if>
			<c:choose>
				<c:when test="${user == null }">
					<li class="nav-item">
						<a class="nav-link" href="<c:url value="/signup"/>">회원가입</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="<c:url value="/login"/>">로그인</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="nav-item">
						<a class="nav-link" href="<c:url value="/logout"/>">로그아웃</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
</body>
</html>