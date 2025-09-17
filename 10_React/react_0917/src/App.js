import { useState } from "react";
import logo from "./logo.svg";

function App() {
  let [fruit, setFruit] = useState([]); // []를 넣으면 배열로 초기화
  let [inputVal, setInputVal] = useState("");

  function addFruit() {
    if (inputVal.trim().length > 0) {
      setFruit([...fruit, inputVal]); /// ...fruit-> 배열 복사, [...기존 배열, 새로 추가할 값]
      setInputVal(""); // 입력창 초기화
    }
  }
  return (
    <div className="App">
      <input
        type="text"
        value={inputVal}
        onChange={(e) => {
          setInputVal(e.target.value);
        }}
        placeholder="좋아하는 과일"
      />
      <input type="button" value="확인" onClick={addFruit} />
      <ul>
        {fruit.map((f) => (
          <li>{f}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
