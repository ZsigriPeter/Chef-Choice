import {Link} from "react-router-dom";

function Footer() {

    return (
            <footer className="footer">
                <div className="footer-nav-bar">
                    <nav>
                        <ul className="nav-links">
                            <li><Link to="/main">FAQ</Link></li>
                            <li><Link to="/">Ordering details</Link></li>
                            <li><Link to="/">Terms and conditions</Link></li>
                        </ul>
                    </nav>
                </div>
                <div className="contacts">
                    <div>
                        <span>Contact us: </span>
                    </div>
                    <div className="mail-phone">
                        <span>contact@mail.com</span>
                        <br/>
                        <span>+36 20 5556677</span>
                    </div>
                </div>
            </footer>
    );
}

export default Footer;