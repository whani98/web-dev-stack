import React, { useState } from "react";
import MainPage from "./MainPage";
import LoginForm from "./LoginForm";

const User = { email: "test@a.com", pw: "1111" };
// 로그인 페이지
export default function Login() {
  const [isLogin, setLogin] = useState(false);
  const [email, setEmail] = useState("");
  const [pw, setPw] = useState("");
  const [emailValid, setEmailValid] = useState(false);
  const [pwValid, setPwValid] = useState(false);

  // 이메일 입력을 확인하는 감지자
  const handleEmail = (e) => {
    setEmail(e.target.value);
    if (e.target.value == "") {
      setEmailValid(false);
    } else {
      setEmailValid(true);
    }
  };
  // 비밀번호 입력을 확인하는 감지자
  const handlePw = (e) => {
    setPw(e.target.value);
    if (e.target.value == "") {
      setPwValid(false);
    } else {
      setPwValid(true);
    }
  };
  // 로그인 확인
  const clickConfirm = () => {
    if (email === User.email && pw === User.pw) {
      alert("로그인 성공");
      setLogin(true);
    } else {
      alert("이메일과 비밀번호를 다시 입력해주세요.");
    }
  };
  return (
    <div>
      {isLogin ? (
        <MainPage email={email} />
      ) : (
        <LoginForm
          email={email}
          pw={pw}
          handleEmail={handleEmail}
          handlePw={handlePw}
          emailValid={emailValid}
          pwValid={pwValid}
          clickConfirm={clickConfirm}
        />
      )}
    </div>
  );
}
