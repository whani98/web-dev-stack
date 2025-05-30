// 아이디입력
const id = document.querySelector("#id");
const resultId = document.querySelector("#resultId");
id.addEventListener("input", (e) => {
  const idExp = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;
  const iEt = idExp.test(e.target.value);
  if (iEt) {
    resultId.innerHTML = "OK!";
    resultId.style.color = "blue";
  } else {
    resultId.style.color = "red";
  }
});

// 비밀번호 입력
const pw = document.querySelector("#pw");
const resultPw = document.querySelector("#resultPw");
pw.addEventListener("input", (e) => {
  const pwExp =
    /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
  const pEt = pwExp.test(e.target.value);
  if (pEt) {
    resultPw.innerHTML = "OK!";
    resultPw.style.color = "blue";
  } else {
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
  const pwOk = pw.value === pw2.value;
  if (pwOk) {
    resultPw2.innerHTML = "OK!";
    resultPw2.style.color = "blue";
  } else {
    resultPw2.style.color = "red";
  }
});
// 이름 입력
const name = document.querySelector("#name");
const resultIName = document.querySelector("#resultName");
name.addEventListener("input", (e) => {
  const nameExp = /^[가-힣]{2,}$/;
  const nEt = nameExp.test(e.target.value);
  if (nEt) {
    resultName.innerHTML = "OK!";
    resultName.style.color = "blue";
  } else {
    resultName.style.color = "red";
  }
});

// 이메일 입력
const email = document.querySelector("#email");
const resultIEmail = document.querySelector("#resultEmail");
email.addEventListener("input", (e) => {
  const emailExp = /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/;
  const eEt = emailExp.test(e.target.value);

  if (eEt) {
    resultEmail.innerHTML = "OK!";
    resultEmail.style.color = "blue";
  } else {
    resultEmail.style.color = "red";
  }
});
// 전화번호 입력
const tel = document.querySelector("#tel");
const resultTel = document.querySelector("#resultTel");
tel.addEventListener("input", (e) => {
  const telExp = /^010-\d{4}-\d{4}$/;
  const tEt = telExp.test(e.target.value);
  if (tEt) {
    resultTel.innerHTML = "OK!";
    resultTel.style.color = "blue";
  } else {
    resultTel.style.color = "red";
  }
});
// 모두 맞게 입력하면 회원가입 버튼의 색이 바뀌도록
const input = document.querySelectorAll("input");
const joinButton = document.querySelector("#join");
console.log(input);
if (input === true) {
  joinButton.style.backgroudColor = "rgb(34, 185, 153)";
}

// 회원가입 버튼을 누르면 회원가입 여부 묻고 회원가입 되었다고 알림
const join = () => {
  if (confirm("회원가입 하시겠습니까?")) {
    alert("회원가입 되었습니다!");
  }
};
// 취소 버튼을 누르면 새로고침
const reset = document.querySelector("#reset");
reset.addEventListener("click", () => {
  location.reload();
});
