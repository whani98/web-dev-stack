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

      <div>
        <MyMood onChange={moodChange}></MyMood>
        <p>{msg}</p>
      </div>
    </div>
  );
}
{
  /* 기분을 선택하는 코드를 MyMood컴포넌트로 분리 */
}
function MyMood(props) {
  let lis = [];
  let emotions = [
    { value: "", text: "기분을 선택하세요." },
    { value: "행복", text: "행복" },
    { value: "슬픔", text: "슬픔" },
    { value: "화남", text: "화남" },
  ];

  for (let i = 0; i < emotions.length; i++) {
    let emotion = emotions[i];
    lis.push(<option value={emotion.value}>{emotion.text}</option>);
  }

  return <select onChange={props.onChange}>{lis}</select>;
}

export default App;
