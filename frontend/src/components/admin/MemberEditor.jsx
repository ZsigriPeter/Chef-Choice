import {useEffect, useState} from "react";
import MemberTable from "./MemberTable";

const getAllMembers = () => {
    return fetch("api/admin/member", {
        method: "GET",
        headers:
            {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${localStorage.getItem("jwt")}`
            }
    }).then(resp => resp.json())
}

const MemberEditor = () => {
    const [members, setMembers] = useState([])

    useEffect(() => {
        getAllMembers().then(resp => {
            setMembers(resp);
        })
    }, [])

    return <>
        <h3>Member editor</h3>
        <MemberTable members={members}/>
    </>
}

export default MemberEditor;