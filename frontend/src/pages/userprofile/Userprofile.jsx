import {useUser} from "../../context/UserProvider";
import styles from "./Userprofile.module.css";

function Userprofile() {
    const {user, getMe} = useUser();
    if (!user) {
        //getMe();
        console.log(user)
    }
    return (
        <>
            {user &&
                <div className={styles.infoDiv}>

                    <h1>
                        {user.username}
                    </h1>
                </div>
            }
        </>
    )
}

export default Userprofile;