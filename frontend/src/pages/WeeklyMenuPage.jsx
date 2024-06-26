import SideMenuBar from "../components/SideMenuBar";
import WeeklyMenu from "../components/menu/WeeklyMenu";
import {useEffect, useState} from "react";
import WeekDateTab from "../components/menu/WeekDateTab";

const fetchMenuOfTheWeek = () => {
    return fetch(`/weekly-menu`).then((res) => res.json());
}

function WeeklyMenuPage() {
    const [menu, setMenu] = useState(null);

    useEffect(() => {
        fetchMenuOfTheWeek().then((menu) => {
            setMenu(menu)
        });
    }, []);


    return (<div className="weeklyMenuPage">
            <SideMenuBar/>
            {
                menu && <div className="weeklyMenu">
                    <button>
                        <WeekDateTab menu={menu}/>
                    </button>
                    <button>
                        <WeekDateTab menu={menu}/>
                    </button>
                    <button>
                        <WeekDateTab menu={menu}/>
                    </button>

                    <WeeklyMenu weeklyMenu={menu}/>
                </div>
            }
        </div>
    )
}

export default WeeklyMenuPage;