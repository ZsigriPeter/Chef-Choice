import DishList from "./DishList";

function MenuRow({menuRow}){
    return (
        <div>
            <div><h3>{menuRow.course}</h3></div>
            <div><h3>{menuRow.code}</h3></div>
            <DishList dishes={menuRow.dishes}/>
        </div>
    )
}

export default MenuRow