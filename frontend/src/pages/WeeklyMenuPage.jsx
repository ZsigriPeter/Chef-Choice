import SideMenu from "../components/SideMenu";
import WeeklyMenu from "../components/menu/WeeklyMenu";
import {useEffect, useState} from "react";

const fetchMenuOfTheWeek = () => {
    return fetch(`/weekly-menu`).then((res) => res.json());
}

function WeeklyMenuPage() {
    const [menu, setMenu] = useState(null);

    useEffect(() => {
        fetchMenuOfTheWeek().then((menu) => {
            setMenu(menu)
        });
    });


    return (<div>
            <SideMenu/>
            <WeeklyMenu menu={menu}/>
        </div>
    )
}

export default WeeklyMenuPage;