import {useUser} from "../../context/UserProvider";
import styles from "./Userprofile.module.css";

function Userprofile() {
    const {user} = useUser();
    if (!user) {
        console.log(user)
    }
    return (
        <>
            {user &&
                <div className={styles.user}>
                    <div className={styles.infoDiv}>
                        <p className={styles.usernameP}>Username:</p>
                        {user && console.log(user)}
                        <h2>
                            {user.username}
                        </h2>
                        <p>First name:</p>
                        <h3>{user.firstName}</h3>
                        <p>Last name:</p>
                        <h3>{user.lastName}</h3>
                        <p>Email:</p>
                        <h3>{user.email}</h3>
                        <p>Phone:</p>
                        <h3>{user.phone}</h3>
                    </div>
                    <div className={styles.address}>
                        <h2 className={styles.addressH2}>Address</h2>
                        <p>Street and house number:</p>
                        <h3>{user.addressDTO.streetAndHouseNumber}</h3>
                        <p>City:</p>
                        <h3>{user.addressDTO.settlement}</h3>
                        <p>Country:</p>
                        <h3>{user.addressDTO.country}</h3>
                        <p>ZIP:</p>
                        <h3>{user.addressDTO.ZIP}</h3>
                    </div>
                    <div className={styles.buttonsDiv}>
                        <button>Orders</button>
                        <button>Favorites</button>
                    </div>
                </div>
            }

        </>
    )
}

export default Userprofile;