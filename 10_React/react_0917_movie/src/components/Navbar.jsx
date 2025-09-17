import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      {/* <Route path="/"와 연결 */}
      <Link class="navbar-brand" to="/">
        NaviTitle
      </Link>
      <button
        class="navbar-toggler"
        data-toggle="collapse"
        data-target="#navbarNav"
        area-controls="navbarNav"
        area-expanded="false"
        area-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item active">
            {/* <Route path="/movies"와 연결 */}
            <Link class="nav-link" to="/movies">
              Movies
            </Link>
          </li>
          <li class="nav-item">
            {/* <Route path="/users"와 연결 */}
            <Link class="nav-link" to="/users">
              Users
            </Link>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default Navbar;
