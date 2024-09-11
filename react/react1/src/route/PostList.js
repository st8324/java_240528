import { Link, useLocation } from "react-router-dom";

function PostList({list, addPost, delPost}){
	//다른 페이지에서 보낸 정보를 받기 위해 사용
	const location = useLocation();

	let post = location.state;
	if(post != null){
		//기존 게시글 리스트에 추가
		addPost(post);
		//state를 null로 수정
		location.state = null;
	}
	return(
		<div>
			<h1>게시글 목록</h1>
			<table border={1}>
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
							return(
								<tr key={index}>
									<td>{list.length - index}</td>
									<td>{item.title}</td>
									<td>{item.writer}</td>
									<td>{item.view}</td>
									<td>
										<button onClick={()=>delPost(index)}>삭제</button>
										<button>
											<Link to={"/post/detail/"+index}>조회</Link>
										</button>
									</td>
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