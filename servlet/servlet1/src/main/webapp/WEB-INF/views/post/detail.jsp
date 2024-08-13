<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="container">
	<h1>게시글 상세</h1>
	<div class="form-group">
		<label for="title">제목:</label>
		<input type="text" class="form-control" value="${post.po_title}">
	</div>
	<div class="form-group">
		<label for="title">작성자:</label>
		<input type="text" class="form-control" value="${post.po_me_id}">
	</div>
	<div class="form-group">
		<label for="title">작성일:</label>
		<input type="text" class="form-control" value="<fmt:formatDate value="${post.po_date}" pattern="yyyy-MM-dd HH:mm:ss" />">
	</div>
	<div class="form-group">
		<label for="title">조회수:</label>
		<input type="text" class="form-control" value="${post.po_view}">
	</div>
	<div class="text-center">
		
		<a  href="#" data-state="1"
			class="btn-up btn btn<c:if test="${re.re_state ne 1}">-outline</c:if>-danger">추천(<span>${post.po_up }</span>)</a>
		<a  href="#" data-state="-1"
			class="btn-down btn btn<c:if test="${re.re_state ne -1}">-outline</c:if>-danger">비추천(<span>${post.po_down }</span>)</a>
	</div>
	<div class="form-group">
		<label for="content">내용:</label>
		<div class="form-control" style="min-height: 400px">${post.po_content }</div>
	</div>
	<div>
		<ul class="comment-list"></ul>
	</div>
	<a href="<c:url value="/post/list?co_num=${post.po_co_num }"/>" class="btn btn-outline-primary">목록</a>
	<c:if test="${user ne null && post.po_me_id eq user.me_id}">
		<a href="<c:url value="/post/update?po_num=${post.po_num }"/>" class="btn btn-outline-warning">수정</a>
		<a href="<c:url value="/post/delete?po_num=${post.po_num }"/>" class="btn btn-outline-danger">삭제</a>
	</c:if>
</div>
<script type="text/javascript">
var cri = {
	num : '${post.po_num}',
	page : 1
}

$('.btn-up, .btn-down').click(function(e){
	e.preventDefault();
	
	if('${user.me_id}' == ''){
		if(confirm('로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하시겠습니까?')){
			location.href = '<c:url value="/login"/>';
			return;
		}else{
			return;
		}
	}
	
	let state = $(this).data('state');
	let num = '${post.po_num}';
	$.ajax({
		url : '<c:url value="/post/recommend"/>',
		method : "get", //원하는 방식 선택
		data : { //보낸 데이터를 객체로
			state : state,
			num : num
		},
		success : function(data){
			let res = data.result;
			if(res == 1){
				alert('추천 했습니다.');
			}else if(res == -1){
				alert('비추천 했습니다.');
			}else{
				alert(`\${state == 1?'추천':'비추천'}을 취소했습니다.`);
			}
			checkRecommendBtns(res);
			let post = JSON.parse(data.post);
			$('.btn-up span').text(post.po_up);
			$('.btn-down span').text(post.po_down);
		}, 
		error : function(xhr, status, error){
			//xhr : XHLHttpRequest 객체, 요청과 관련된 정보를 제공
			//status :HTTP 상태 코드, 요청이 실패한 원인
			//error : 에러에 대한 추가 정보
			console.log("error");
		}
	});
});
//해당 게시글의 추천/비추천에 따라 각 버튼의 색상을 채워주는 함수
function checkRecommendBtns(state){
	$('.btn-up, .btn-down').removeClass('btn-danger');
	$('.btn-up, .btn-down').addClass('btn-outline-danger');
	if(state != 0){
		$(state==1?'.btn-up':'.btn-down').removeClass('btn-outline-danger');
		$(state==1?'.btn-up':'.btn-down').addClass('btn-danger');
	}

}
getCommentList(cri);
function getCommentList(cri){
	console.log(cri)
	$.ajax({
		url : '<c:url value="/comment/list"/>',
		method : "post", 
		data : cri,
		success : function(data){
			let list = data.list;
			displayCommentList(list);
			let pm = JSON.parse(data.pm);
			displayPagination(pm);
		}, 
		error : function(xhr, status, error){
			console.log("에러 발생");
			console.log(xhr.responseText);
		}
	});
	
}
function displayPagination(pm){
	console.log(pm);
}
function displayCommentList(list){
	var str = '';
	if(list.length == 0){
		str = `<li>등록된 댓글이 없습니다.</li>`;
		$('.comment-list').html(str);
		return;
	}
	
	for(co of list){
		str += `
		<li>\${co.cm_content}</li>
		`;
	}
	$('.comment-list').html(str);
}
</script>
</body>
</html>