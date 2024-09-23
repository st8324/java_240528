import './App.css';
import { Button1, Button2 } from './Button';

function App() {
  return (
    <div>
      {/* 
        버튼을 추가
        - 버튼 컴포넌트를 생성해서 추가 
        - 버튼의 문자열을 App컴포넌트가 전달해서 버튼이 생성되도록 수정
      */}
      <Button1/>
      <Button2/>
    </div>
  );
}

export default App;
