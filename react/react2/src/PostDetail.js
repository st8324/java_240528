import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

function PostDetail(){
	let [post, setPost] = useState({});
	let {po_num} = useParams();
	useEffect(()=>{
		fetch("/spring/react/post/detail/"+po_num)
			.then(res=>res.json())
			.then(data=>{
				//정수로 된 날짜 정보를 Date 객체로 변환하기 위해서
				var date = (new Date(data.po_date )).toLocaleDateString();
				data = {...data, date};
				setPost(data)
			})
			.catch(e=>console.error(e));
	},[]);
	return (
		<div>
			{
				<div>
					<div>제목  : {post.po_title}</div>
					<div>작성자 : {post.po_me_id}</div>
					<div>작성일 : {post.date}</div>
					<div>조회수 : {post.po_view}</div>
					<div>내용 : </div>
					<div>{post.po_content}</div>
				</div>
			}
		</div>
	)
}

export default PostDetail;