import { useState } from "react";

/*
다음과 같은 배열이 있을 때 배열을 이용해서 checkbox와 label태그로 된 화면을 구성하세요.
*/
function List1(){
	const list = ['축구', '야구', '농구', '배구', '음악감상'];
	let [hobby, setHobby] = useState([]);
	let click = (e)=>{
		let {value, checked} = e.target;
		//value = e.target.value;
		//checked = e.target.checked;
		let tmp = [...hobby];
		//checkbox가 체크된 상태이면 배열에 추가하고
		if(checked && hobby.length < 3){
			tmp.push(value);
		}
		//checkbox가 체크가 해제된 상태이면 배열에서 제거
		else if(!checked){
			//let index = tmp.indexOf(value);
			//tmp.splice(index, 1);
			//value와 같지 않은 요소들만 이용해서 배열을 새로 만둠
			tmp = tmp.filter(item=> item != value);
		}else{
			alert('최대 3개까지 선택할 수 있습니다.');
		}

		setHobby(tmp);
	}
	let isDisabled = (value)=>{
		return hobby.length == 3 && !hobby.includes(value);
	}
	return(
		<div>
			<h1>당신의 취미는?</h1>
			{
				list.map((v,index)=>{
					return (
						<label key={index}>
							<input type="checkbox" value={v} onClick={click} disabled={isDisabled(v)}/> {v}
						</label>
					)
				})
			}
			<ul>
				{
					hobby.map((v,index)=>{
						return (
							<li key={index}>{v}</li>
						)
					})
				}
			</ul>
		</div>
	)
}

export default List1;