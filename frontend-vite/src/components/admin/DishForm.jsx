import {useState} from "react";
import dish from "../menu/Dish.jsx";

async function addNewDish(dish) {
    const token = localStorage.getItem("token");
    console.log(dish)
    await fetch("/api/admin/dish", {
        method: "POST",
        headers: {
            'Authorization': `Bearer ${token}`,
            "Content-Type":"application/json"
        },
        body: JSON.stringify(dish)
    })
}

function DishForm() {
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const [price, setPrice] = useState(0);
    const [allergens, setAllergens] = useState([]);


    const addAllergenField = () => {
        let newAllergen = {name: '', number: ''}
        setAllergens([...allergens, newAllergen])
    }

    const handleAllergensChange = (index, e) => {
        let data = [...allergens];
        data[index][e.target.name] = e.target.value;
        setAllergens(data);
    }

    const onSubmit = (e) => {
        e.preventDefault();
        const dish = {name, description, price, allergens}
        addNewDish(dish)
    }
    return <>
        <form onSubmit={onSubmit}>
            <div>
                <label>Dish name:<br/>
                    <input
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        name="name"
                        id="name"
                    /><br/>
                </label>
                <label>Description:<br/>
                    <input
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                        name="description"
                        id="description"
                    /><br/>
                </label>
                <label>Price:<br/>
                    <input
                        type={"number"}
                        step={"0.1"}
                        value={price}
                        onChange={(e) => setPrice(e.target.value)}
                        name="price"
                        id="price"
                    /><br/>
                </label>
                {allergens.map((input, index) => {
                    return (<>
                            <div key={index}>
                                <label>Allergen name:<br/>
                                    <input
                                        value={input.name}
                                        onChange={(e) => handleAllergensChange(index, e)}
                                        name="name"
                                        id="name"
                                    /><br/>
                                </label>
                                <label>Allergen number:<br/>
                                    <input
                                        value={input.number}
                                        type={"number"}
                                        onChange={(e) => handleAllergensChange(index, e)}
                                        name="number"
                                        id="number"
                                    /><br/>
                                </label>
                                <button>-</button>
                            </div>
                        </>
                    )
                })
                }
                <button type={"button"} onClick={addAllergenField}>Add allergen</button>
            </div>
            <div>

                <input type={"submit"} value={"Add dish"}/>
            </div>
        </form>
    </>
}

export default DishForm;