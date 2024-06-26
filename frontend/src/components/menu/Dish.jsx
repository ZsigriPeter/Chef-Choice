import DishAllergenList from "./DishAllergenList";

function Dish({dish}) {
    return (
        <div className="dishDiv">
            <h4>{dish.name}</h4>
            <p>{dish.description}</p>
            <h4>{dish.price}</h4>
            {/*<div>
                <DishAllergenList allergenList={dish.allergens}/>
            </div>*/}
        </div>
    )
}
export default Dish