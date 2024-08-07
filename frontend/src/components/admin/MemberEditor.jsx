import {useEffect, useState} from "react";
import MemberTable from "./MemberTable";
import MemberForm from "./MemberForm";

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

const deleteMember = (id) => {
    return fetch(`api/admin/member/${id}`,
        {
            method: "DELETE",
            headers:
                {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${localStorage.getItem("jwt")}`
                }
        }
    ).then(status => status.statusText)
}

const addAdmin = (id) => {
    return fetch(`api/admin/member/add-admin/${id}`,
        {
            method:
                "PATCH",
            headers:
                {
                    'Content-Type':
                        'application/json',
                    'Authorization':
                        `Bearer ${localStorage.getItem("jwt")}`
                }
        }
    ).then(resp => resp.statusText)
}

const removeAdmin = (id) => {
    return fetch(`api/admin/member/remove-admin/${id}`,
        {
            method:
                "PATCH",
            headers:
                {
                    'Content-Type':
                        'application/json',
                    'Authorization':
                        `Bearer ${localStorage.getItem("jwt")}`
                }
        }
    ).then(resp => resp.statusText)
}

const updateMember = (member) => {
    return fetch(`api/admin/member/${member.id}`,
        {
            method:
                "PATCH",
            headers:
                {
                    'Content-Type':
                        'application/json',
                    'Authorization':
                        `Bearer ${localStorage.getItem("jwt")}`
                },
            body: JSON.stringify(member)
        }
    ).then(res => res.statusText)
}

const MemberEditor = () => {
    const [members, setMembers] = useState([]);
    const [idToUpdate, setIdToUpdate] = useState(null);
    const [loading, setLoading] = useState(true)

    useEffect(() => {
        getAllMembers().then(resp => {
            setMembers(resp);
            console.log(resp);
            setLoading(false);
        })
    }, [])

    const handleDelete = (id) => {
        deleteMember(id).then((statusText) => {
            if (statusText === "OK") setMembers(members.filter(member => member.id !== id))
            else alert(statusText);
        });
    }

    const handleAddAdmin = (id) => {
        addAdmin(id).then((statusText) => {
            if (statusText === "OK") {
                const member = members.find(member => member.id === id);
                member.roles.push("ROLE_ADMIN");
                const membersCopy = [...members];
                setMembers(membersCopy);
            } else alert(statusText);
        })
    }

    const handleRemoveAdmin = (id) => {
        removeAdmin(id).then((statusText) => {
            if (statusText === "OK") {
                const member = members.find(member => member.id === id);
                member.roles.splice(member.roles.indexOf("ROLE_ADMIN"), 1);
                const membersCopy = [...members];
                setMembers(membersCopy);
            } else alert(statusText);
        })
    }

    const handleClickUpdate = (id) => {
        setIdToUpdate(id)
    }

    const handleCancelUpdate = () => {
        setIdToUpdate(null);
    }

    const handleSaveUpdate = (member) => {
        setLoading(true);
        updateMember(member).then(statusText => {
            setLoading(false);
            if (statusText==="OK") alert(`Member (ID=${member.id}) has been updated.`)
            else alert(statusText)
            setIdToUpdate(null);
        })
    }

    if (loading === true) return <p>Loading...</p>

    else if (idToUpdate === null) return <>
        <h3>Member editor</h3>
        <MemberTable members={members}
                     onDelete={handleDelete}
                     onAddAdmin={handleAddAdmin}
                     onRemoveAdmin={handleRemoveAdmin}
                     onUpdate={handleClickUpdate}
        />
    </>

    else return <>
            <MemberForm
                member={members.find(member => member.id === idToUpdate)}
                onSave={handleSaveUpdate}
                onCancel={handleCancelUpdate}
            />
        </>
}

export default MemberEditor;