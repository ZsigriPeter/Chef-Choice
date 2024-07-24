import MenuRow from "./MenuRow";
import MenuItem from "./MenuItem";

function WeeklyMenu({weeklyMenu}) {

    return (
        <div className="active-menu">
                {weeklyMenu && weeklyMenu.menu.map((menuItem) => {
                    return <MenuItem menuItem={menuItem}/>
                })}
        </div>
    )
}

export default WeeklyMenu