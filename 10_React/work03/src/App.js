import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";

function App() {
  //let [num, setNum] = useState(0);와 동일
  let [count, setCount] = useState(0);
  let [ment, setMent] = useState("짝수/홀수 확인버튼을 눌러주세요");
  //let minusClick = (event) => setNum(--num);와 동일
  function down() {
    setCount(--count);
  }
  //let resetClick = (event) => setNum(0);와 동일
  function reset() {
    setCount(0);
  }
  //let plusClick = (event) => setNum(++num);와 동일
  function up() {
    setCount(++count);
  }
  // let onChange = (event) => setCount(event.target.value);와 동일
  function onChange(event) {
    setCount(Number(event.target.value));
  }
  function oddOrEven() {
    if (count % 2 === 0 && count > 0) {
      setMent("현재 카운트는 짝수입니다.");
    } else if (count % 2 === 1 && count > 0) {
      setMent("현재 카운트는 홀수입니다.");
    } else if (count === 0) {
      setMent("현재 카운트는 0입니다.");
    } else if (count < 0) {
      setMent("현재 카운트는 음수입니다.");
    }
  }
  return (
    <div className="App">
      {/*minusClick */}
      <input type="button" value="-" onClick={down} />
      {/*resetClick */}
      <input type="button" value="0" onClick={reset} />
      {/*plusClick */}
      <input type="button" value="+" onClick={up} />

      <input type="number" value={count} onChange={onChange} />
      <span style={{ color: "brown", margin: 5 }}>{count}</span>
      <br />
      <br />
      <input type="button" value="짝수/홀수 확인" onClick={oddOrEven} />
      <br />
      <br />
      <span>{ment}</span>
    </div>
  );
}

export default App;
