import {useEffect, useState} from "react";
import styles from "./DishForm.module.css"

const addNewDish = (dish) => {
    const token = localStorage.getItem("token");
    fetch("/api/admin/dish", {
        method: "POST",
        headers: {
            'Authorization': `Bearer ${token}`,
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dish)
    });
}

const getAllAllergens = () => {
    return fetch("/api/allergen/all", {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).then((res) => res.json());
}


function DishForm() {
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const [price, setPrice] = useState(0);
    const [allergen, setAllergen] = useState("");
    const [allergens, setAllergens] = useState([]);
    const [allAllergen, setAllAllergen] = useState([]);


    const addAllergenField = () => {
        setAllergens([...allergens, allergen])
    }
    const removeAllergenField = (index) => {
        let data = [...allergens];
        data.splice(index, 1)
        setAllergens(data)
    }

    const handleAllergensChange = (index, e) => {
        let data = [...allergens];
        data[index] = e.target.value;
        setAllergens(data);
        console.log(data)
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        const dish = {name, description, price, allergens}
        addNewDish(dish)
    }

    useEffect(() => {
        getAllAllergens().then((allergenList) => setAllAllergen(allergenList));
    }, []);

    return <>
        <form onSubmit={handleSubmit}>
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
                                <select onChange={(e)=>handleAllergensChange(index, e)}>
                                    {allAllergen && allAllergen.map((allergen) => <option>{allergen.name}</option>)}
                                </select>
                                <button onClick={() => removeAllergenField(index)}
                                        className={styles.deleteAllergenButton}>-
                                </button>
                            </div>
                        </>
                    )})
                }
                <button type={"button"} onClick={addAllergenField} className={styles.addAllergenButton}>Add allergen to dish
                </button>
            </div>
            <div>
                <input type={"submit"} value={"Add dish"} className={styles.submitInput}/>
            </div>
        </form>
    </>
}

export default DishForm;