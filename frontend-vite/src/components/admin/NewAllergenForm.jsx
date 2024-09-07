import {useState} from "react";

async function addNewAllergen(allergen) {
    const token = localStorage.getItem("token");
    await fetch("/api/admin/allergen", {
        method: "POST",
        headers: {
            'Authorization': `Bearer ${token}`,
            "Content-Type": "application/json"
        },
        body: JSON.stringify(allergen)
    })
}

function NewAllergenForm() {
    const [name, setName] = useState('');
    const [number, setNumber] = useState(0);

    const handleSubmit = (e) => {
        e.preventDefault();
        const allergen = {name, number};
        addNewAllergen(allergen);
    }

    return (<>
        <form onSubmit={handleSubmit}>
            <label>Allergen name:<br/>
                <input value={name}
                       onChange={(e) => setName(e.target.value)}
                       name="name"
                       id="name"/><br/>
            </label>
            <label>Allergen number:<br/>
                <input type={"number"}
                       value={number}
                       onChange={(e) => setNumber(e.target.value)}
                       name="number"
                       id="number"/><br/>
            </label>
            <button type={"submit"}>Add allergen</button>
        </form>
    </>)
}

export default NewAllergenForm