const currentTime = () => {
  // 오늘 날짜
  const weeks = ["일", "월", "화", "수", "목", "금", "토"];
  const today = new Date();
  console.log(today);
  console.log(today.getFullYear()); // 년
  console.log(today.getMonth() + 1); // 월
  console.log(today.getDate()); //일
  console.log(weeks[today.getDay()]); //요일 (0:일, 1:월~)
  const year = today.getFullYear();
  const month = today.getMonth() + 1;
  const day = today.getDate();
  const date = today.getDate();
  const week = weeks[today.getDay()];

  const current = document.querySelector("#current");
  console.log(current);
  current.innerHTML = `${year}년 ${month}월 ${day}일 (${week})`;

  //현재 시간
  const hms = document.querySelector("#hms");
  console.log(today.getHours()); // 시
  console.log(today.getMinutes()); // 분
  console.log(today.getSeconds()); // 초
  const hour = String(today.getHours()).padStart(2, "0");
  const minute = String(today.getMinutes()).padStart(2, "0");
  const second = String(today.getSeconds()).padStart(2, "0"); // 2자리 차지하고 1자리가 비면 0으로 채움

  hms.innerHTML = `${hour}:${minute}:${second}`;
};

//랜덤 색상 배경
const randomBackground = () => {
  document.body;
  const body = document.body;
  const r = Math.floor(Math.random() * 256); // 0<= random <256
  const g = Math.floor(Math.random() * 256);
  const b = Math.floor(Math.random() * 256);
  // const backGround = [
  //   "#ED833A",
  //   "#EA839B",
  //   "#42B667",
  //   "#FFC228",
  //   "#005456",
  //   "#ACDED5",
  // ];
  body.style.background = `rgba(${r},${g},${b},0.3)`;
  //     backGround[Math.floor(Math.random() * backGround.length)];
};

// 올해 남은 시간
const count = () => {
  const last = new Date("2026-01-01 00:00:00"); //목표 하는 날짜
  const now = new Date();
  console.log(Math.floor((last - now) / 1000)); // 1초 = 밀리세컨드/1000

  const second = Math.floor((last - now) / 1000);
  const minute = Math.floor(second / 60); // 60초 = 1분
  const hour = Math.floor(minute / 60); // 60분 = 1시간
  const day = Math.floor(hour / 24); // 24시간 = 1일
  console.log(day);
  console.log(hour % 24);
  console.log(minute % 60);
  console.log(second % 60);

  const count = document.querySelector("#count");
  count.innerHTML = `올해 남은 시간 ${day}일 ${hour % 24}시간 ${
    minute % 60
  }분 ${second % 6}초`;
};

// 랜덤 명언
import quotes from "./quotes.js";
const randomQuote = () => {
  const random = quotes[Math.floor(Math.random() * quotes.length)];
  const quoteE = document.querySelector("#quoteE");
  const quoteK = document.querySelector("#quoteK");
  console.log(quotes[1].en);
  console.log(quotes[1].ko);
  quoteE.innerHTML = random.en;
  quoteK.innerHTML = random.ko;
};
currentTime();
randomBackground();
count();
randomQuote();

setInterval(() => {
  currentTime();
  count();
  randomBackground();
}, 1000); // 1000==1초
setInterval(() => {
  randomBackground();
  randomQuote();
}, 1000);
