import { useState } from "react";
import logo from "./logo.svg";
import "./App.css";
function App() {
  let [selColor, setSelColor] = useState("");
  // 노란색 배경일 때는 검정 글씨 변경하기 위함
  let [mfont, setFont] = useState("");
  let onChange = (event) => {
    let color = event.target.value;
    setSelColor(color);
    // 배경에 따른 글자색 변경
    if (color == "yellow") {
      setFont("black");
    } else {
      setFont("white");
    }
  };

  return (
    <div className="App">
      <div
        style={{
          boxShadow: "#CCC 5px 5px 5px",
          width: "160px",
          padding: "10px",
        }}
      >
        색상선택
        <select onChange={onChange}>
          <option value="">:::색상 선택:::</option>
          <option value="red">빨강</option>
          <option value="blue">파랑</option>
          <option value="green">초록</option>
          <option value="yellow">노랑</option>
        </select>
      </div>

      <div
        id="exam_div"
        style={{
          backgroundColor: selColor,
          color: mfont,
        }}
      >
        {selColor}
      </div>
    </div>
  );
}

export default App;
