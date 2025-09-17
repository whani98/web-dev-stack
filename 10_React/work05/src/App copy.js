import { useState } from "react";
import logo from "./logo.svg";
// 이름과 나이를 입력받아 사용자 목록에 추가
function App() {
  let [name, setName] = useState("");
  let [age, setAge] = useState("");
  let [userList, setUserList] = useState([]);
  function inputName(e) {
    setName(e.target.value);
  }
  function inputAge(e) {
    setAge(e.target.value);
  }
  function addUser() {
    if (name.trim() && age.trim()) {
      //let newUser = { name: name, age: age };
      //setUserList([...userList, newUser]); 아래 한 줄과 동일
      setUserList([...userList, { name, age }]);
      setName(""); // 이름 입력 후 초기화
      setAge(""); // 나이 입력 후 초기화
    }
  }

  return (
    <div className="App">
      <h1>사용자 목록</h1>
      <input
        type="text"
        placeholder="이름 입력"
        value={name}
        onChange={inputName}
      />
      <br />
      <input
        type="number"
        placeholder="나이 입력"
        value={age}
        onChange={inputAge}
      />
      <input type="button" value="확인" onClick={addUser} />
      <br />
      <br />
      <table border="1">
        <tr>
          <th>이름</th>
          <th>나이</th>
        </tr>

        {userList.map((u) => (
          <tr>
            <td>{u.name}</td>
            <td>{u.age}</td>
          </tr>
        ))}
      </table>
    </div>
  );
}

export default App;
