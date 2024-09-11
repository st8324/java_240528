import { Link } from "react-router-dom";

function Nav({links, titles}){
	return(
		<nav>
			<ul>
				{
					links.map((link, index)=>{
						return (
							<li key={"link" + index}>
								<Link to={link} >{titles[index]}</Link>
							</li>
						)
					})
				}
			</ul>
		</nav>
	)
}
export default Nav;