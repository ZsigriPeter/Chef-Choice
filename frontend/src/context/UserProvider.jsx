import {createContext, useCallback, useContext, useState} from "react";

const UserContext = createContext({});

const getToken = () => localStorage.getItem("token");
const setToken = (token) => localStorage.setItem("token", token);

const UserProvider = ({children}) => {
    const [user, setUser] = useState();
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
            })
            .finally(() => {
                setLoading(false);
            });
    }, []);

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
    }

    return (
        <UserContext.Provider value={{user, login, logout}}>
            {!loading && children}
        </UserContext.Provider>
    );
}

export const useUser = () => useContext(UserContext);

export default UserProvider;