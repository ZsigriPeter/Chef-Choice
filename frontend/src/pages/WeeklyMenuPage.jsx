import SideMenuBar from "../components/SideMenuBar";
import WeeklyMenu from "../components/menu/WeeklyMenu";
import {useEffect, useState} from "react";
import WeekDateTab from "../components/menu/WeekDateTab";
import {useSearchParams} from "react-router-dom";

const fetchMenuOfTheWeek = (startDate) => {
    return fetch(`/weekly-menu?date=${startDate}`).then((res) => res.json());
}

function getStartDateOfCurrentWeek() {
    const currentDate = new Date(Date.now());
    const currentDayIndex = currentDate.getUTCDay();
    let actualDate = currentDate;
    let date = ""
    if (currentDayIndex > 0 && currentDayIndex < 6) {
        actualDate = new Date(currentDate.setDate(currentDate.getDate() - (currentDayIndex - 1)));
        date = `${actualDate.getUTCFullYear()}-${(currentDate.getMonth() + 1).toString().padStart(2, '0')}-${actualDate.getUTCDate()}`
    }
    return date;
}

function WeeklyMenuPage() {
    const [menu, setMenu] = useState(null);
    const [searchParams,] = useSearchParams();

    useEffect(() => {
        let date = getStartDateOfCurrentWeek();
        const startDate = searchParams.get('date')

        if (startDate) {
            date = startDate;
        }
        fetchMenuOfTheWeek(date).then((menu) => {
            setMenu(menu)
        });
    }, []);


    return (<div className="weeklyMenuPage">
            <SideMenuBar/>
            {
                menu && <div className="weeklyMenu">
                    <button className={"weekTab"}>
                        <WeekDateTab menu={menu}/>
                    </button>
                    <button className={"weekTab"}>
                        <WeekDateTab menu={menu}/>
                    </button>
                    <button className={"weekTab"}>
                        <WeekDateTab menu={menu}/>
                    </button>

                    <WeeklyMenu key={menu.id} weeklyMenu={menu}/>
                </div>
            }
        </div>
    )
}

export default WeeklyMenuPage;