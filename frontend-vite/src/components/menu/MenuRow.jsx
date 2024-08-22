import DishList from "./DishList";

function MenuRow({menuRow}){
    return (
        <div className="menuRow">
            <div className="courseType" data-courseType={menuRow.course}><h4>{menuRow.course}</h4></div>
            <div className="rowCode" data-courseType={menuRow.course}><h4>{menuRow.code}</h4></div>
            <DishList dishes={menuRow.dishes}/>
        </div>
    )
}

export default MenuRow