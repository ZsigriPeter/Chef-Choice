import styles from './CartItem.module.css';
import {useEffect, useState} from "react";


async function fetchFoodItemById(Id) {
    const res = await fetch(`/api/public/food?id=${Id}`);
    return res.json();
}

function CartItem({ foodItemId, foodItemAmountParam }) {
    const [foodItem, setFoodItem] = useState("");
    const [foodItemAmount, setFoodItemAmount] = useState(foodItemAmountParam);

    useEffect(() => {
        console.log(foodItemId);
        console.log(foodItemAmountParam);
        fetchFoodItemById(foodItemId)
            .then((result) => {
                setFoodItem(result);
                console.log(result);
                console.log(foodItemAmount);
            })
    }, [foodItemId]);

    useEffect(() => {
        setFoodItemAmount(foodItemAmountParam);
    }, [foodItemAmountParam]);

    return (
        <>
            {foodItemAmount>0&&
            <div className={styles.CartItem} key={foodItemId}>
                <label className={styles.ItemName} htmlFor={foodItem}>{foodItem.name}</label>
                <input className={styles.ItemAmount} value={foodItemAmount} type="number" onChange={e => setFoodItemAmount(e.target.value)}/>
            </div>}
        </>
    );
}

export default CartItem;