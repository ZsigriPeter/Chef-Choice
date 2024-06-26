import Dish from "./Dish";

function DishList({dishes}) {
    return (<div>
        {dishes.map((dish) => {
            return (
                <Dish dish={dish}/>
            )
        })}
    </div>)
}

export default DishList