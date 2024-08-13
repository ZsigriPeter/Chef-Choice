import styles from './CartItem.module.css';
import {useEffect, useState} from "react";


async function fetchFoodItemById(Id) {
    const res = await fetch(`/api/public/food?id=${Id}`);
    return res.json();
}

async function fetchMenuItemById(Id) {
    const res = await fetch(`/api/public/menu-item?id=${Id}`);
    return res.json();
}

function CartItem({menuItemId, menuItemAmountParam}) {
    const [menuItem, setMenuItem] = useState("");
    const [menuItemAmount, setMenuItemAmount] = useState(menuItemAmountParam);

    useEffect(() => {
        console.log(menuItemId);
        console.log(menuItemAmountParam);
        fetchMenuItemById(menuItemId)
            .then((result) => {
                setMenuItem(result);
                console.log(result);
                console.log(menuItemAmount);
            })
    }, [menuItemId]);

    useEffect(() => {
        setMenuItemAmount(menuItemAmountParam);
    }, [menuItemAmountParam]);

    return (
        <>
            {(menuItemAmount > 0 && menuItem) &&
                <div className={styles.CartItem} key={menuItemId}>
                    <label className={styles.ItemName}
                           htmlFor={menuItem}>{menuItem.dish.name} ({menuItem.dateOfDelivery})</label>
                    <input className={styles.ItemAmount} value={menuItemAmount} type="number"
                           onChange={e => setMenuItemAmount(e.target.value)}/>
                </div>}
        </>
    );
}

export default CartItem;