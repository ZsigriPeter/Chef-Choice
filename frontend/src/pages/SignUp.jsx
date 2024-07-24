import {useState} from "react";

async function postNewUser(userData) {
    console.log(userData)
    const res = await fetch("/signup", {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(userData)
    });
    return res;
}


function SignUp() {

    const [email, setEmail] = useState("");
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [phone, setPhone] = useState("");
    const [streetAndHouseNumber, setStreetAndHouseNumber] = useState("");
    const [settlement, setSettlement] = useState("");
    const [country, setCountry] = useState("");
    const [ZIP, setZIP] = useState("");

    const onSubmit = (e) => {
        e.preventDefault();
        const  userData= {
            email,
            firstName,
            lastName,
            phone,
            streetAndHouseNumber,
            settlement,
            country,
            ZIP
        }
        postNewUser(userData);
    };

    return (
        <div className="sign-up">
            <form onSubmit={onSubmit}>
                <label htmlFor="email">Email</label>
                <input name="email" id="email" type="email" placeholder="Email" value={email} onChange={e => setEmail(e.target.value)}/>
                <label htmlFor="firstName">First Name</label>
                <input name="firstName" id="firstName" type="text" placeholder="First Name" value={firstName} onChange={e => setFirstName(e.target.value)}/>
                <label htmlFor="lastName">Last Name</label>
                <input name="lastName" id="lastName" type="text" placeholder="Last Name" value={lastName} onChange={e => setLastName(e.target.value)}/>
                <label htmlFor="phone">Phone</label>
                <input name="phone" id="phone" type="text" placeholder="Phone" value={phone} onChange={e => setPhone(e.target.value)}/>
                <div className="address-sign-up">
                    <p>Address:</p>
                    <label htmlFor="streetAndHouseNumber">Street And House Number</label>
                    <input name="streetAndHouseNumber" id="streetAndHouseNumber" type="text"
                           placeholder="Street And House Number" value={streetAndHouseNumber} onChange={e => setStreetAndHouseNumber(e.target.value)}/>
                    <label htmlFor="settlement">Settlement</label>
                    <input name="settlement" id="settlement" type="text" placeholder="Settlement" value={settlement} onChange={e => setSettlement(e.target.value)}/>
                    <label htmlFor="country">Country</label>
                    <input name="country" id="country" type="text" placeholder="Country" value={country} onChange={e => setCountry(e.target.value)}/>
                    <label htmlFor="ZIP">ZIP</label>
                    <input name="ZIP" id="ZIP" type="number" placeholder="ZIP" value={ZIP} onChange={e => setZIP(e.target.value)}/>
                </div>
                <button type="submit">Sign Up</button>
            </form>
        </div>
    );
}

export default SignUp;