import { Link, Outlet } from "react-router-dom";
import Footer from "./Footer";
import LogInModal from "./LogInModal";
import logo from "./Mask group.png";
import classes from "./NavBar.module.css";

function NavBar() {
  return (
    <>
      <div className={`nav-bar ${classes.NavBar}`}>
        <nav>
          <Link to={"/"}>
            <img
              src={logo}
              className="logo-img"
              alt="logo of the webpage"
            ></img>
          </Link>
          <ul className="nav-links">
            <li>
              <Link to="/weekly-menu">Weekly menu</Link>
            </li>
            <li>
              <a href="/food-list">Food list</a>
            </li>
            <li>
              <a href="/">Orders</a>
            </li>
            <li>
              <a href="/">Favorites</a>
            </li>
            <li>
              <a href="/">User profile</a>
            </li>
            <li>
              <LogInModal />
            </li>
          </ul>
        </nav>
      </div>
      <div className="content">
        <Outlet />
      </div>
      <Footer />
    </>
  );
}

export default NavBar;
