import { useState } from "react";
import logo from "./logo.svg";
// 내 코드
function App() {
  let [work, setWork] = useState("");
  let [date, setDate] = useState("");
  let [todoList, setTodoList] = useState([]);
  function todoAdd() {
    if (work.trim() && date.trim()) {
      setTodoList([...todoList, { work: work, date: date }]);
      setWork("");
      setDate("");
    }
  }
  const todoDelete = (index) => {
    //alert(index);
    todoAdd();
    setTodoList(todoList.filter((res, i) => i !== index));
  };

  return (
    <div className="App">
      <h1>할 일 목록</h1>
      <input
        type="text"
        placeholder="할 일을 입력하세요"
        value={work}
        onChange={(e) => {
          setWork(e.target.value);
        }}
      />
      <br />
      <input
        type="text"
        placeholder="마감일 (예: 2025-09-20)"
        value={date}
        onChange={(e) => {
          setDate(e.target.value);
        }}
      />
      <input type="button" value="추가" onClick={todoAdd} />
      <br />

      <table border="1">
        <tr>
          <th>할 일</th>
          <th>마감일</th>
          <th>작업</th>
        </tr>
        {todoList.map((t, index) => (
          <tr>
            <td>{t.work}</td>
            <td>{t.date}</td>
            <td>
              <input
                type="button"
                value="삭제"
                onClick={() => {
                  todoDelete(index);
                }}
              />
            </td>
          </tr>
        ))}
      </table>
      <br />
    </div>
  );
}

export default App;
