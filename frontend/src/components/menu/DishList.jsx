import Dish from "./Dish";

function DishList({dishes}){
    return (<div>
        {dishes.map((dish)=>{
            <Dish dish={dish}/>
        })}
    </div>)
}
export default DishList