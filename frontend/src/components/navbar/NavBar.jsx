import {Link, Outlet} from 'react-router-dom';
import Footer from '../Footer';
import LogInModal from "../loginmodal/LogInModal";
import cart from './shopping-cart.png'
import styles from "./NavBar.module.css";
import {useUser} from "../../context/UserProvider";
import {useEffect, useState} from "react";
import logo from "./Mask group.png";

const fetchUserContext = (token) => {
    return fetch("api/public/context",
        {
            method: "GET",
            headers:
                {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${localStorage.getItem("token")}`
                }
        }
    ).then(res => res.json());
}

function NavBar() {
    const {user, logout} = useUser();
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [isOpen, setIsOpen] = useState(false);
    const [hasAdminRole, setHasAdminRole] = useState(false)

    useEffect(() => {
        fetchUserContext().then(resp => {
            const roles = resp.authorities.map(authority => authority.authority);
            if (roles.includes("ROLE_ADMIN")) setHasAdminRole(true);
            else setHasAdminRole(false);
        })
    }, [user])

    if (user) {
        console.log("Navbar user: " + user.username)
        console.log("Roles: " + user.roles.map(role => role.role));
    }

    console.log("HasADmin: " + hasAdminRole)

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
                        <img src={logo} className={styles.logoclass} alt="logo of the webpage"></img>
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
                        {hasAdminRole ?
                            <li>< Link to={"/admin"}>Admin</Link></li>
                            :
                            <></>
                        }
                        <li><Link style={{backgroundColor:"white"}} to="/cart"><img src={cart} className={styles.icon} alt="Cart"/></Link></li>
                        {isLoggedIn ?
                            <li><Link to={"/"} onClick={() => {
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