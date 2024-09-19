
import {useEffect, useState} from 'react';

//state 변수를 이용해서 화면을 렌더링하여 useEffect를 확인하는 예제
function UseEffectEx(){
	let [num, setNum] = useState(1);
	let [maxNum, setMaxNum] = useState(5);
	console.log("init");
	useEffect(()=>{
		console.log("useEffect" + maxNum)
	}, [maxNum]);
	return(
		<div>
			<button onClick={()=>setNum(num-1)}>-</button>
			<span>{num}</span>
			<button onClick={()=>{
				if(num + 1 === maxNum){
					setMaxNum(maxNum + 5);
				}
				setNum(num+1);
			}}>+</button>
		</div>
	)
}

export default UseEffectEx;