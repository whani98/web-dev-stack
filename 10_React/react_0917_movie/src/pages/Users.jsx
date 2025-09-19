import React, { useState, useEffect } from "react";
import axios from "axios";
import UserList from "../components/UserList";
import Spinner from "../components/Spinner";
const Users = () => {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // 웹에 준비되어있는 유저 정보를 가져온다.
    axios
      .get("https://jsonplaceholder.typicode.com/users")
      // 우리가 불러온 정보
      .then((response) => {
        setUsers(response.data); // 배열에 다 넣었음 -> 로딩 끝
        setLoading(false); // 로드 종료
      });
  });

  return (
    <div>
      <h1>유저목록 페이지</h1>
      {/*response.data로 채워져 있는 users를 보냄*/}
      {loading ? <Spinner /> : <UserList users={users} />}
    </div>
  );
};

export default Users;
