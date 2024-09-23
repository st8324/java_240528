import { useState } from 'react';
import './App.css';
import { Button1, Button2 } from './Button';

function App() {
  const text1 = "버튼1";
  const text2 = "버튼2";
  let [text, setText] = useState('');
  const click = (text)=>{alert(text)};
  return (
    <div>
      {/* 
        버튼을 추가
        - 버튼 컴포넌트를 생성해서 추가 
        - 버튼의 문자열을 App컴포넌트가 전달해서 버튼이 생성되도록 수정
        - 버튼을 클릭하면 클릭한 버튼의 문자열을 알림창으로
          출력하도록 작성
        - 버튼에 배경색을 노란색, 테두리를 둥근 테두리,
          크기를 30px로 적용하도록 작성
        - 각 버튼의 클릭 이벤트를 App컴포넌트가 정하도록
          코드를 수정
      */}
      <Button1 
        text={text1} 
        classNames={"btn"}
        click={()=>click(text1)}/>
      <Button2 
        text={text2} 
        styles={{
          backgroundColor : 'yellow',
          height : '30px',
          borderRadius : '5px'
        }}
        click={()=>click(text2)}/>
      {/* 
      버튼 컴포넌트와 input창을 추가
      - input창에 입력된 내용을 버튼을 클릭하면
        알림창으로 출력되도록 작성
      */}
      <input type='text' onChange={(e)=>setText(e.target.value)}/>
      <Button2 text={"클릭"} click={()=>click(text)}/>
    </div>
  );
}

export default App;
