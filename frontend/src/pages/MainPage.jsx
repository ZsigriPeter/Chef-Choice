import {useEffect, useState} from "react";

const fetchMainPage = () => {
    return fetch("/main-page").then((res) => res.json());
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
        <div className="content">
            {
                data ? (
                    <>
                        <h2 className="mainPageMessage">
                            {data.message}
                        </h2>
                        <img src={data.pictureUrl} alt="Main Page"/>
                    </>
                ) : (
                    <>
                        <h2>
                            Welcome to ... !
                        </h2>
                        <img src="" alt="Main Page"/>
                    </>
                )
            }
        </div>
    );
}

export default MainPage;