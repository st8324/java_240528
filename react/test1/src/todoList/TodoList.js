import {useState} from 'react';
/* 
input창과 버튼, 리스트를 구성해서 버튼을 클릭하면 input창에 들어간 값이 오늘의 할일에 추가되도록고 작성
1. state 변수를 추가
	- todo, setTodo => 문자열
	- todoList, setTodoList => 배열
2. input창에 값을 입력하면 state변수 todo에 입력한 값으로 업데이트
3. 버튼을 클릭하면 todo의 값을 todoList에 추가
4. todoList를 이용해서 ul 태그 안에 li태그들로 구성
  - 배열의 map을 이용해서 구성(첫번째 예제 참고)
*/
function TodoList(){

	let [todo, setTodo] = useState("");
	let [todoList, setTodoList] = useState([]);
	
	function change(e){
		setTodo(e.target.value);
	}
	function add(){
		setTodoList([...todoList, todo]);
	}
	return (
		<div>
			<input onChange={change}/>
			<button onClick={add}>추가</button>
			<h1>오늘의 할일</h1>
			<ul>
				{
					todoList.map((value)=>{
						return <li>{value}</li>;
					})
				}
			</ul>
		</div>
	)
}

export default TodoList;