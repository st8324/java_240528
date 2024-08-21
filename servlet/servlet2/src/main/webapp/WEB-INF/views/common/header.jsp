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
  <!-- Brand -->
  <a class="navbar-brand" href="<c:url value="/"/>">Home</a>

  <!-- Links -->
  <ul class="navbar-nav">
   	<li class="nav-item">
      <a class="nav-link" href="<c:url value="/community"/>">커뮤니티</a>
    </li>
  	<c:if test="${user == null}">
	    <li class="nav-item">
	      <a class="nav-link" href="<c:url value="/signup"/>">회원가입</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<c:url value="/login"/>">로그인</a>
	    </li>
	</c:if>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Dropdown link
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="#">Link 1</a>
        <a class="dropdown-item" href="#">Link 2</a>
        <a class="dropdown-item" href="#">Link 3</a>
      </div>
    </li>
    <c:if test="${user != null }">
    	<li class="nav-item">
	      <a class="nav-link" href="<c:url value="/logout"/>">로그아웃</a>
	    </li>
    </c:if>
  </ul>
</nav>
</body>
</html>