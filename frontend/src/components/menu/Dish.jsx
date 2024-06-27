import DishAllergenList from "./DishAllergenList";

function Dish({dish}) {
    return (
        <div className="dishDiv">
            <h4 className={"dishName"}>{dish.name}</h4>
            <p className={"dishDescription"}>{dish.description}</p>
            <h4 className={"dishPrice"}>{dish.price} Ft</h4>
            {/*<div>
                <DishAllergenList allergenList={dish.allergens}/>
            </div>*/}
            <input className={"amountInput"} type={"number"} min={0} max={100}/>
        </div>
    )
}
export default Dish