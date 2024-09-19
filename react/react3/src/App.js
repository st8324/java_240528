
import { Container, Button, Form } from 'react-bootstrap';

import 'bootstrap/dist/css/bootstrap.min.css';
import Signup from './Signup';

function App() {

  return (
    <Container>
      <h1>테스트</h1>
      {/* 
      회원가입화면을 구성 후 회원가입 버튼을 클릭하면 스프링으로 회원 정보를 전송하고,
      전송되 회원 정보를 이용해서 회원 가입하는 기능을 구현
      spring3 프로젝트에 작업
      TestController를 추가해서 작업
       */}
      <Signup/>
      
    </Container>
  );
}

export default App;
