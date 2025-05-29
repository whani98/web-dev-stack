// 아이디입력
const id = document.querySelector("#id");
const resultId = document.querySelector("#resultId");
id.addEventListener("input", (e) => {
  const idExp = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;
  if (idExp.test(e.target.value)) {
    resultId.innerHTML = "OK!";
    resultId.style.color = "blue";
  } else {
    resultId.innerHTML = "NO!";
    resultId.style.color = "red";
  }
});

// 비밀번호 입력
const pw = document.querySelector("#pw");
const resultPw = document.querySelector("#resultPw");
pw.addEventListener("input", (e) => {
  const pwExp =
    /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
  if (pwExp.test(e.target.value)) {
    resultPw.innerHTML = "OK!";
    resultPw.style.color = "blue";
  } else {
    resultPw.innerHTML = "NO!";
    resultPw.style.color = "red";
  }
});
console.log(pw.addEventListener);

// 비밀번호 확인
const pw2 = document.querySelector("#pw2");
const resultPw2 = document.querySelector("#resultPw2");
pw2.addEventListener("input", (e) => {
  const pwExp =
    /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
  // 앞에서 입력한 비밀번호와 현재 입력한 비밀번호가 일치할 때만 OK!=>value이용!
  if (pw.value === pw2.value) {
    resultPw2.innerHTML = "OK!";
    resultPw2.style.color = "blue";
  } else {
    resultPw2.innerHTML = "NO!";
    resultPw2.style.color = "red";
  }
});
// 이름 입력
const name = document.querySelector("#name");
const resultIName = document.querySelector("#resultName");
name.addEventListener("input", (e) => {
  const nameExp = /^[가-힣]{2,}$/;
  if (nameExp.test(e.target.value)) {
    resultName.innerHTML = "OK!";
    resultName.style.color = "blue";
  } else {
    resultName.innerHTML = "NO!";
    resultName.style.color = "red";
  }
});

// 이메일 입력
const email = document.querySelector("#email");
const resultIEmail = document.querySelector("#resultEmail");
email.addEventListener("input", (e) => {
  const emailExp = /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/;
  if (emailExp.test(e.target.value)) {
    resultEmail.innerHTML = "OK!";
    resultEmail.style.color = "blue";
  } else {
    resultEmail.innerHTML = "NO!";
    resultEmail.style.color = "red";
  }
});
// 전화번호 입력
const tel = document.querySelector("#tel");
const resultTel = document.querySelector("#resultTel");
tel.addEventListener("input", (e) => {
  const telExp = /^010-\d{4}-\d{4}$/;
  if (telExp.test(e.target.value)) {
    resultTel.innerHTML = "OK!";
    resultTel.style.color = "blue";
  } else {
    resultTel.innerHTML = "NO!";
    resultTel.style.color = "red";
  }
});

const join = () => {
  if (confirm("회원가입 하시겠습니까?")) {
    alert("회원가입 되었습니다!");
  }
};
const reset = document.querySelector("#reset");
reset.addEventListener("click", () => {
  location.reload();
});
