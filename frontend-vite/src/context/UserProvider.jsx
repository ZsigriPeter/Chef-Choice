import {createContext, useCallback, useContext, useEffect, useState} from "react";

const UserContext = createContext({});

const getToken = () => localStorage.getItem("token");
const setToken = (token) => localStorage.setItem("token", token);

const setCurrentUser = (user) => sessionStorage.setItem("currentUser", user);

const getInitialState = () => {
    const currentUser = sessionStorage.getItem("currentUser");
    return currentUser ? JSON.parse(currentUser) : null
}

const UserProvider = ({children}) => {
    const [user, setUser] = useState(getInitialState);
    const [loading, setLoading] = useState();

    const getMe = useCallback((token) => {
        fetch("/api/user/me", {
            headers: {
                Authorization: `Bearer ${token}`
            }
        })
            .then((res) => res.json())
            .then((user) => {
                setUser(user);
                //console.log(JSON.stringify(user))
            })
            .finally(() => {
                setLoading(false);
            });
    }, []);

    useEffect(() => {
        sessionStorage.setItem("currentUser", JSON.stringify(user))
    }, [user])

    const login = (credentials) => {
        fetch("/api/public/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(credentials)
        })
            .then((res) => res.json())
            .then((res) => {
                const {token} = res;
                if (token) {
                    setToken(token);
                    getMe(token);
                    console.log("User logged in")
                }
            })
    }

    const logout = () => {
        setUser(null);
        setToken("");
        setCurrentUser("");
    }

    return (
        <UserContext.Provider value={{user, login, logout}}>
            {!loading && children}
        </UserContext.Provider>
    );
}

export const useUser = () => useContext(UserContext);

export default UserProvider;