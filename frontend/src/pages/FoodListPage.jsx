import {useEffect, useState} from "react";
import DishList from "../components/menu/DishList";

function fetchFoodList() {
    return fetch("/food-list").then(res => res.json());
}

function FoodListPage() {
    const [foodList, setFoodList] = useState([]);

    useEffect(()=> {
        console.log("FoodList page useEffect")
        fetchFoodList().then(foodList => setFoodList(foodList)) //TODO sort
    },[])

    return (
        <div>
            <DishList dishes={foodList}/>
        </div>
    )
}

export default FoodListPage;