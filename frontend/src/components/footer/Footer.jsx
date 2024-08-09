import {Link} from "react-router-dom";
import styles from "./Footer.module.css";
import {useState} from "react";

function Footer() {
    const [isOpen, setIsOpen] = useState(false);


    const toggleMenu = () => {
        setIsOpen(!isOpen);
    }

    return (
            <footer className={styles.footer}>
                <nav className={styles.footerNavBar}>
                    <button className={styles.hamburger} onClick={toggleMenu}> ☰</button>
                    <ul className={`${styles.footerLinks} ${isOpen ? styles.footerLinksOpen : ''}`}>
                        <li><Link to="/main">FAQ</Link></li>
                        <li><Link to="/">Ordering details</Link></li>
                        <li><Link to="/">Terms and conditions</Link></li>
                    </ul>
                </nav>
                <div className={styles.contacts}>
                    <div className={styles.contactUs}>
                        <span>Contact us: </span>
                    </div>
                    <div className={styles.mailPhone}>
                        <span>contact@mail.com</span>
                        <br/>
                        <span>+36 20 5556677</span>
                    </div>
                </div>
            </footer>
    );
}

export default Footer;