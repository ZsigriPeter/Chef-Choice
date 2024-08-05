import {Link, Outlet} from 'react-router-dom';
import Footer from './Footer';
import LogInModal from "./LogInModal";
import {hasPointerEvents} from "@testing-library/user-event/dist/utils";
import AdminNavBar from "./admin/AdminNavBar";
import logo from './Mask group.png';

function NavBar() {

    return (
        <>
            <div className="nav-bar">
                <nav>
                    <Link to={"/"}>
                        <img src={logo} className="logo-img" alt="logo of the webpage"></img>
                    </Link>
                    <ul className="nav-links">
                        <li><a href="/weekly-menu">Weekly menu</a></li>
                        <li><a href="/food-list">Food list</a></li>
                        <li><a href="/">Orders</a></li>
                        <li><a href="/">Favorites</a></li>
                        <li><a href="/">User profile</a></li>
                        <li>
                            <Link to={"/admin"}>Admin</Link>
                        </li>
                        <li><LogInModal/></li>
                    </ul>
                </nav>
            </div>
            <div className="content">
                <Outlet/>
            </div>
            <Footer/>
        </>
    );
}

export default NavBar;