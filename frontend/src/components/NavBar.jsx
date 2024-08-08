import {Link, Outlet} from 'react-router-dom';
import Footer from './Footer';
import LogInModal from "./LogInModal";
import logo from './Mask group.png'
import cart from './shopping-cart.png'
import './NavBar.css'

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
                        <li><Link to="/cart"><img src={cart} className="icon" alt="Cart"/></Link></li>
                        <li><Link to="/food-list">Food list</Link></li>
                        <li><Link to="/">Favorites</Link></li>
                        <li><Link to="/user-profile">User profile</Link></li>
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