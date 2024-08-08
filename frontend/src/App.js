import './App.css';
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import NavBar from "./components/NavBar";
import MainPage from "./pages/MainPage";
import WeeklyMenuPage from "./pages/WeeklyMenuPage";
import FoodListPage from "./pages/food-list-page/FoodListPage";
import SignUp from "./pages/SignUp";
import React from "react";
import Userprofile from "./pages/userprofile/Userprofile";
import AdminPage from "./pages/AdminPage";

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
        path:"/user-profile",
        element: <Userprofile/>
      },
      {
        path: "/admin",
        element: <AdminPage/>,
      },
    ],
  },
]);

function App() {
  return (
      <div className={"App"}>
        <RouterProvider router={router}/>
      </div>

  );
}

export default App;
