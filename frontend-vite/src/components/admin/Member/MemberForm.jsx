import {useState} from "react";

const MemberForm = ({member, onCancel, onSave}) => {
    const [disabled, setDisabled] = useState(true)
    const [userName, setUserName] = useState(member?.username ?? "");
    const [email, setEmail] = useState(member?.email ?? "");
    const [firstName, setFirstName] = useState(member?.firstName ?? "");
    const [lastName, setLastName] = useState(member?.lastName ?? "");
    const [phone, setPhone] = useState(member?.phone ?? "");
    const [streetAndHouseNumber, setStreetAndHouseNumber] = useState(member?.addressDTO?.streetAndHouseNumber ?? "");
    const [settlement, setSettlement] = useState(member?.addressDTO?.settlement ?? "");
    const [country, setCountry] = useState(member?.addressDTO?.country ?? "");
    const [ZIP, setZIP] = useState(member?.addressDTO?.ZIP ?? "");

    const onSubmit = (e) => {
        e.preventDefault();
        return onSave({
            ...member,
            userName,
            email,
            firstName,
            lastName,
            phone,
            addressDTO: {
                streetAndHouseNumber,
                settlement,
                country,
                ZIP
            }
        })

    }

    return <>
        <form onSubmit={onSubmit} onChange={()=> setDisabled(false)}>
            <h3>Update member data for member ID={member.id}</h3>

            <div>
                <label htmlFor="userName">userName:</label>
                <input
                    value={userName}
                    onChange={(e) => setUserName(e.target.value)}
                    name="userName"
                    id="userName"
                />
            </div>

            <div>
                <label htmlFor="email">email:</label>
                <input
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    name="email"
                    id="email"
                />
            </div>

            <div>
                <label htmlFor="firstName">firstName:</label>
                <input
                    value={firstName}
                    onChange={(e) => setFirstName(e.target.value)}
                    name="firstName"
                    id="firstName"
                />
            </div>

            <div>
                <label htmlFor="lastName">lastName:</label>
                <input
                    value={lastName}
                    onChange={(e) => setLastName(e.target.value)}
                    name="lastName"
                    id="lastName"
                />
            </div>

            <div>
                <label htmlFor="phone">phone:</label>
                <input
                    value={phone}
                    onChange={(e) => setPhone(e.target.value)}
                    name="phone"
                    id="phone"
                />
            </div>

            <h4>Address:</h4>
            <div>
                <label htmlFor="streetAndHouseNumber">streetAndHouseNumber:</label>
                <input
                    value={streetAndHouseNumber}
                    onChange={(e) => setSettlement(e.target.value)}
                    name="streetAndHouseNumber"
                    id="streetAndHouseNumber"
                />
            </div>

            <div>
                <label htmlFor="settlement">settlement:</label>
                <input
                    value={settlement}
                    onChange={(e) => setSettlement(e.target.value)}
                    name="settlement"
                    id="settlement"
                />
            </div>

            <div>
                <label htmlFor="country">country:</label>
                <input
                    value={country}
                    onChange={(e) => setCountry(e.target.value)}
                    name="country"
                    id="country"
                />
            </div>

            <div>
                <label htmlFor="ZIP">ZIP:</label>
                <input
                    value={ZIP}
                    onChange={(e) => setZIP(e.target.value)}
                    name="ZIP"
                    id="ZIP"
                />
            </div>

            <br></br>
            <div>
                <button type="submit" disabled={disabled} style={{backgroundColor: "red"}}>
                    {member ? "Update Member" : "Create Member"}
                </button>

                <button type="button" onClick={onCancel}>
                    Cancel
                </button>
            </div>

        </form>
    </>
}

export default MemberForm;