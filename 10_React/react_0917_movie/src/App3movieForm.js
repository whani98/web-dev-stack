import { useState } from "react";
import Movie from "./components/Movie";
import "./index.css";
import MovieForm from "./components/MovieForm";
// 영화 등록
function App() {
  const [movieTitle, setMovieTitle] = useState("");
  const [movieYear, setMovieYear] = useState("");

  const [movies, setMovies] = useState([
    { title: "해리포터1", year: 2001 },
    { title: "쥬라기월드", year: 2025 },
  ]);

  const addMovie = (movie) => {
    // e.preventDefault(); MovieForm에서 값을 받아야하기 때문에 필요가 없어짐
    setMovies([...movies, movie]);
    //setMovieTitle(""); MovieForm으로 이동
    //setMovieYear("");
  };

  const renderMovies = movies.map((movie) => {
    return (
      <Movie movie={movie} /> // import 필수, Movie.jsx와 연결됨
    );
  });

  return (
    <div className="App">
      <h1>Movie List</h1>
      <MovieForm addMovie={addMovie} />

      {renderMovies}
    </div>
  );
}

export default App;
