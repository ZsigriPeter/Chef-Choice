import {Outlet} from 'react-router-dom';
import Footer from './Footer';
import {hasPointerEvents} from "@testing-library/user-event/dist/utils";

function NavBar() {

    return (
        <>
            <div className="nav-bar">
                <nav>
                    <img src="" className="logo-img" alt="logo of the webpage"></img>
                    <ul className="nav-links">
                        <li><a href="/weekly-menu">Weekly menu</a></li>
                        <li><a href="/">Food list</a></li>
                        <li><a href="/">Orders</a></li>
                        <li><a href="/">Favorites</a></li>
                        <li><a href="/">User profile</a></li>
                        <li><a href="/">Log In</a></li>
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