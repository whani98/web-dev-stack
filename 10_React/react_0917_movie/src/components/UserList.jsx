import React from "react";
import { Link } from "react-router-dom";

const UserList = ({ users }) => {
  return (
    <div>
      {users.map((user) => {
        return (
          <div className="card mb-2">
            <div className="card-body">
                {/* 템플릿 리터럴, 백콧 사용할 것! */}
              <Link to={`/users/${user.id}`}>{user.name}</Link>
            </div>
          </div>
        );
      })}
    </div>
  );
};
export default UserList;
