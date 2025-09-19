import { useState } from "react";
import Movie from "./components/Movie";
import "./index.css";
import MovieForm from "./components/MovieForm";
import Navbar from "./components/Navbar";

import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Users from "./pages/Users";
import Home from "./pages/Home";
import Movies from "./pages/Movies";
import routes from "./routes";

// 컴포넌트 분리
function App() {
  return (
    <Router>
      <div className="App">
        <Navbar />
        {/* Routes - Router 안에서만 작동 */}
        <div>
          {routes.map((r) => (
            <Routes>
              <Route path={r.path} element={<r.component />}></Route>
            </Routes>
          ))}
        </div>
      </div>
    </Router>
  );
}

export default App;
