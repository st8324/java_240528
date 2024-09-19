
import { Button, Form } from 'react-bootstrap';
import {useState} from 'react';

function Signup(){

	let [data, setData] = useState({
		me_id : '',
		me_pw : '',
		me_pw2: '',
		me_email : ''
	});
	
	const change = e =>{
		setData({
			...data,
			[e.target.name] : e.target.value
		})
	}

	const submit = e =>{
		e.preventDefault();
		if(data.me_id === ''){
			alert('아이디는 필수 항목입니다.');
			return;
		}
		if(data.me_pw === ''){
			alert('비번은 필수 항목입니다.');
			return;
		}
		if(data.me_pw !== data.me_pw2){
			alert('비번과 일치하지 않습니다.');
			return;
		}
		if(data.me_email === ''){
			alert('이메일은 필수 항목입니다.');
			return;
		}

		fetch("/spring/test/signup",{
			method : "post",
			body : JSON.stringify(data),
			headers : {
				"Content-type" : "application/json"
			}
		})
			.then(res=>res.text())
			.then(data=>{
				
				if(data === "true"){
					alert("회원 가입을 완료했습니다.");
				}else{
					alert("회원 가입을 실패했습니다.");
				}
			})
			.catch(e=>console.error(e));
	}

	return(
		<form onSubmit={submit}>
			<Form.Label htmlFor="me_id">아이디</Form.Label>
			<Form.Control
				type="text"
				id="me_id"
				name="me_id"
				aria-describedby="아이디"
				onChange={change}
			/>
			<Form.Label htmlFor="me_pw">비번</Form.Label>
			<Form.Control
				type="password"
				id="me_pw"
				name="me_pw"
				aria-describedby="비번"
				onChange={change}
			/>
			<Form.Label htmlFor="me_pw2">비번 확인</Form.Label>
			<Form.Control
				type="password"
				id="me_pw2"
				name="me_pw2"
				aria-describedby="비번 확인"
				onChange={change}
			/>
			<Form.Label htmlFor="me_email">이메일</Form.Label>
			<Form.Control
				type="email"
				id="me_email"
				name="me_email"
				aria-describedby="이메일"
				onChange={change}
			/>

			<Button type="submit">전송</Button>
		</form>
	)
}

export default Signup;