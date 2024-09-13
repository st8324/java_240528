import {BrowserRouter, Link, Route, Routes} from 'react-router-dom';

function Nav(){
	return (
		<nav>
			<ul>
				<li>
					<Link to={"/"}>홈으로</Link>
				</li>
				<li>
					<Link to={"/post/list/0"}>커뮤니티</Link>
				</li>
			</ul>
			
		</nav>
	);
}

export default Nav;