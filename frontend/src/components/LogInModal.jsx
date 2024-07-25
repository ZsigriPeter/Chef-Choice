import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import { useNavigate } from "react-router-dom";

async function fetchLogIn(userData) {
    console.log(userData)
    const res = await fetch("/login", {
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
    const [email, setEmail] = useState("");
    const [memberData,setMemberData] = useState(null)

    async function OnLogin() {
        const userData = {
            email,
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
            <button className="page-button" onClick={handleShow}>
                Log In
            </button>

            <Modal className="login-modal" show={show} onHide={handleClose}>
                <Modal.Header closeButton={true}>
                    <Modal.Title>User Login</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Email address:</Form.Label>
                            <Form.Control
                                type="email"
                                placeholder="name@example.com"
                                autoFocus
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
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