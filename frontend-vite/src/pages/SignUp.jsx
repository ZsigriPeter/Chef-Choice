import {useState} from "react";
import {useNavigate} from "react-router-dom";

async function postNewUser(userData) {
    const res = await fetch("/api/signup", {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(userData)
    });
    return res;
}


function SignUp() {

    const navigate = useNavigate();

    const [email, setEmail] = useState("");
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [phone, setPhone] = useState("");
    const [streetAndHouseNumber, setStreetAndHouseNumber] = useState("");
    const [settlement, setSettlement] = useState("");
    const [country, setCountry] = useState("");
    const [zipCode, setZipCode] = useState(0);
    const [username, setUsername] = useState("");
    const [password1, setPassword1] = useState("");
    const [password2, setPassword2] = useState("");
    const [passwordError, setPasswordError] =useState(false);

    const onSubmit = (e) => {
        e.preventDefault();
        let password = "";
        if (password1 === password2) {
            password = password1;
            const userData = {
                username,
                password,
                email,
                firstName,
                lastName,
                phone,
                streetAndHouseNumber,
                settlement,
                country,
                zipCode
            }
            postNewUser(userData).then(
                navigate('/')
            );
        } else {
            setPasswordError(true);
        }
    };

    return (
        <div className="sign-up">
            <form onSubmit={onSubmit}>
                <label htmlFor="username">Username</label><br/>
                <input required={true} name="username" id="username" type="text" placeholder="Username" value={username}
                       onChange={e => setUsername(e.target.value)}/><br/>
                <label htmlFor="password1">Password</label><br/>
                <input required={true} name="password1" id="password1" type="password" value={password1}
                       onChange={e => setPassword1(e.target.value)}/><br/>
                {passwordError&& <p>Repeated password is not the same</p>}
                <label htmlFor="password2">Password Again</label><br/>
                <input required={true} name="password2" id="password2" type="password" value={password2}
                       onChange={e => setPassword2(e.target.value)}/><br/>
                <label htmlFor="email">Email</label><br/>
                <input required={true} name="email" id="email" type="email" placeholder="Email" value={email}
                       onChange={e => setEmail(e.target.value)}/><br/>
                <label htmlFor="firstName">First Name</label><br/>
                <input required={true} name="firstName" id="firstName" type="text" placeholder="First Name" value={firstName}
                       onChange={e => setFirstName(e.target.value)}/><br/>
                <label htmlFor="lastName">Last Name</label><br/>
                <input required={true} name="lastName" id="lastName" type="text" placeholder="Last Name" value={lastName}
                       onChange={e => setLastName(e.target.value)}/><br/>
                <label htmlFor="phone">Phone</label><br/>
                <input required={true} name="phone" id="phone" type="text" placeholder="Phone" value={phone}
                       onChange={e => setPhone(e.target.value)}/><br/>
                <div className="address-sign-up"><br/>
                    <p>Address:</p>
                    <label htmlFor="streetAndHouseNumber">Street And House Number</label><br/>
                    <input required={true} name="streetAndHouseNumber" id="streetAndHouseNumber" type="text"
                           placeholder="Street And House Number" value={streetAndHouseNumber}
                           onChange={e => setStreetAndHouseNumber(e.target.value)}/><br/>
                    <label htmlFor="settlement">Settlement</label><br/>
                    <input required={true} name="settlement" id="settlement" type="text" placeholder="Settlement" value={settlement}
                           onChange={e => setSettlement(e.target.value)}/><br/>
                    <label htmlFor="country">Country</label><br/>
                    <input required={true} name="country" id="country" type="text" placeholder="Country" value={country}
                           onChange={e => setCountry(e.target.value)}/><br/>
                    <label htmlFor="ZIP">ZIP</label><br/>
                    <input required={true} name="ZIP" id="ZIP" type="number" placeholder="ZIP" value={zipCode}
                           onChange={e => setZipCode(e.target.value)}/><br/>
                </div>
                <br/>
                <button type="submit">Sign Up</button>
            </form>
        </div>
    );
}

export default SignUp;