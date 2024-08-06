import {useState} from "react";

const MemberTable = ({members, onDelete, onAddAdmin, onRemoveAdmin}) => {
    const [idToDelete, setIdToDelete] = useState(null)

    return <div>
        <table>
            <thead>
            <tr>
                <th>ID |</th>
                <th>Username |</th>
                <th>Toggle admin role |</th>
                <th>Update |</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            {
                members.map(member => {
                    return <tr key={member.id}>
                        <td>{member.id}</td>
                        <td>{member.username}</td>
                        <td>
                            {member.roles.includes("ROLE_ADMIN") ?
                                <button type="button" style={{backgroundColor: "red"}}
                                        onClick={() => onRemoveAdmin(member.id)}>Remove ADMIN role
                                </button>
                                :
                                <button type="button" style={{backgroundColor: "lime"}}
                                        onClick={() => onAddAdmin(member.id)}>Add ADMIN role
                                </button>
                            }
                        </td>
                        <td>
                            <button type="button">Update...</button>
                        </td>
                        <td>{idToDelete === member.id ?
                            <>
                                <button type="button" style={{backgroundColor: "red"}}
                                        onClick={() => {
                                            setIdToDelete(null);
                                            onDelete(member.id);
                                        }}>Confirm delete
                                </button>
                                <button type="button" onClick={() => setIdToDelete(null)}>
                                    Cancel
                                </button>
                            </>
                            :
                            <button type="button" onClick={() => setIdToDelete(member.id)}>
                                Delete
                            </button>
                        }
                        </td>
                    </tr>
                })
            }
            </tbody>
        </table>
    </div>
}

export default MemberTable;