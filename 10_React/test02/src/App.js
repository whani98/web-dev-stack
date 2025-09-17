import { useState } from "react";
import logo from "./logo.svg";

function App() {
  let [work, setWork] = useState("");
  let [date, setDate] = useState("");
  let [todoList, setTodoList] = useState([]);
  const todoAdd = () => {
    if (work.trim() !== "" && date.trim() !== "") {
      setTodoList([...todoList, { work, date }]);
    }
    setWork("");
    setDate("");
  };
  return (
    <div className="App">
      <h1>할 일 목록</h1>
      <input
        type="text"
        placeholder="할 일을 입력하세요"
        onChange={(e) => {
          setWork(e.target.value);
        }}
      />
      <br />
      <input
        type="text"
        placeholder="마감일 (예: 2025-09-20)"
        onChange={(e) => {
          setDate(e.target.value);
        }}
      />
      <input type="button" value="추가" onClick={todoAdd} />
      <br />
      <br />
      <table border="1">
        <tr>
          <th>할 일</th>
          <th>마감일</th>
          <th>작업</th>
        </tr>
        {todoList.map((t) => (
          <tr>
            <td>{t.work}</td>
            <td>{t.date}</td>
            <td>
              <input type="button" value="삭제" />
            </td>
          </tr>
        ))}
      </table>
    </div>
  );
}

export default App;
