import PropTypes from 'prop-types'; //props의 타입을 설정하기 위해 사용

/*
function Button(props){
	//요소의 class를 지정하려면 class 키워드 대신 className을 이용
	return (
		<button type={props.type} className={props.className}>{props.text}</button>
	);
}
*/

function Button({type, className, text, click}){

	//요소의 class를 지정하려면 class 키워드 대신 className을 이용
	return (
		<button type={type} className={className} onClick={click}>{text}</button>
	);
}

Button.propTypes = {
	type : PropTypes.string,
	className : PropTypes.string,
	text : PropTypes.string.isRequired,
	click : PropTypes.func
}
Button.defaultProps = {
	type : 'button',
	className : '',
	text : '버튼'
}
export default Button;
