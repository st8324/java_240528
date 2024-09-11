import {useState} from 'react';
import './PostEx.css';
/* 
- 게시글 제목, 내용, 작성자를 입력해서 버튼을 클릭하면
  입력한 게시글 정보가 콘솔창에 출력되도록 작성
	1. state 변수 3개 추가(title, writer, content)
	2. 내용이 바뀔때마다 변경된 내용을 각 항목에 업데이트
	3. 버튼을 클릭하면 title, writer, content를 콘솔에 출력
*/
function PostEx(){
	let [title, setTitle] = useState("");
	let [writer, setWriter] = useState("");
	let [content, setContent] = useState("");
	let [list, setList] = useState([{
		title : '공지',
		writer : 'admin',
		content : '공지사항',
		view : 0
	}]);
	let [modal, setModal] = useState(false);
	function btnClick(){
		//입력한 제목, 작성자, 내용을 이용해서 객체로 만들고 만들어진 객체를 콘솔에 출력
		/*
		let post = {
			title : title,
			content : content,
			writer : writer
		}
			*/
		var view = 0;
		let post = {
			title,	content, writer, view
		}
		setList([post, ...list]);
		
		//제목, 작성자, 내용 입력창에 입력된 값들을 지움
		setTitle('');
		setWriter('');
		setContent('');
	}
	return(
		<div>
			<div>
				<input type="text" id="title" name="title" placeholder="제목을 입력하세요." 
					onChange={(e)=>setTitle(e.target.value)}
					value={title}/>
				<input type="text" id="writer" name="writer" placeholder="작성자 입력하세요." 
					onChange={(e)=>setWriter(e.target.value)}
					value={writer}/>
				<textarea id="content" name="content" placeholder="내용을 입력하세요."
					onChange={(e)=>setContent(e.target.value)} value={content}></textarea>
				<button className="btn" onClick={btnClick}>게시글 등록</button>
			</div>
			<hr/>
			<div id="table-box">
				<h1>게시글 목록</h1>
				<table border="1">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						{
							list.map((item, index)=>{
								return (
									<tr>
										<td>{list.length - index}</td>
										<td onClick={()=>setModal(true)}>
											{item.title}
											{
												modal ? <Modal funcClose={()=>setModal(false)} /> : ''
											}
										</td>
										<td>{item.writer}</td>
										<td>{item.view}</td>
									</tr>
								)
							})
						}
					</tbody>
				</table>
			</div>
			
		</div>
	)
}

function Modal({funcClose}){
	return(
		<div id="modal">
			<div id="modal-content">
				<div>
					<div>번호</div>
					<div>1</div>
				</div>
				<div>
					<div>제목</div>
					<div>공지</div>
				</div>
				<div>
					<div>작성자</div>
					<div>admin</div>
				</div>
				<div>
					<div>조회수</div>
					<div>1</div>
				</div>
				<div>
					<div>내용</div>
					<div>공지</div>
				</div>
				<button className={"btn"} onClick={funcClose}>닫기</button>
			</div>
		</div>
	)
}
export default PostEx;