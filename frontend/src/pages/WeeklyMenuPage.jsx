import SideMenuBar from "../components/SideMenuBar";
import WeeklyMenu from "../components/menu/WeeklyMenu";
import {useEffect, useState} from "react";
import WeekDateTab from "../components/menu/WeekDateTab";
import {useSearchParams} from "react-router-dom";

const fetchMenuOfTheWeek = (startDate) => {
    return fetch(`/api/public/weekly-menu?date=${startDate}`).then((res) => res.json());
}

function getStartDateOfCurrentWeek() {
    const currentDate = new Date(Date.now());
    const currentDayIndex = currentDate.getUTCDay();
    return new Date(currentDate.setDate(currentDate.getDate() - (currentDayIndex - 1)));
}

function getStartDateStringOfWeek(actualDate) {
    return `${actualDate.getUTCFullYear()}-${(actualDate.getMonth() + 1).toString().padStart(2, '0')}-${actualDate.getUTCDate().toString().padStart(2, '0')}`
}


function WeeklyMenuPage() {
    const [menu, setMenu] = useState(null);
    const [currentWeekStartDate, setCurrentWeekStartDate] = useState(getStartDateStringOfWeek(getStartDateOfCurrentWeek()));
    const [searchParams,] = useSearchParams();

    useEffect(() => {
        const startDate = searchParams.get('date')

        if (startDate) {
            fetchMenuOfTheWeek(startDate).then((menu) => {
                setMenu(menu)
            });
        } else {
            fetchMenuOfTheWeek(getStartDateStringOfWeek(getStartDateOfCurrentWeek())).then((menu) => {
                setMenu(menu)
            });
        }

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