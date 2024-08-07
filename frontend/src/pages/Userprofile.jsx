import {useUser} from "../context/UserProvider";

function Userprofile(){
    const {user, getMe} = useUser();
    console.log(user)
    return(
        <>
        </>
    )
}
export default Userprofile;