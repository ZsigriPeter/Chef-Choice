import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import {Link, useNavigate} from "react-router-dom";

async function fetchLogIn(userData) {
    console.log(userData)
    const res = await fetch("/api/public/login", {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(userData)
    });
    return res;
}

function LogInModal() {
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const navigate = useNavigate();
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [memberData,setMemberData] = useState(null)

    async function OnLogin() {
        const userData = {
            username,
            password
        };

        try {
            const result = await fetchLogIn(userData);
            const data = await result.json();
            setMemberData(data);
            console.log("result");
            console.log(data);
            console.log(memberData);
        } catch (error) {
            console.error('Error logging in:', error);
        }
    }

    return (
        <div className="log-in-component">
            <Link className="page-button" onClick={handleShow} to="">
                Log In
            </Link>

            <Modal className="login-modal" show={show} onHide={handleClose}>
                <Modal.Header closeButton={true}>
                    <Modal.Title>User Login</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Username:</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Username"
                                autoFocus
                                value={username}
                                onChange={(e) => setUsername(e.target.value)}
                            />
                            <br/>
                            <Form.Label>Password:</Form.Label>
                            <Form.Control
                                type="password"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                            />
                        </Form.Group>
                        {
                            memberData ? (
                                <p >
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
                    <Button variant="secondary" onClick={()=> {OnLogin();
                        if(memberData) {
                            navigate('/');
                        }
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