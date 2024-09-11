import { useParams } from "react-router-dom";

function PostDetail({list}){
	const {id} = useParams();
	const post = list[parseInt(id)];
	return(
		<div>
			<h1>게시글 상세</h1>
			<div>{post.title}</div>
			<div>{post.writer}</div>
			<div>{post.content}</div>
		</div>
	)
}

export default PostDetail;