import MenuRow from "./MenuRow";

function WeeklyMenu({menu}) {

    return (
        <div>{menu && menu.map((menuRow) => {
            return (
                <MenuRow menuRow={menuRow}/>
            )
        })}
        </div>
    )
}

export default WeeklyMenu