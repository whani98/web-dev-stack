import { useState } from "react";
import Movie from "./components/Movie";
import "./index.css";
// map 사용하기 강사님 정답
function App() {
  const [movieTitle, setMovieTitle] = useState("");
  const [movieYear, setMovieYear] = useState("");
  const [movies, setMovies] = useState([
    { title: "해리포터1", year: 2001 },
    { title: "쥬라기월드", year: 2025 },
  ]);

  const renderMovies = movies.map((movie) => {
    return (
      <Movie movie={movie} /> // import 필수, Movie.jsx와 연결됨
    );
  });
  const addMovie = (e) => {
    e.preventDefault();
    alert(movieTitle + " " + movieYear);
  };

  return (
    <div className="App">
      <h1>Movie List</h1>
      <form onSubmit={addMovie}>
        <input
          type="text"
          placeholder="영화 제목"
          value={movieTitle}
          onChange={(e) => {
            setMovieTitle(e.target.value);
          }}
        />
        <input
          type="text"
          placeholder="개봉 연도"
          value={movieYear}
          onChange={(e) => {
            setMovieYear(e.target.value);
          }}
        />

        <input type="submit" value="영화 등록" />
      </form>

      {renderMovies}
    </div>
  );
}

export default App;
