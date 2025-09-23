import React from "react";
import { useNavigate } from "react-router-dom";
const IMG_BASE_URL = "https://image.tmdb.org/t/p/w1280/";

export default function Movie(props) {
  const navigate = useNavigate();
  const onClickMovieItem = () => {
    // 원하는 정보를 보낼 수 있음
    // { state: props } props를 통해서 title은 제외한 모든 정보를 묶어서 보내줌
    navigate(`/movie/${props.title}`, { state: props });
  };

  return (
    <div className="movie-container" onClick={onClickMovieItem}>
      <img src={IMG_BASE_URL + props.poster_path} />
      <div className="movie-info">
        <h4>{props.title}</h4>
        <span>{props.vote_average}</span>
      </div>
    </div>
  );
}
