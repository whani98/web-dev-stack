import { BrowserRouter, Route, Routes } from "react-router-dom";
import Celebrity from "./pages/Celebrity";
import Home from "./pages/Home";
import Movies from "./pages/Movies";
import Tv from "./pages/Tv";
import NotFound from "./pages/NotFound";
import Header from "./components/Header";
import "./index.css";
import MovieDetail from "./pages/MovieDetail";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header></Header>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/movie" element={<Movies />} />
          <Route path="/movie/:title" element={<MovieDetail />} />

          <Route path="/tv" element={<Tv />} />
          <Route path="/person" element={<Celebrity />} />
          {/* '/*': 위 외의 모든 페이지 */}
          <Route path="/*" element={<NotFound />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
