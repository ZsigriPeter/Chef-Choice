import {Link, Outlet} from 'react-router-dom';
import Footer from '../Footer';
import LogInModal from "../loginmodal/LogInModal";
import logo from '../Mask group.png';
import styles from "./NavBar.module.css";
import {useUser} from "../../context/UserProvider";
import {useState} from "react";

function NavBar() {
    const {logout} = useUser();
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [isOpen, setIsOpen] = useState(false);

    const changeIsLoggedIn = () => {
        setIsLoggedIn(true);
    }

    const toggleMenu = () => {
        setIsOpen(!isOpen);
    }

    return (
        <>
            <div className={styles.navbar}>
                <nav className={styles.nav}>
                    <Link to={"/"}>
                        <img src={logo} className={styles.logo} alt="logo of the webpage"></img>
                    </Link>
                    <button className={styles.hamburger} onClick={toggleMenu}>
                        ☰
                    </button>
                    <ul className={`${styles.navLinks} ${isOpen ? styles.navLinksOpen : ''}`}>
                        <li><Link to="/weekly-menu">Weekly menu</Link></li>
                        <li><Link to="/food-list">Food list</Link></li>
                        <li><Link to="/">Orders</Link></li>
                        <li><Link to="/">Favorites</Link></li>
                        <li><Link to="/user-profile">User profile</Link></li>
                        <li><Link to={"/admin"}>Admin</Link></li>
                        {isLoggedIn ?
                        <li><Link to={"/"} onClick={()=>{
                            logout();
                            setIsLoggedIn(false);
                        }}>Log out</Link></li>
                        :
                            <li><LogInModal onLogin={changeIsLoggedIn}/></li>}
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