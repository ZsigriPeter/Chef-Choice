import style from './OrderPage.module.css';
import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {useUser} from "../../context/UserProvider";

async function fetchMenuItemById(Id) {
    const res = await fetch(`/api/menu-item?id=${Id}`);
    return res.json();
}

const postOrder = (orderInformation) => {
    return fetch("/api/order",
        {
            method: "POST",
            headers:
                {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${localStorage.getItem("token")}`
                },
            body: JSON.stringify(orderInformation)
        }
    ).then(res => res.json());
}

function OrderPage() {
    const [orderItems, setOrderItems] = useState([]);
    const [orderList, setOrderList] = useState([]);
    const [streetAndHouseNumber, setStreetAndHouseNumber] = useState("");
    const [settlement, setSettlement] = useState("");
    const [country, setCountry] = useState("");
    const [ZIP, setZIP] = useState(0);

    const {user} = useUser();

    const navigate = useNavigate();

    useEffect(() => {
        async function fetchOrders() {
            const savedOrders = JSON.parse(localStorage.getItem("orders")) || [];
            setOrderItems(savedOrders);
            const orderListData = await Promise.all(
                savedOrders.map(async (item) => {
                    const menuItem = await fetchMenuItemById(item.menuItemId);
                    menuItem.amount = item.menuItemAmount;
                    return menuItem;
                })
            );
            setOrderList(orderListData);
        }

        fetchOrders();
        setStreetAndHouseNumber(user.addressDTO.streetAndHouseNumber);
        setZIP(user.addressDTO.ZIP);
        setSettlement(user.addressDTO.settlement);
        setCountry(user.addressDTO.country);
    }, []);


    function orderSubmit(e) {
        e.preventDefault();
        const orderInformation = {
            username: user.username,
            country: country,
            settlement: settlement,
            zipCode: ZIP,
            streetAndHouseNumber: streetAndHouseNumber,
        }
        orderInformation.dishList = orderList.map((item) => {
            const foodList = {
                menuItemId: item.id,
                quantity: item.amount,
            }
            return foodList;
        })
        postOrder(orderInformation);
    }

    function calculateTotalPrice(pricesArray) {
        const sum = pricesArray.reduce((accumulator, currentValue) => {
            return accumulator + currentValue.dish.price * currentValue.amount;
        }, 0);
        return sum;
    }

    return (
        <div className={style.BackGroundDiv}>
            <div className={style.OrderDiv}>
                {orderItems && orderItems.length > 0 ?
                    <>
                        <table className={style.OrderTable}>
                            <tbody>
                            <tr>
                                <th className={style.TableCell}>Food Item Name</th>
                                <th className={style.TableCell}>Amount</th>
                                <th className={style.TableCell}>Date</th>
                                <th className={style.TableCell}>Price/Item</th>
                                <th className={style.TableCell}>Item Total</th>
                            </tr>
                            {orderList.map((item) => (
                                <tr key={item.id}>
                                    <td className={style.TableCell}>{item.dish.name}</td>
                                    <td className={style.TableCell}>{item.amount}</td>
                                    <td className={style.TableCell}>{item.dateOfDelivery}</td>
                                    <td className={style.TableCell}>{item.dish.price} €</td>
                                    <td className={style.TableCell}>{item.dish.price * item.amount} €</td>
                                </tr>
                            ))}
                            </tbody>
                        </table>
                        <div className={style.FinalPrize}>
                            <h3>Final Prize: {calculateTotalPrice(orderList)} €</h3>
                        </div>
                        <form onSubmit={(e) => orderSubmit(e)}>
                            <div className={style.OrderAddressForm}>
                                <p>Delivery Address:</p>
                                <label htmlFor="streetAndHouseNumber">Street And House Number</label><br/>
                                <input className={style.AddressInput} required={true} name="streetAndHouseNumber"
                                       id="streetAndHouseNumber" type="text"
                                       placeholder="Street And House Number" value={streetAndHouseNumber}
                                       onChange={e => setStreetAndHouseNumber(e.target.value)}/><br/>
                                <label htmlFor="settlement">Settlement</label><br/>
                                <input className={style.AddressInput} required={true} name="settlement" id="settlement"
                                       type="text"
                                       placeholder="Settlement" value={settlement}
                                       onChange={e => setSettlement(e.target.value)}/><br/>
                                <label htmlFor="country">Country</label><br/>
                                <input className={style.AddressInput} required={true} name="country" id="country"
                                       type="text" placeholder="Country"
                                       value={country}
                                       onChange={e => setCountry(e.target.value)}/><br/>
                                <label htmlFor="ZIP">ZIP</label><br/>
                                <input className={style.AddressInput} required={true} name="ZIP" id="ZIP" type="number"
                                       placeholder="ZIP" value={ZIP}
                                       onChange={e => setZIP(e.target.value)}/><br/>
                                <button type="submit" className={style.submitButton}>Order</button>
                                <button className={style.submitButton} onClick={() => navigate('/cart')}>Back To Cart
                                </button>
                            </div>
                        </form>
                    </> : <div><h3>No item in the cart</h3></div>
                }
            </div>
        </div>
    );
}

export default OrderPage;