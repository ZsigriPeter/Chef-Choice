import {useEffect, useState} from "react";
import EditorMain from "../../components/admin/EditorMain";
import styles from "./AdminPage.module.css";
import {useUser} from "../../context/UserProvider.jsx";

function AdminPage() {
    const {user} = useUser();
    const [page, setPage] = useState("");
    const [authorized, setAuthorized] = useState(false);

    useEffect(() => {
        if (user) {
            if (user.roles.some(role => role.role === "ROLE_ADMIN")) {
                setAuthorized(true);
            } else {
                setAuthorized(false);
            }
        }
    }, [user])

    return (
        <div className={styles.adminPage}>
            <h2 className={styles.header}>Admin page</h2>
            {authorized ?
                <div>
                    <ul className={styles.editorMenu}>
                        <li onClick={() => setPage("member-editor")}>Member editor</li>
                        <li onClick={() => setPage("dish-editor")}>Dish editor</li>
                        <li onClick={() => setPage("menu-editor")}>Menu editor</li>
                    </ul>
                    <EditorMain page={page}/>
                </div>
                :
                <h2 style={{color: "red"}}>You are not authorized to view this page.</h2>
            }
        </div>
    )
}

export default AdminPage;