<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script type="text/javascript">
		var msg = '${msg}';
		var url = '${url}';
		if(msg != ''){
			alert(msg);
			location.href = '<%=request.getContextPath()%>' + url;
		}
	</script>
</body>
</html>