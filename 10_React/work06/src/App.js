import { useState } from "react";
import logo from "./logo.svg";
import ScForm from "./components/ScForm";
// 강사님 코드 부분 추가
function App() {
  let [work, setWork] = useState("");
  let [date, setDate] = useState("");
  let [todoList, setTodoList] = useState([]);
  function todoAdd() {
    if (work.trim() && date.trim()) {
      setTodoList([...todoList, { work, date }]);
      setWork("");
      setDate("");
    }
  }
  const todoDelete = (index) => {
    //alert(index);
    const newTodo = todoList.filter((_, i) => i !== index);
    setTodoList(newTodo);
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

      {/* ScForm.jsx에서 받은 파라미터값 넣기*/}
      <ScForm todoList={todoList} todoDelete={todoDelete} />

      <br />
    </div>
  );
}

export default App;
