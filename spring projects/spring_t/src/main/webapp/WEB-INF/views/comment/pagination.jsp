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
						<button class="btn btn-outline-info">수정</button>
						<button class="btn-comment-del btn btn-outline-dark" 
							data-num="${comment.cm_num}">삭제</button>
					</div>
				</c:if>
			</div>
			<div style="padding-left:20px; line-height: 38px;">${comment.cm_content}</div>
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
</script>