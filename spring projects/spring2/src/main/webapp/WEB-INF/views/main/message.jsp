<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<script type="text/javascript">
	var url = '<c:url value="${url}"/>';
	var msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}
	location.href = url;
</script>
</body>
</html>
