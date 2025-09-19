import Home from "./pages/Home";
import Movies from "./pages/Movies";
import User from "./pages/User";
import Users from "./pages/Users";

export default [
  { path: "/", component: Home },
  { path: "/Movies", component: Movies },
  { path: "/Users", component: Users },
  { path: "/Users/:id", component: User },
];
