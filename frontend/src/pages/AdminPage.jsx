import {useState} from "react";
import EditorMain from "../components/admin/EditorMain";


function AdminPage() {
    const [page, setPage] = useState("")

    return (
        <div style={{color: "white"}}>
            <h2>Admin page</h2>
            <ul>
                <li onClick={() => setPage("member-editor")}>Member editor</li>
                <li onClick={() => setPage("dish-editor")}>Dish editor</li>
                <li onClick={() => setPage("menu-editor")}>Menu editor</li>
            </ul>
            <EditorMain
                page={page}
            />
        </div>
    )
}

export default AdminPage;