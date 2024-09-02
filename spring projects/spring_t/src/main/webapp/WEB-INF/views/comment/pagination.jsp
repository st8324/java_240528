<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<ul class="comment-list" style="list-style: none; padding: 0" >
	<c:forEach items="${list}" var="comment">
		<li class="comment-item">
			<div class="clearfix">
				<span class="float-left" style="line-height: 38px">${comment.cm_me_id}</span>
				<c:if test="${comment.cm_me_id eq user.me_id }">
					<div class="float-right">
						<button class="btn-comment-update btn btn-outline-info"
							data-num="${comment.cm_num}">수정</button>
						<button class="btn-comment-del btn btn-outline-dark" 
							data-num="${comment.cm_num}">삭제</button>
					</div>
				</c:if>
			</div>
			<div style="padding-left:20px; line-height: 38px;" class="comment-content">${comment.cm_content}</div>
		</li>
	</c:forEach>
</ul>
<div class="comment-pagination">
	<ul class="pagination justify-content-center">
		<c:if test="${pm.prev}">
			<li class="page-item" data-page="${pm.startPage - 1 }"><a class="page-link" href="javascript:void(0);">이전</a></li>
		</c:if>
		<c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="i">
			<c:set var="active" value=""/>
			<c:if test="${pm.cri.page == i }">
				<c:set var="active" value="active"/>
			</c:if>
			<li class="page-item ${active}" data-page="${i}">
				<a class="page-link" href="javascript:void(0);">${i }</a>
			</li>
		</c:forEach>
		<c:if test="${pm.next }">
			<li class="page-item" data-page="${pm.endPage + 1}"><a class="page-link" href="javascript:void(0);">다음</a></li>
		</c:if>
	</ul>
</div>
<div class="comment-input-box">
	<div class="input-group mb-3">
	    <textarea class="form-control" placeholder="댓글 입력" id="input-comment"></textarea>
	    <div class="input-group-append">
			<span class="input-group-text btn-insert">등록</span>
	    </div>
	</div>
</div>

<script type="text/javascript">
$('.btn-comment-del').click(function(){
	var cm_num = $(this).data('num');
	commentDel3(cm_num);
});
function commentDel1(cm_num){
	//json으로 화면에서 서버로 전송 => 서버에서 화면으로 json으로 전송
	let comment = {
		cm_num : cm_num
	}
	$.ajax({
		async : true, //비동기 : true(비동기), false(동기)
		url : '<c:url value="/comment/delete1"/>', 
		type : 'post', 
		data : JSON.stringify(comment), 
		contentType : "application/json; charset=utf-8",
		dataType : "json", 
		success : function (data){
			if(data.res){
				alert('댓글을 삭제했습니다.');	
			}else{
				alert('댓글을 삭제하지 못했습니다.');
			}
			getCommentList2(cri);
		}, 
		error : function(jqXHR, textStatus, errorThrown){

		}
	});
}
function commentDel2(cm_num){
	let comment = {
		cm_num : cm_num
	}
	$.ajax({
		async : true, //비동기 : true(비동기), false(동기)
		url : '<c:url value="/comment/delete2"/>', 
		type : 'post', 
		data : comment, 
		dataType : "json", 
		success : function (data){
			if(data.res){
				alert('댓글을 삭제했습니다.');	
			}else{
				alert('댓글을 삭제하지 못했습니다.');
			}
			getCommentList2(cri);
		}, 
		error : function(jqXHR, textStatus, errorThrown){

		}
	});
}
function commentDel3(cm_num){
	let comment = {
		cm_num : cm_num
	}
	$.ajax({
		async : true, //비동기 : true(비동기), false(동기)
		url : '<c:url value="/comment/delete3"/>', 
		type : 'post', 
		data : comment, 
		success : function (data){
			if(data){
				alert('댓글을 삭제했습니다.');	
			}else{
				alert('댓글을 삭제하지 못했습니다.');
			}
			getCommentList2(cri);
		}, 
		error : function(jqXHR, textStatus, errorThrown){

		}
	});
}
</script><script type="text/javascript">
$('.btn-comment-update').click(function(){
	var cm_num = $(this).data('num');
	var cm_content = $(this).parents('.comment-item').find('.comment-content').text();
	var str = `
		<div class="comment-input-box comment-update-box">
			<div class="input-group mb-3">
			    <textarea class="form-control" placeholder="댓글 입력" id="input-update-comment">\${cm_content}</textarea>
			    <input type="hidden" name="cm_num" value="\${cm_num}">
			    <div class="input-group-append">
					<span class="input-group-text btn-update" style="cursor:pointer;">수정</span>
			    </div>
			</div>
		</div>
	`;
	$('.comment-update-box').remove();
	$('.comment-input-box').hide();
	$('.comment-input-box').after(str);
});
//
$(document).off('click','.btn-update');
$(document).on('click','.btn-update', function(){
	//댓글 번호와 내용을 가져옴
	var cm_num = $('.comment-update-box').find('[name=cm_num]').val();
	var cm_content = $('#input-update-comment').val();
	var comment = {
		cm_num : cm_num,
		cm_content : cm_content
	}
	if(cm_content.length == 0){
		alert('댓글을 입력하세요');
		$('#input-update-comment').focus();	
		return;
	}
	
	//ajax로 통신 : json => object
	$.ajax({
		async : true,
		url : '<c:url value="/comment/update"/>', 
		type : 'post', 
		data : JSON.stringify(comment), 
		contentType : "application/json; charset=utf-8",
		success : function (data){
			if(data){
				alert('댓글을 수정했습니다.');
			}else{
				alert('댓글을 수정하지 못했습니다.');
			}
			getCommentList2(cri);
		}, 
		error : function(jqXHR, textStatus, errorThrown){

		}
	});
});
</script>