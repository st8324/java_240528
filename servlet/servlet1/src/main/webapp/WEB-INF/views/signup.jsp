<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<jsp:include page="/WEB-INF/views/common/head.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
<style type="text/css">
	.error{color:red;}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="container">
	<h1 class="mt-3">회원가입</h1>
	<!-- 
	회원 가입을 위한 화면을 구성
	- 아이디, 비번, 비번확인, 이메일
	서버로 아이디, 비번, 이메일을 전송하고
	서버에서는 전송받은 아이디, 비번, 이메일을 콘솔에 출력
	-->
	<form action="<%=request.getContextPath()%>/signup" method="post" id="form">
		<div class="form-group">
			<label for="id">아이디:</label>
			<input type="text" class="form-control" id="id" name="id">
		</div>
		<div class="form-group">
			<label for="pw">비번:</label>
			<input type="password" class="form-control" id="pw" name="pw">
		</div>
		<div class="form-group">
			<label for="pw2">비번확인:</label>
			<input type="password" class="form-control" id="pw2" name="pw2">
		</div>
		<div class="form-group">
			<label for="email">이메일:</label>
			<input type="email" class="form-control" id="email" name="email">
		</div>
		<button type="submit" class="btn btn-outline-success col-12">회원가입</button>
	</form>
</div>
<script type="text/javascript">
$('#form').validate({
	rules : {
		id : {
			required : true,
			regex : /^\w{6,13}$/
		},
		pw : {
			required : true,
			regex : /^[a-zA-Z0-9!@#$]{6,15}$/
		},
		pw2 : {
			equalTo : pw
		},
		email : {
			required : true,
			email : true
		}
	},
	messages : {
		id : {
			required : '필수 항목입니다.',
			regex : '아이디는 영어, 숫자만 가능하며, 6~13자이어야 합니다.'
		},
		pw : {
			required : '필수 항목입니다.',
			regex : '아이디는 영어, 숫자, 특수문자(!@#$)만 가능하며, 6~15자이어야 합니다.'
		},
		pw2 : {
			equalTo : '비번과 일치하지 않습니다.'
		},
		email : {
			required : '필수 항목입니다.',
			email : '이메일 형식이 아닙니다'
		}
	},
	submitHandler : function(){
		return true;
	}
});
$.validator.addMethod('regex', function(value, element, regex){
	var re = new RegExp(regex);
	return this.optional(element) || re.test(value);
}, "정규표현식을 확인하세요.");
</script>
</body>
</html>