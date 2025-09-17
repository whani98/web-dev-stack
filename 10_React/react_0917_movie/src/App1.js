import "./index.css";
// map 사용하기 내 정답
function App() {
  const movies = [
    { title: "해리포터1", year: 2001 },
    { title: "쥬라기월드", year: 2025 },
  ];
  return (
    <div className="App">
      <h1>Movie List</h1>
      {movies.map((m) => (
        <div className="movie">
          <div className="movie-title">{m.title}</div>
          <div className="movie-year">{m.year}</div>
        </div>
      ))}
    </div>
  );
}

export default App;
