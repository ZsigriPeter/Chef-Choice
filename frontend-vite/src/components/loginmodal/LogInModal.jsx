import {useState} from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import styles from './LoginModal.module.css';

import {Link, useNavigate} from "react-router-dom";
import {useUser} from "../../context/UserProvider";


function LogInModal({onLogin, onToggle}) {
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
        onLogin();
    }

    return (
        <div className={styles.loginComponent}>
            <Link className={styles.pageButton} onClick={() => {
                handleShow();
                onToggle();
            }} to="">
                Log In
            </Link>

            <Modal className={styles.modal} show={show} onHide={handleClose}>
                <Modal.Header className={styles.header}>
                    <Modal.Title className={styles.title}>User Login</Modal.Title>
                    <button type="button" className={styles.closeButton} aria-label="Close" onClick={handleClose}>X
                    </button>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group className="mb-3">
                            <Form.Label>Username:</Form.Label><br/>
                            <Form.Control
                                className={styles.input}
                                placeholder="username"
                                autoFocus
                                value={username}
                                onChange={(e) => setUsername(e.target.value)}
                                controlId="exampleForm.ControlInput1"
                            /><br/>
                            <Form.Label>Password:</Form.Label><br/>
                            <Form.Control
                                className={styles.input}
                                type={"password"}
                                placeholder="password"
                                autoFocus
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                controlId="exampleForm.ControlInput2"
                            /><br/>

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
                <Modal.Footer className={styles.footer}>
                    <Button
                        className={styles.modalButton1}
                        variant="secondary"
                        onClick={() => {
                            handleLogin();
                            navigate("/");
                            setShow(false);
                        }}
                    >
                        Log In
                    </Button>
                    <Button
                        className={styles.modalButton2}
                        onClick={() => {
                            navigate("/sign-up");
                            handleClose();
                        }}
                    >
                        Sign Up
                    </Button>
                </Modal.Footer>
            </Modal>
        </div>
    );
}

export default LogInModal;