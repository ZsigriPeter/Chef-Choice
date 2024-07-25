import MenuRow from "./MenuRow";
import MenuItem from "./MenuItem";
import menuItem from "./MenuItem";

function WeeklyMenu({weeklyMenu}) {

    return (
        <div className="active-menu">
            {weeklyMenu && weeklyMenu.menuItems.filter(menuItem => menuItem.course.name === "SOUP").map((menuItem) => {
                return <MenuItem key={menuItem.id} menuItem={menuItem}/>
            })}
        </div>
    )
}

export default WeeklyMenu