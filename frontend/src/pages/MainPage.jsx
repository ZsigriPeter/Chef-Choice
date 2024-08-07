import {useEffect, useState} from "react";

const fetchMainPage = () => {
    return fetch("/api/public/main-page").then((res) => res.json());
};

function MainPage() {

    const [data, setData] = useState(null);

    useEffect(() => {
        fetchMainPage()
            .then((result) => {
                setData(result);
            })
    }, []);

    return (
        <div className="mainPage">
            {
                data ? (
                    <h2 className="mainPageMessage">
                        {data.message}
                    </h2>
                ) : (
                    <h2 className="mainPageMessage">
                        Welcome to ... !
                    </h2>
                )
            }
        </div>
    );
}

export default MainPage;