
function Button1(props){
	return (
		<button 
			onClick={props.click}
			className={props.classNames}>
			{props.text}
		</button>
	)
}

const Button2 = ({text, styles, click})=>{
	return(
		<button 
			onClick={click}
			style={styles}>
			{text}
		</button>
	)
}

export {Button1, Button2};