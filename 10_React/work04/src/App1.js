import { useState } from "react";
import logo from "./logo.svg";
// 내 풀이
function App() {
  let [name, setName] = useState("");
  let [ment, setMent] = useState("");
  let [emotional, setEmotional] = useState("");

  <input type="text" placeholder="이름을 입력하세요." onChange={inputName} />;
  function inputName(event) {
    setName(event.target.value);
  }
  function hi() {
    setMent("안녕하세요. " + name + "님! 오늘의 기분은 어떠신가요?");
  }
  function emotion(event) {
    let nowEmotion = event.target.value;
    setEmotional(nowEmotion);
    // if (nowEmotion === "행복") {
    //   setEmotional("행복해요^ㅇ^");
    // } else if (nowEmotion === "슬픔") {
    //   setEmotional("슬퍼요 ㅠㅠ");
    // } else if (nowEmotion === "화남") {
    //   setEmotional("화나요 ㅡ.ㅡ");
    // }
  }
  return (
    <div className="App">
      <input
        type="text"
        placeholder="이름을 입력하세요."
        onChange={inputName}
      />
      <input type="button" value="인사하기" onClick={hi} />

      <h5>{ment}</h5>
      <br />
      <select onChange={emotion}>
        <option value="">기분을 선택하세요</option>
        <option value="행복해요 ^.^">행복</option>
        <option value="슬퍼요 ㅠ.ㅠ">슬픔</option>
        <option value="화나요 ㅡ.ㅡ">화남</option>
      </select>
      <p>{emotional}</p>
    </div>
  );
}

export default App;
