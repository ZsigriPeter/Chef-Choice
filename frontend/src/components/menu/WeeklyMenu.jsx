import MenuRow from "./MenuRow";

function WeeklyMenu({weeklyMenu}) {

    return (
        <div className="active-menu">
                {weeklyMenu && weeklyMenu.menuRows.map((menuRow) => {
                    return <MenuRow menuRow={menuRow}/>
                })}
        </div>
    )
}

export default WeeklyMenu