import { useState } from "react";
import logo from "./logo.svg";
// 강사님 풀이
function App() {
  let [greet, setGreet] = useState("");
  let [msg, setMsg] = useState("");

  function nameChange(e) {
    e.preventDefault();
    let name = e.target.myname.value;
    setGreet("안녕하세요. " + name + "님! 오늘의 기분은 어떠신가요?");
  }
  function moodChange(e) {
    let mood = e.target.value;
    setMsg(mood);
    if (mood === "행복") {
      setMsg("ㅅ.ㅅ");
    } else if (mood === "슬픔") {
      setMsg("ㅠ.ㅠ");
    } else if (mood === "화남") {
      setMsg("ㅡ.ㅡ");
    }
  }
  return (
    <div className="App">
      <form onSubmit={nameChange}>
        <input type="text" name="myname" placeholder="이름을 입력하세요." />
        <input type="submit" value="인사하기" />
      </form>
      <p>{greet}</p>
      {/* 기분을 선택하는 select tag */}
      {/* 기분을 선택하는 코드를 MyMood컴포넌트로 분리 */}
      <div>
        <select onChange={moodChange}>
          <option value="">기분을 선택하세요.</option>
          <option value="행복">행복</option>
          <option value="슬픔">슬픔</option>
          <option value="화남">화남</option>
        </select>
        <p>{msg}</p>
      </div>
    </div>
  );
}

export default App;
