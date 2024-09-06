import {useState} from "react";

async function addMenuItem(menuItem){
    const token = localStorage.getItem("token");
    await fetch("/api/admin/menu", {
        method: "POST",
        headers: {
            'Authorization': `Bearer ${token}`,
            "Content-Type": "application/json"
        },
        body: JSON.stringify(menuItem)
    })
}

function MenuItemForm() {
    const [dishName, setDishName] = useState("");
    const [dishType, setDishType] = useState("");
    const [dishCode, setDishCode] = useState("");
    const [dayNumber, setDayNumber] = useState("");
    const [startDate, setStartDate] = useState("");

    const handleSubmit = (e)=>{
        e.preventDefault();
        const menuItem = {dishName, dishType, dishCode, dayNumber, startDate}
        addMenuItem(menuItem);
    }

    return (<>
        <form onSubmit={handleSubmit}>
            <div>
                <label>Dish name:<br/>
                    <input
                        value={dishName}
                        onChange={(e) => setDishName(e.target.value)}
                        name="dishName"
                        id="dishName"
                    /><br/>
                </label>
                <label>Dish type:<br/>
                    <input
                        value={dishType}
                        onChange={(e) => setDishType(e.target.value)}
                        name="dishType"
                        id="dishType"
                    /><br/>
                </label>
                <label>Dish code:<br/>
                    <input
                        value={dishCode}
                        onChange={(e) => setDishCode(e.target.value)}
                        name="dishCode"
                        id="dishCode"
                    /><br/>
                </label>
                <label>Day number:<br/>
                    <input
                        value={dayNumber}
                        type={"number"}
                        onChange={(e) => setDayNumber(e.target.value)}
                        name="dayNumber"
                        id="dayNumber"
                    /><br/>
                </label>
                <label>Week start date:<br/>
                    <input
                        value={startDate}
                        type={"date"}
                        onChange={(e) => setStartDate(e.target.value)}
                        name="startDate"
                        id="startDate"
                    /><br/>
                </label>
            </div>
            <button type={"submit"}>Add menu item</button>
        </form>
    </>)
}

export default MenuItemForm