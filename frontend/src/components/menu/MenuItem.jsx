

function MenuItem({menuItem}){
    return(
        <div>
            <h4>{menuItem.dish.name}</h4>
            <h4>{menuItem.dish.description}</h4>
            <h4>{menuItem.dish.price}</h4>
            <h4>{menuItem.dish.allergens}</h4>
        </div>
    )
}
export default MenuItem