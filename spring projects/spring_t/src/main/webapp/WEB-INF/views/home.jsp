<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="justify-content: space-between;">
	<ul class="navbar-nav">
		<li class="nav-item">
			<a class="navbar-brand" href="<c:url value="/"/>">Home</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="<c:url value="/community"/>">커뮤니티</a>
		</li>
		<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
			  커뮤니티
			</a>
			<div class="dropdown-menu" id="community-list">
			</div>
		</li>
	</ul>
	<ul class="navbar-nav">
		<c:if test="${user == null}">
		    <li class="nav-item">
				<a class="nav-link" href="<c:url value="/signup"/>">회원가입</a>
		    </li>
		    <li class="nav-item">
				<a class="nav-link" href="<c:url value="/login"/>">로그인</a>
		    </li>
		</c:if>
	    <c:if test="${user != null }">
	    	<li class="nav-item">
				<a class="nav-link" href="<c:url value="/logout"/>">로그아웃</a>
		    </li>
	    </c:if>
	</ul>
</nav>
<div class="container">
	<h1>
		Hello world!  
	</h1>
	
	<P>  안녕하세요. 제 이름은 ${name } 입니다.</P>
	<h1>데이터 전송 연습(서버로)</h1>
	<form action="<c:url value="/"/>" method="get">
		<input type="text" name="name" placeholder="이름 입력">
		<br>
		<input type="text" name="age" placeholder="나이 입력">
		<br>
		<button type="submit">전송</button>
	</form>
</div>
<div class="jumbotron jumbotron-fluid mb-0">
  <div class="container">
    <h1>푸터</h1>
  </div>
</div>
</body>
</html>
