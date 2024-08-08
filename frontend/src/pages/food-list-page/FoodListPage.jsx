import {useEffect, useState} from "react";
import DishList from "../../components/menu/DishList";

function fetchFoodList() {
    return fetch("/api/public/food-list").then(res => res.json());
}

function FoodListPage() {
    const [foodList, setFoodList] = useState([]);

    useEffect(()=> {
        fetchFoodList().then(foodList => setFoodList(foodList.sort((a, b)=> a.name < b.name ? -1 : 1))) //TODO sort
    },[])

    return (
        <div>
            <DishList dishes={foodList}/>
        </div>
    )
}

export default FoodListPage;