<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
	<style type="text/css">
	.error{
		color : red;
	}
	.error.id-ok{
		color : green;
	}
	</style>
</head>
<body>
	
	<h1>회원가입</h1>
	<form action="<c:url value="/signup"/>" method="post" id="form">
		<div class="form-group">
			<label for="id">아이디:</label>
			<input type="text" class="form-control" id="id" name="me_id">
		</div>
		<div class="form-group">
			<label for="pw">비번:</label>
			<input type="password" class="form-control" id="pw" name="me_pw">
		</div>
		<div class="form-group">
			<label for="pw2">비번 확인:</label>
			<input type="password" class="form-control" id="pw2" name="me_pw2">
		</div>
		<div class="form-group">
			<label for="email">이메일:</label>
			<input type="text" class="form-control" id="email" name="me_email">
		</div>
		<button type="submit" class="btn btn-outline-success col-12">회원가입</button>
	</form>
	<script type="text/javascript">
	var flag = false;
	
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
				equalTo : pw
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
		},
		submitHandler : function(){
			var id = $("#id").val();
			var res = checkId(id);
			if(res == 0){
				displayCheckId(res);
				alert('이미 사용 중인 아이디입니다.');
				return false;
			}
			return true;
		}
	});
	$.validator.addMethod('regex', function(value, element, regex){
		var re = new RegExp(regex);
		return this.optional(element) || re.test(value);
	}, "정규표현식을 확인하세요.");
	
	</script>
	<script type="text/javascript">
		//아이디 중복 확인
		$("#id").keyup(function(){
			//입력된 아이디 값을 가져옴
			var id = $(this).val();
			//아이디를 서버에 전달해서 사용 가능한지 확인
			var result = checkId(id);
			displayCheckId(result);
		});
		/**
		@return 1이면 사용 가능, 0이면 사용 불가능, -1이면 전송하지 않음
		*/
		function checkId(id){
			//정규표현식 확인
			var regex = /^\w{6,13}$/;
			if(!regex.test(id)){
				return -1;
			}
			var res = 0;
			//맞으면 서버에 확인 요청
			$.ajax({
				async : false,
				url : '<c:url value="/check/id"/>', 
				type : 'get', 
				data : {
					id : id
				}, 
				success : function (data){
					res = data? 1 : 0;
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
			return res;
		}
		function displayCheckId(result){
			$('#check-id').remove();
			
			if(result == 1){
				var str = `<label id="check-id" class="id-ok error">사용 가능한 아이디입니다.</label>`;
				$('#id').after(str);
			}else if(result == 0){
				var str = `<label id="check-id" class="error">이미 사용중인 아이디입니다.</label>`;
				$('#id').after(str);
			}
		}
	</script>
</body>
</html>