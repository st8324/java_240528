import Nav from "./Nav";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Main from "./Main";
import PostList from "./PostList";

function App() {

  return (
    <BrowserRouter>
      <Nav/>
      <Routes>
				<Route path={"/"} exact element={<Main/>}/>
				<Route path={"/post/list/:co_num"} element={<PostList/>}/>
			</Routes>
    </BrowserRouter>
  );
}

export default App;