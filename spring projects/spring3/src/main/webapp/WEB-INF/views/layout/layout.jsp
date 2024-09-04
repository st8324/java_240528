<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>
		<c:choose>
			<c:when test="${title ne null }">${title}</c:when>
			<c:otherwise>스프링</c:otherwise>
		</c:choose>
	</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
	<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>
</head>
<body>
    <tiles:insertAttribute name="header"/>
    <div class="container">        
        <tiles:insertAttribute name="body" />
    </div>                                                  
</body>
</html>

