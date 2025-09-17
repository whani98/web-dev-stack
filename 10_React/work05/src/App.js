import logo from "./logo.svg";

function App() {
  return (
    <div className="App">
      <h1>사용자 목록</h1>
      <input type="text" placeholder="이름 입력" />
      <br />
      <input type="text" placeholder="나이 입력" />
      <input type="button" value="확인" />
      <br />
      <br />
      <table border="1">
        <tr>
          <th>이름</th>
          <th>나이</th>
        </tr>
        <tr>
          <td></td>
          <td></td>
        </tr>
      </table>
    </div>
  );
}

export default App;
