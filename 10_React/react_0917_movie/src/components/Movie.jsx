import React from "react";

//function Movie(){} 아래와 같은 의미
const Movie = ({ movie, removeMovie }) => {
  // App.js 에서 movie={movie}에서 등호 앞의 movie를 뜻함
  return (
    // html 태그는 js보다 jsx에서 호환이 더 잘됨
    <div className="movie">
      <div className="movie-title">
        {movie.title}
        <span className="movie-year">({movie.year})</span>
      </div>
      <div>
        <input
          type="button"
          value="삭제"
          onClick={() => {
            removeMovie(movie.id);
          }}
        />
      </div>
    </div>
  );
};

export default Movie;
