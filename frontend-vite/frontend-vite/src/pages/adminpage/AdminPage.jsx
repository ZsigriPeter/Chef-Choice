import {useEffect, useState} from "react";
import EditorMain from "../../components/admin/EditorMain";
import styles from "./AdminPage.module.css";

const fetchUserContext = (token) => {
    return fetch("api/public/context",
        {
            method: "GET",
            headers:
                {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${localStorage.getItem("token")}`
                }
        }
    ).then(res => res.json());
}

function AdminPage() {
    const [page, setPage] = useState("");
    const [authorized, setAuthorized] = useState(false);

    useEffect(() => {
        fetchUserContext().then(resp => {
            const roles = resp.authorities.map(authority => authority.authority);
            if (roles.includes("ROLE_ADMIN")) setAuthorized(true);
            else setAuthorized(false);
        })
    }, [])

    console.log(localStorage.getItem("token"))

    return (
        <div className={styles.adminPage}>
            <h2 className={styles.header}>Admin page</h2>
            { authorized ?
                <div >
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