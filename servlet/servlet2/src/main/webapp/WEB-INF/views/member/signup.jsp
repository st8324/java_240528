<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
<title>회원가입</title>
<style type="text/css">
.error{
	color:red;
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<div class="container" style="min-height: calc(100vh - 240px)">
	<h1>회원가입</h1>
	<form action="<c:url value="/signup"/>" method="post" id="form">
		<div class="form-group">
			<label for="id">아이디:</label>
			<input type="text" class="form-control" id="id" name="me_id">
		</div>
		<button type="button" class="btn btn-outline-success btn-dup col-12 mb-3">아이디 중복 검사</button>
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
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
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
		if(!flag){
			alert('아이디 중복 검사를 하세요.');
			return false;
		}
		return checkId();
	}
});
$.validator.addMethod('regex', function(value, element, regex){
	var re = new RegExp(regex);
	return this.optional(element) || re.test(value);
}, "정규표현식을 확인하세요.");

$('.btn-dup').click(function(){
	//아이디를 가져옴.
	var id = $('[name=me_id]').val();
	//아이디 유효성 검사 확인
	var regex = /^\w{6,13}$/;
	if(!regex.test(id)){
		alert('아이디는 영어, 숫자만 가능하며, 6~13자이어야 합니다.');
		return;
	}
	if(checkId()){
		alert('사용 가능한 아이디입니다.');
		flag = true;
	}else{
		alert('이미 사용 중인 아이디입니다.');
	}
});

$('[name=me_id]').change(function(){
	flag = false;
});

function checkId() {
	var res = false;
	//아이디를 가져옴.
	var id = $('[name=me_id]').val();
	
	//아이디를 서버에 보내서 사용가능한지 확인
	$.ajax({
		async : false, //동기화를 시킴 => 확인이 끝날때까지 다음 작업이 진행되지 않음
		url : '<c:url value="/check/id"/>',
		data : {
			me_id : id
		},
		success : function(data){
			res = data.result;
		},
		error : function(xhr){
			console.log(xhr);
		}
	});
	return res;
}
</script>
</body>
</html>