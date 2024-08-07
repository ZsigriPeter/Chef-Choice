import {Link, Outlet} from 'react-router-dom';
import Footer from './Footer';
import LogInModal from "./LogInModal";
import {hasPointerEvents} from "@testing-library/user-event/dist/utils";
import logo from './Mask group.png'

function NavBar() {

    return (
        <>
            <div className="nav-bar">
                <nav>
                    <Link to={"/"}>
                        <img src={logo} className="logo-img" alt="logo of the webpage"></img>
                    </Link>
                    <ul className="nav-links">
                        <li><Link to="/weekly-menu">Weekly menu</Link></li>
                        <li><Link to="/food-list">Food list</Link></li>
                        <li><Link to="/">Orders</Link></li>
                        <li><Link to="/">Favorites</Link></li>
                        <li><Link to="/">User profile</Link></li>
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