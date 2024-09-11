import { useState } from "react";

/* 
	select 태그를 이용해서 과일은 선택할 수있는 창을 만들고, 
	과일을 선택하면 h1태그에 선택한 과일이 출력되도록 작성
	- 선택안함, 사과, 바나나, 오렌지
*/
function Select(){
	let [fruit, setFruit] = useState("");
	
	function display(){
		return fruit == '' ? '' : fruit;
	}

	return (
		<div>
			<select onChange={(e)=>setFruit(e.target.value)}>
				<option value={""}>선택안함</option>
				<option>사과</option>
				<option>바나나</option>
				<option>오렌지</option>
			</select>
			<h1>{fruit == '' ? '' : fruit}</h1>
			<h1>{display()}</h1>
		</div>
	)
}

export default Select;