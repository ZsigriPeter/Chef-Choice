import style from './Cart.module.css';
import {useEffect, useState} from "react";
import CartItem from "../../components/cartItem/CartItem";

function Cart() {
    const [cartItems, setCartItems] = useState([]);

    useEffect(() => {
        setCartItems(JSON.parse(localStorage.getItem("orders")));
        console.log(cartItems);
    }, []);

    return (
        <div className={style.CartList}>
            {cartItems&&
            <form onSubmit={e => e.preventDefault()}>
                {cartItems.map((item) => (
                    <CartItem key={item.menuItemId} menuItemId={item.menuItemId}
                              menuItemAmountParam={item.menuItemAmount} />
                ))}
                <button type="submit">Order</button>
            </form> }
        </div>
    );
}

export default Cart;