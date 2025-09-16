import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";

function App() {
  //let [num, setNum] = useState(0);와 동일
  let [count, setCount] = useState(0);
  //let minusClick = (event) => setNum(--num);와 동일
  function down() {
    setCount(count - 1);
  }
  //let resetClick = (event) => setNum(0);와 동일
  function reset() {
    setCount(0);
  }
  //let plusClick = (event) => setNum(++num);와 동일
  function up() {
    setCount(count + 1);
  }

  return (
    <div className="App">
      {/*minusClick */}
      <input type="button" value="-" onClick={down} />
      {/*resetClick */}
      <input type="button" value="0" onClick={reset} />
      {/*plusClick */}
      <input type="button" value="+" onClick={up} />

      <span style={{ color: "brown", margin: 5 }}>{count}</span>
    </div>
  );
}

export default App;
