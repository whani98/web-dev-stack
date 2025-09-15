import logo from "./logo.svg";
import "./App.css";

function App() {
  let topic = [
    { id: 1, title: "html", body: "my HTML" },
    { id: 2, title: "css", body: "my css" },
    { id: 3, title: "Java Script", body: "your js" },
  ];
  return (
    <div className="App">
      {/* function Header를 가져옴 */}
      {/* function Header의 파라미터 props에 React라는 값을 보낸다. */}
      <Header
        title="React"
        onChangeMode={(id) => {
          alert("id: " + id);
        }}
      ></Header>
      {/*function () {
          alert("I am Header");
        }*/}
      <Nav
        topics={topic}
        onChangeMode={(id) => {
          alert("id: " + id);
        }}
      ></Nav>
      <Article title="welcome" body="hello, web!"></Article>

      <Article title="I am title" body="I am body"></Article>

      <Child name="John"></Child>
    </div>
  );
}
{
  /* 컴포넌트 : function 이름은 반드시 대문자로 시작!*/
}

function Header(props) {
  return (
    <header>
      <h1>
        {/* 파라미터명.value 이름 */}
        <a
          href="/"
          onClick={function (event) {
            // a 태그의 기본인 클릭 동작을 방지
            event.preventDefault();
            props.onChangeMode();
          }}
        >
          {props.title}
        </a>
      </h1>
    </header>
  );
}

function Nav(props) {
  let lis = [];
  for (let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];
    // lis.push(
    //   <li>
    //     <a href={"/read/" + t.id}>
    //       {t.title} / {t.body}
    //     </a>
    //   </li>
    // );
    lis.push(
      <li>
        <a
          id={t.id}
          href={"/read/" + t.id}
          onClick={function (event) {
            event.preventDefault();
            props.onChangeMode(event.target.id);
          }}
        >
          {t.title}/{t.body}
        </a>
      </li>
    );
  }
  return (
    <nav>
      <ul>{lis}</ul>
    </nav>
  );
}

function Article(props) {
  return (
    <article>
      <h2>{props.title}</h2>
      {props.body}
    </article>
  );
}

function Child(props) {
  return (
    <div>
      <h2>Hello, {props.name}</h2>
    </div>
  );
}

export default App;
