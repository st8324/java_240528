<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>My Website</title>
</head>
<body>
    <header>
        <tiles:insertAttribute name="header" />
    </header>

    <main>
        <tiles:insertAttribute name="content" />
    </main>

    <footer>
        <tiles:insertAttribute name="footer" />
    </footer>
</body>
</html>
