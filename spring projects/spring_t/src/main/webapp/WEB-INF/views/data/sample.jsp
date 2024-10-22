<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>공공데이터</h1>
<table>
	<thead>
		<tr>
			<th>이미지</th>
			<th>정보</th>
		</tr>
	</thead>
	<tbody id="tbody">
		
	</tbody>
</table>
<script type="text/javascript">
	fetch("<c:url value="/data/sample"/>", {
		method : 'post'
	})
		.then(res=>res.json())
		.then(res=>{
			let list = res.response.body.items;
			let str = '';
			for(item of list){
				str += `
				<tr>
					<td><img alt="이미지 없음" src="\${item.imageUrl1}" height="200"></td>
					<td>\${item.informCause}</td>
				</tr>
				`
			}
			tbody.innerHTML = str;
		});
</script>
</body>
</html>
