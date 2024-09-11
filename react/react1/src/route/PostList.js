
function PostList({list}){
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
					</tr>
				</thead>
				<tbody>
					{
						list.map((item, index)=>{
							return(
								<tr key={index}>
									<td>{item.no}</td>
									<td>{item.title}</td>
									<td>{item.writer}</td>
									<td>{item.view}</td>
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