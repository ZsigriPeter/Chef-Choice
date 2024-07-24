

function MenuItem({menuItem}){
    return(
        <div>
            <h4>{menuItem.course}</h4>
            <h4>{menuItem.code}</h4>
            <h4>{menuItem.dish}</h4>
            <h4>{menuItem.dayIndex}</h4>
            <h4>{menuItem.startDate}</h4>
        </div>
    )
}
export default MenuItem