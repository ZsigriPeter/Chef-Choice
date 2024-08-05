import MenuRow from "./MenuRow";
import MenuItem from "./MenuItem";
import menuItem from "./MenuItem";

function WeeklyMenu({weeklyMenu}) {

    return (
        <div className="active-menu">
            <div className="soup-block">
                <h2 className="course-header" data-course="Soup">Soups</h2>
                <div className="menuItems">
                    <div className="code" data-code="S1"><h2>S1</h2></div>
                    {weeklyMenu && weeklyMenu.menuItems.filter(menuItem => menuItem.course.name === "SOUP" && menuItem.code === "S1").map((menuItem) => {
                        return <MenuItem key={menuItem.id} menuItem={menuItem}/>
                    })}
                </div>
                <div className="menuItems">
                    <div className="code" data-code="S2"><h2>S2</h2></div>
                    {weeklyMenu && weeklyMenu.menuItems.filter(menuItem => menuItem.course.name === "SOUP" && menuItem.code === "S2").map((menuItem) => {
                        return <MenuItem key={menuItem.id} menuItem={menuItem}/>
                    })}
                </div>
            </div>
            <div className="mainDish-block">
                <h2 className="course-header" data-course="Main">Main dishes</h2>
                <div className="menuItems">
                    <div className="code" data-code="M1"><h2>M1</h2></div>
                    {weeklyMenu && weeklyMenu.menuItems.filter(menuItem => menuItem.course.name === "MAIN" && menuItem.code === "M1").map((menuItem) => {
                        return <MenuItem key={menuItem.id} menuItem={menuItem}/>
                    })}
                </div>
                <div className="menuItems">
                    <div className="code" data-code="M2"><h2>M2</h2></div>
                    {weeklyMenu && weeklyMenu.menuItems.filter(menuItem => menuItem.course.name === "MAIN" && menuItem.code === "M2").map((menuItem) => {
                        return <MenuItem key={menuItem.id} menuItem={menuItem}/>
                    })}
                </div>
            </div>
            <div className="dessert-block">
                <h2 className="course-header" data-course="Dessert">Desserts</h2>
                <div className="menuItems">
                    <div className="code" data-code="D1"><h2>D1</h2></div>
                    {weeklyMenu && weeklyMenu.menuItems.filter(menuItem => menuItem.course.name === "DESSERT" && menuItem.code === "D1").map((menuItem) => {
                        return <MenuItem key={menuItem.id} menuItem={menuItem}/>
                    })}
                </div>
                <div className="menuItems">
                    <div className="code" data-code="D2"><h2>D2</h2></div>
                    {weeklyMenu && weeklyMenu.menuItems.filter(menuItem => menuItem.course.name === "DESSERT" && menuItem.code === "D2").map((menuItem) => {
                        return <MenuItem key={menuItem.id} menuItem={menuItem}/>
                    })}
                </div>
            </div>

        </div>
    )
}

export default WeeklyMenu