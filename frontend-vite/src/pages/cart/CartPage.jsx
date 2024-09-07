import style from './Cart.module.css';
import {useEffect, useState} from "react";
import CartItem from "../../components/cartcomponent/CartItem";
import {useNavigate} from "react-router-dom";

function Cart() {
    const [cartItems, setCartItems] = useState([]);

    const navigate = useNavigate();

    useEffect(() => {
        setCartItems(JSON.parse(localStorage.getItem("orders")));
    }, []);

    function changeOrderAmount(menuItemId, menuItemAmount) {
        const updatedOrders = cartItems.filter(order => order.menuItemId !== menuItemId);
        if (menuItemAmount > 0) {
            const food = {menuItemId, menuItemAmount};
            updatedOrders.push(food);
        }
        setCartItems([...updatedOrders]);
        localStorage.setItem("orders", JSON.stringify(updatedOrders));
    }

    function cartSubmit(e) {
        e.preventDefault();
        navigate('/order');
    }

    return (
        <div className={style.CartList}>
            {cartItems && cartItems.length > 0 ?
                <form onSubmit={(e) => cartSubmit(e)}>
                    {cartItems.map((item) => (
                        <CartItem key={item.menuItemId} menuItemId={item.menuItemId}
                                  menuItemAmountParam={item.menuItemAmount}
                                  onChangeOrder={changeOrderAmount}/>
                    ))}
                    <button type="submit" className={style.submitButton}>Order</button>
                </form> : <div><h3>No item in the cart</h3></div>
            }
        </div>
    );
}

export default Cart;