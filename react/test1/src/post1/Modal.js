
function Modal({funcClose, post, num}){
	return(
		<div id="modal">
			<div id="modal-content">
				<div>
					<div>번호</div>
					<div>{num}</div>
				</div>
				<div>
					<div>제목</div>
					<div>{post.title}</div>
				</div>
				<div>
					<div>작성자</div>
					<div>{post.writer}</div>
				</div>
				<div>
					<div>조회수</div>
					<div>{post.view}</div>
				</div>
				<div>
					<div>내용</div>
					<div>{post.content}</div>
				</div>
				<button className={"btn"} onClick={funcClose}>닫기</button>
			</div>
		</div>
	)
}

export default Modal;