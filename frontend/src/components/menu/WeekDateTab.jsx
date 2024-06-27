function WeekDateTab({menu}){
    return(
        <div>
            <h2>{menu.week}</h2>
            <p>{menu.startDate}</p>
            <p>{menu.endDate}</p>
        </div>
    )
}
 export default WeekDateTab