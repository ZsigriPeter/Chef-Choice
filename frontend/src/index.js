import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import WeeklyMenuPage from "./pages/WeeklyMenuPage";
import AdminPage from "./pages/AdminPage";
import FoodListPage from "./pages/food-list-page/FoodListPage";
import SignUp from "./pages/SignUp";
import App from "./App";
import UserProvider from "./context/UserProvider";
import NavBar from "./components/NavBar";
import MainPage from "./pages/MainPage";
import {createBrowserRouter} from "react-router-dom";


const router = createBrowserRouter([
    {
        path: "/",
        element: <NavBar/>,
        children: [
            {
                path: "/",
                element: <MainPage/>,
            },
            {
                path: "/main",
                element: <MainPage/>,
            },
            {
                path: "/weekly-menu",
                element: <WeeklyMenuPage/>,
            },
            {
                path: "/food-list",
                element: <FoodListPage/>,
            },
            {
                path: "/sign-up",
                element: <SignUp/>,
            },
            {
                path: "/admin",
                element: <AdminPage/>,
            },
        ],
    },
]);




const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <UserProvider>
            <App/>
        </UserProvider>
    </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
