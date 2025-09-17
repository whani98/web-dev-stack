import { useState } from "react";
import Movie from "./components/Movie";
import "./index.css";
import MovieForm from "./components/MovieForm";
import Navbar from "./components/Navbar";

import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

// 영화 삭제
function App() {
  //const [movieTitle, setMovieTitle] = useState("");
  //const [movieYear, setMovieYear] = useState("");
  const [movies, setMovies] = useState([]);

  const removeMovie = (id) => {
    // alert(id);
    setMovies(
      movies.filter((movie) => {
        // 내가 지우고 싶은 아이디와 다르면 setMovies에 값을 집어넣어!
        return movie.id != id;
      })
    );
  };

  const addMovie = (movie) => {
    // e.preventDefault(); MovieForm에서 값을 받아야하기 때문에 필요가 없어짐
    setMovies([...movies, movie]);
    //setMovieTitle(""); MovieForm으로 이동
    //setMovieYear("");
  };
  // 삼항연산자 사용
  const renderMovies = movies.length
    ? movies.map((movie) => {
        return (
          <Movie movie={movie} removeMovie={removeMovie} /> // import 필수, Movie.jsx와 연결됨
        );
      })
    : "등록된 영화가 없습니다.";

  return (
    <Router>
      <div className="App">
        <Navbar />
        {/* Routes - Router 안에서만 작동 */}
        <Routes>
          <Route
            path="/movies"
            element={
              <div>
                <h1>Movie List</h1>
                <MovieForm addMovie={addMovie} />

                {renderMovies}
              </div>
            }
          ></Route>
          <Route path="/users" element={<h1>Users 컴포넌트</h1>}></Route>
          <Route path="/" element={<h1>Home 컴포넌트</h1>}></Route>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
