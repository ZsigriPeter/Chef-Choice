import {useEffect, useState} from "react";
import DishList from "./DishList";
import MenuRow from "./MenuRow";

const fetchMenuOfTheWeek = () => {
    return fetch(`/weekly-menu`).then((res) => res.json());
}

function WeeklyMenu() {
    const [menu, setMenu] = useState(null);

    useEffect(() => {
        fetchMenuOfTheWeek().then((menu) => {
            setMenu(menu)
        });
    });

    return (
        <div>{menu && menu.map((menuRow) => {
            <MenuRow menuRow={menuRow}/>
        })}
        </div>
    )
}

export default WeeklyMenu