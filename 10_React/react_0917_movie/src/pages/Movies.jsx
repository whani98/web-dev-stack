import React, { useState } from "react";
import MovieForm from "../components/MovieForm";
import Movie from "../components/Movie";

const Movies = () => {
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
    <div>
      <h1>Movie List</h1>

      <MovieForm addMovie={addMovie} />

      {renderMovies}
    </div>
  );
};

export default Movies;
