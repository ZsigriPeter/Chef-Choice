function Footer() {

    return (
        <div className="footer">
            <footer className="footer">
                <div className="nav-bar">
                    <nav>
                        <ul className="nav-links">
                            <li><a href="/main">FAQ</a></li>
                            <li><a href="/">Ordering details</a></li>
                            <li><a href="/">Terms and conditions</a></li>
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
        </div>
    );
}

export default Footer;