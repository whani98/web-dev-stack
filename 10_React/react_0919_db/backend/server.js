const express = require("express");
const mysql = require("mysql2");
const cors = require("cors");

const app = express();
app.use(cors());
app.use(express.json());

// DB 연결 정보
const db = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "qwer1234",
  database: "signup",
});

// 회원가입 - DB 접속 및 쿼리 요청
app.post("/signup", (req, res) => {
  const sql = "insert into login (`name`, `email`, `password`) values (?)";
  // ? 에 넣을 데이터
  const values = [req.body.name, req.body.email, req.body.password];

  db.query(sql, [values], (err, data) => {
    if (err) {
      return res.json("Error");
    }
    return res.json(data);
  });
});
// 로그인 - DB 접속 및 쿼리 요청
app.post("/login", (req, res) => {
  const sql = "select * from login where `email`=? and `password`=?";
  // ? 에 넣을 데이터
  const values = [req.body.email, req.body.password];

  db.query(sql, values, (err, data) => {
    if (err) {
      return res.json("error");
    }

    if (data.length > 0) {
      return res.json("success");
    } else {
      return res.json("fail");
    }
  });
});
// 서버포트 3000에서 리스닝 시작 시 "listening" 출력
app.listen(3000, () => {
  console.log("listening");
});
