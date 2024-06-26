import React from 'react';
import ReactDOM from 'react-dom/client';
import {createBrowserRouter, RouterProvider} from "react-router-dom";

import NavBar from './components/NavBar';
import './index.css';
import MainPage from './pages/MainPage';
import reportWebVitals from './reportWebVitals';
import WeeklyMenuPage from "./pages/WeeklyMenuPage";

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
        ],
    },
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <RouterProvider router={router}/>
    </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
