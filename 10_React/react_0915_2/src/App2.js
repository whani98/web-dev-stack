import { useState } from "react";
import logo from "./logo.svg";

function App() {
  //let mode = "WELCOME";
  // setMode가 함수처럼 작동
  let [mode, setMode] = useState("WELCOME"); // import 되어야함
  let [id, setId] = useState(null);

  let [nextId, setNextId] = useState(4);
  let content = null;

  let [m_topics, setTopics] = useState([
    { id: 1, title: "html", body: "my html" },
    { id: 2, title: "css", body: "your css" },
    { id: 3, title: "java script", body: "our js" },
  ]);

  if (mode === "WELCOME") {
    content = <Article title="welcome mode state" body="STATE WEB"></Article>;
  } else if (mode === "READ") {
    let title = null;
    let body = null;
    for (let i = 0; i < m_topics.length; i++) {
      if (m_topics[i].id === id) {
        // === id는 useState의 id
        title = m_topics[i].title;
        body = m_topics[i].body;
      }
      content = <Article title={title} body={body}></Article>;
    }
  } else if (mode === "CREATE") {
    content = (
      <Create
        onCreate={(title, body) => {
          let newTopic = { id: nextId, title: title, body: body };
          // [...m_topics] -> m_topics 배열을 newTopics에 통째로 복사하는 코드
          let newTopics = [...m_topics];
          newTopics.push(newTopic);
          setTopics(newTopics);

          setMode("READ");
          setId(nextId);
          setNextId(nextId + 1);
        }}
      ></Create>
    );
  }

  return (
    <div className="App">
      <Header
        title="React"
        onChangeMode={() => {
          setMode("WELCOME");
        }}
      ></Header>
      <Nav
        topics={m_topics}
        onChangeMode={(id) => {
          setMode("READ");
          setId(id);
        }}
      ></Nav>
      <Article title="Welcome!!!" body="hello react web~"></Article>

      {content}
      <a
        href="/create"
        onClick={(event) => {
          event.preventDefault(); // a 기본 기능 비활성화
          setMode("CREATE");
        }}
      >
        Create
      </a>
    </div>
  );
}
function Create(props) {
  return (
    <article>
      <h2>Create</h2>
      <form
        onSubmit={(event) => {
          //alert("submit!");
          event.preventDefault(); // 새로고침 방지
          let title = event.target.title.value;
          let body = event.target.body.value;
          props.onCreate(title, body);
        }}
      >
        <input type="text" name="title" placeholder="input title" />
        <br />
        <textarea name="body"></textarea>
        <br />
        <input type="submit" value="new Create"></input>
      </form>
    </article>
  );
}
function Header(props) {
  return (
    <header>
      <h1>
        <a
          href="/"
          onClick={() => {
            alert("onClick 써서 헤더 클릭?!");
          }}
        >
          {props.title}
        </a>
      </h1>
      <h1>
        <a
          href="/"
          onClick={(event) => {
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
    lis.push(
      <li>
        <a
          href={"/read/" + t.id}
          id={t.id}
          onClick={(event) => {
            event.preventDefault();
            props.onChangeMode(Number(event.target.id));
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
export default App;
