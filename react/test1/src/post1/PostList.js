import Modal from "./Modal";
import { useState } from "react";

function PostList({list, setList}){
	let [modal, setModal] = useState(false);
	
	function close(){
		setModal(false);
	}
	function titleClick(index){
		let tmp = [...list];
		tmp[index].view++;
		setList(tmp);
		setModal(true);
	}
	function delPost(index){
		setList(list.filter((item, i)=>index != i));
	}
	return (
		<div id="table-box">
			<h1>게시글 목록</h1>
			<table border="1">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>기능</th>
					</tr>
				</thead>
				<tbody>
					{
						list.map((item, index)=>{
							return (
								<tr>
									<td>{list.length - index}</td>
									<td onClick={()=>titleClick(index)}>
										{item.title}
									</td>
									<td>{item.writer}</td>
									<td>{item.view}</td>
									<td>
										<button onClick={()=>delPost(index)}>삭제</button>
									</td>
									{
										modal ? <Modal funcClose={close} post={item} num={index+1} /> : ''
									}
								</tr>
								
							)
						})
					}
				</tbody>
			</table>
		</div>
	)
}

export default PostList;