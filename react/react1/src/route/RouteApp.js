import {BrowserRouter, Link, Routes, Route} from 'react-router-dom';
import Home from './Home';
import Nav from './Nav';
import PostInsert from './PostInsert';
import PostList from './PostList';
import { useState } from 'react';

function RouteApp(){
	let links = ['/', '/post/insert', '/post/list'];
	let titles = ['홈', '게시글 등록', '게시글 목록']
	let [list, setList] = useState([
		{
			no : 2,
			title : '새 공지',
			content : '새 공지사항',
			writer : 'admin',
			view : 0
		},{
			no : 1,
			title : '공지',
			content : '공지사항',
			writer : 'admin',
			view : 0
		}
	]);
	return (
		<BrowserRouter>
			{/* 메뉴 */}
			<Nav links={links} titles={titles} />
			{/* 메뉴에 맞는 컴포넌트를 연결 */}
			<Body list={list} />
		</BrowserRouter>
	)
}
function Body({list}){
	return (
		<Routes>
			<Route path={"/"} exact element={<Home/>}/>
			<Route 
				path={"/post/list"} 
				element={
					<PostList list={list}/>
				}
			/>
			<Route path={"/post/insert"} element={<PostInsert/>}/>
		</Routes>
	)
}

export default RouteApp;