import { useState } from "react";
import { useNavigate } from "react-router-dom";

function PostInsert(){
	
	let [title, setTitle] = useState("");
	let [writer, setWriter] = useState("");
	let [content, sestContent] = useState("");

	//다른 페이지에 정보를 전송하기 위해서 navigate를 사용
	const navigate = useNavigate();

	function postSubmit(){
		let view = 0;
		//to : 전송할 url
		//state : 상태 정보
		navigate("/post/list", {
			state : {
				title,
				writer,
				content,
				view
			}
		})
	}

	return(
		<div>
			<h1>게시글 등록</h1>
			<input 
				type="text"
				onChange={(e)=>setTitle(e.target.value)}
				value={title}
				placeholder="제목을 입력하세요."
			/>
			<br/>
			<input 
				type="text"
				onChange={(e)=>setWriter(e.target.value)}
				value={writer}
				placeholder="작성자를 입력하세요."
			/>
			<br/>
			<textarea
				onChange={(e)=>sestContent(e.target.value)}
				value={content}
				placeholder="내용을 입력하세요."
			></textarea>
			<br/>
			<button onClick={postSubmit}>게시글 등록</button>
		</div>
	)
}

export default PostInsert;