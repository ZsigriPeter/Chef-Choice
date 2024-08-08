function MenuItem({menuItem, onOrder}) {
    return (
        <div className={"menuItemDiv"}>
            <h4 className={"menuItemDishName"}>{menuItem.dish.name}</h4>
            <p className={"menuItemDescription"}> {menuItem.dish.description}</p>
            <h4 className={"menuItemPrice"}>{menuItem.dish.price} €</h4>
            <div className={"menuItemAllergens"}>
                {menuItem.dish.allergens && menuItem.dish.allergens.map(allergen =>
                    <p className={"menuItemAllergen"}>{allergen}</p>)
                }
            </div>
            <input className={"amountInput"} type={"number"} min={0} max={100}
                   onChange={e =>
                   {onOrder(menuItem.dish.id, e.target.value)}
            } />
        </div>
    )
}

export default MenuItem