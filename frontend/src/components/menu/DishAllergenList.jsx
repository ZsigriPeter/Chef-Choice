function DishAllergenList({allergenList}) {
    return (<div>
            {allergenList.map((allergen) => {
                <p>{allergen.name}</p>
            })}
        </div>
    )
}
export default DishAllergenList