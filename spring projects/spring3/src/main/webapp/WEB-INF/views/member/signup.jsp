<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<script src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
	<script src="<c:url value="/resources/js/additional-methods.min.js"/>"></script>
	<style type="text/css">
	.error{
		color : red;
	}
	</style>
</head>
<body>
	<h1>회원가입</h1>
	<form action="<c:url value="/guest/signup"/>" method="post" id="form">
		<div class="form-group">
			<label for="me_id">아이디:</label>
			<input type="text" class="form-control" id="me_id" name="me_id">
		</div>
		<div class="form-group">
			<label for="me_pw">비번:</label>
			<input type="password" class="form-control" id="me_pw" name="me_pw">
		</div>
		<div class="form-group">
			<label for="me_pw2">비번 확인:</label>
			<input type="password" class="form-control" id="me_pw2" name="me_pw2">
		</div>
		<div class="form-group">
			<label for="me_pw">이메일:</label>
			<input type="text" class="form-control" id="me_email" name="me_email">
		</div>
		<button class="btn btn-outline-info col-12">회원 가입</button>
	</form>
	<script type="text/javascript">
		$('#form').validate({
			rules : {
				me_id : {
					required : true,
					regex : /^\w{6,13}$/
				},
				me_pw : {
					required : true,
					regex : /^[a-zA-Z0-9!@#$]{6,15}$/
				},
				me_pw2 : {
					equalTo : me_pw
				},
				me_email : {
					required : true,
					email : true
				}
			},
			messages : {
				me_id : {
					required : '필수 항목입니다.',
					regex : '아이디는 영어, 숫자만 가능하며, 6~13자이어야 합니다.'
				},
				me_pw : {
					required : '필수 항목입니다.',
					regex : '아이디는 영어, 숫자, 특수문자(!@#$)만 가능하며, 6~15자이어야 합니다.'
				},
				me_pw2 : {
					equalTo : '비번과 일치하지 않습니다.'
				},
				me_email : {
					required : '필수 항목입니다.',
					email : '이메일 형식이 아닙니다'
				}
			}
		});
		$.validator.addMethod('regex', function(value, element, regex){
			var re = new RegExp(regex);
			return this.optional(element) || re.test(value);
		}, "정규표현식을 확인하세요.");
	</script>
</body>
</html>
