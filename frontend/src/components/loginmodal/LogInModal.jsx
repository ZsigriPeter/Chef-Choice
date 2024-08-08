import {useState} from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import styles from './LoginModal.module.css';

import {Link, useNavigate} from "react-router-dom";
import {useUser} from "../../context/UserProvider";


/*async function fetchLogIn(userData) {
    console.log(userData)
    const res = await fetch("/api/public/login", {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(userData)
    });
    return res;
}*/

function LogInModal({onLogin}) {
    const [show, setShow] = useState(false);
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [memberData, setMemberData] = useState(null);
    const {user, login, logout} = useUser();

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const navigate = useNavigate();


    const handleLogin = () => {
        const userData = {
            username,
            password
        };
        login(userData);
        onLogin(true);
    }

    return (
        <div className="log-in-component">
            <Link className={styles.pagebutton} onClick={handleShow} to="">
                Log In
            </Link>

            <Modal className={styles.modal} show={show} onHide={handleClose}>
                <Modal.Header closeButton={true}>
                    <Modal.Title>User Login</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group className="mb-3">
                            <Form.Label>Username:</Form.Label><br/>
                            <Form.Control
                                placeholder="username"
                                autoFocus
                                value={username}
                                onChange={(e) => setUsername(e.target.value)}
                                controlId="exampleForm.ControlInput1"
                            />
                            <Form.Label>Password:</Form.Label><br/>
                            <Form.Control
                                type={"password"}
                                placeholder="password"
                                autoFocus
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                controlId="exampleForm.ControlInput2"
                            />

                        </Form.Group>
                        {
                            memberData ? (
                                <p>
                                    Greetings {memberData.firstName} {memberData.lastName}
                                </p>
                            ) : (
                                <p>
                                    You are not Logged in.
                                </p>
                            )
                        }
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={() => {
                        handleLogin();
                        navigate("/");
                        setShow(false);
                    }}>
                        Log In
                    </Button>
                    <button onClick={() => {
                        navigate("/sign-up");
                        handleClose();
                    }}>
                        Sign Up
                    </button>
                </Modal.Footer>
            </Modal>
        </div>
    );
}

export default LogInModal;