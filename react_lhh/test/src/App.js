import { useState } from "react";
import logo from "./logo.svg";

function App() {
  let [selMenu, setSelMenu] = useState("");
  let menuChange = (event) => {
    // 옵션 선택할 때마다 selMenu의 값이 바뀜
    if (event.target.value != "") {
      setSelMenu(event.target.value + " 선택됨.");
    } else {
      setSelMenu("메뉴를 선택 하세요.");
    }
  };
  return (
    <div className="App">
      <h1>메뉴 선택</h1>
      <select
        // onChange 각 option에 반응
        onChange={menuChange}
      >
        <option value="">메뉴</option>
        <option value="까르니따스">까르니따스</option>
        <option value="도래창">도래창</option>
        <option value="쉬림프">쉬림프</option>
      </select>
      <p style={{ color: "blue" }}>{selMenu}</p>
    </div>
  );
}

export default App;
