import Nav from "./Nav";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Main from "./Main";
import PostList from "./PostList";
import PostDetail from "./PostDetail";

function App() {

  return (
    <BrowserRouter>
      <Nav/>
      <Routes>
				<Route path={"/"} exact element={<Main/>}/>
				<Route path={"/post/list/:co_num"} element={<PostList/>}/>
        <Route path={"/post/detail/:po_num"} element={<PostDetail/>}/>
			</Routes>
    </BrowserRouter>
  );
}

export default App;