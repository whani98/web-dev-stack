import logo from "./logo.svg";

function App() {
  let taco = [
    { id: 1, title: "까르니따스" },
    { id: 2, title: "도래창" },
    { id: 3, title: "쉬림프" },
  ];
  return (
    <div className="App">
      <h1>메뉴 선택</h1>
      <Select tacos={taco}></Select>
      <h3>내용 없음</h3>
    </div>
  );
}
function Select(props) {
  let lis = [];
  for (let i = 0; i < props.tacos.length; i++) {
    let t = props.tacos[i];
    lis.push(<option id={t.id}>{t.title}</option>);
  }
  return (
    <select>
      <option>타코 메뉴</option>
      {lis}
    </select>
  );
}

export default App;
