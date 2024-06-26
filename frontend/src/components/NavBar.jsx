import {Outlet} from 'react-router-dom';

function NavBar() {

    return (
        <>
            <div className="nav-bar">
                <nav>
                    <img src="" className="logo-img" alt="logo of the webpage"></img>
                    <ul className="nav-links">
                        <li><a href="/main">Weekly menu</a></li>
                        <li><a href="/">Food list</a></li>
                        <li><a href="/">FAQ</a></li>
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
        </>

    );
}

export default NavBar;