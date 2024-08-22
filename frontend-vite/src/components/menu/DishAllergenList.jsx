function DishAllergenList({allergenList}) {
    return (<div>
            {allergenList.map((allergen) => {
                return (
                    <p>{allergen.name}</p>
                )
            })}
        </div>
    )
}

export default DishAllergenList