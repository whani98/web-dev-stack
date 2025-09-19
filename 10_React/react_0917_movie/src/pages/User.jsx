import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import Spinner from "../components/Spinner";
import UserList from "../components/UserList";

const User = () => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  // id 파라미터를 받기위함
  const { id } = useParams();
  //alert("id " + id); 파라미터 잘 받는지 확인용

  useEffect(() => {
    // 웹에 준비되어있는 유저 정보를 가져온다.
    axios
      .get("https://jsonplaceholder.typicode.com/users/" + id)
      // 우리가 불러온 정보
      .then((response) => {
        setUser(response.data); // 배열에 다 넣었음 -> 로딩 끝
        setLoading(false); // 로드 종료
      });
  });

  const userDetail = loading ? (
    <Spinner />
  ) : (
    <div>
      <div>{user.name}</div>
      <div>{user.email}</div>
      <div>{user.phone}</div>
    </div>
  );
  return (
    <div>
      <h1>유저 정보</h1>
      {/*response.data로 채워져 있는 users를 보냄*/}
      {userDetail}
    </div>
  );
};

export default User;
