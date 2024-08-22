import style from './Cart.module.css';
import {useEffect, useState} from "react";
import CartItem from "../../components/cartcomponent/CartItem";

function Cart() {
    const [cartItems, setCartItems] = useState(false);

    useEffect(() => {
        setCartItems(JSON.parse(localStorage.getItem("orders")));
        console.log(cartItems);
    }, []);

    return (
        <div className={style.CartList}>
            {cartItems ?
                <form onSubmit={(e) => e.preventDefault()}>
                    {cartItems.map((item) => (
                        <CartItem key={item.menuItemId} menuItemId={item.menuItemId}
                                  menuItemAmountParam={item.menuItemAmount}/>
                    ))}
                    <button type="submit" className={style.submitButton}>Order</button>
                </form>:<div></div>
            }
        </div>
    );
}

export default Cart;