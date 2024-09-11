import {useState} from 'react';

function PostInsert({list, setList}){
	let [title, setTitle] = useState("");
	let [writer, setWriter] = useState("");
	let [content, setContent] = useState("");
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
	return (
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
	)
}

export default PostInsert;