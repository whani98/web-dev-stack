import React, { useState } from "react";
import InputField from "./InputField";

const MovieForm = ({ addMovie }) => {
  const [movieTitle, setMovieTitle] = useState("");
  const [movieYear, setMovieYear] = useState("");

  const [titleError, setTitleError] = useState("");
  const [yearError, setYearError] = useState("");

  const validateForm = () => {
    let validated = true;
    if (!movieTitle) {
      setTitleError("영화 제목을 입력하세요.");
      validated = false;
    }
    if (!movieYear) {
      setYearError("개봉 연도를 입력하세요.");
      validated = false;
    }
    return validated;
  };

  const onSubmit = (e) => {
    e.preventDefault();
    // validated = false;면 영화 등록 X
    if (validateForm()) {
      addMovie({
        id: Date.now(),
        title: movieTitle,
        year: movieYear,
      });
      setTitleError("");
      setYearError("");
    }
    setMovieTitle("");
    setMovieYear("");
  };
  return (
    <form onSubmit={onSubmit}>
      <InputField
        value={movieTitle}
        placeholder={"영화 제목 입력"}
        onChange={(e) => {
          setMovieTitle(e.target.value);
        }}
        errorMessage={titleError}
      />
      <InputField
        value={movieYear}
        placeholder={"개봉 연도 입력"}
        onChange={(e) => {
          setMovieYear(e.target.value);
        }}
        errorMessage={yearError}
      />
      <input type="submit" value="영화 등록" />
    </form>
  );
};

export default MovieForm;
/* 
이렇게 적어도 가능
export default function MovieForm(){ } 
*/
