import {Link, Outlet} from 'react-router-dom';
import Footer from './Footer';
import LogInModal from "./LogInModal";
import logo from './Mask group.png';
import {useUser} from "../context/UserProvider";
import {useEffect, useState} from "react";

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
    const {user} = useUser();
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
                        <li><Link to="/user-profile">User profile</Link></li>
                        {hasAdminRole ?
                            <li>< Link to={"/admin"}>Admin</Link></li>
                            :
                            <></>
                        }
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