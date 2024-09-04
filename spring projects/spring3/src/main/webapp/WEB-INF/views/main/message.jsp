<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<script type="text/javascript">
		if('${message}' != ''){
			alert('${message.msg}');
			location.href = '<c:url value="${message.url}"/>'
		}
	</script>
</body>
</html>
