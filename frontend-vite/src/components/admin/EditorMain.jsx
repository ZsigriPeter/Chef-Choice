import DishEditor from "./Dish/DishEditor.jsx";
import MemberEditor from "./Member/MemberEditor.jsx";
import MenuEditor from "./Menu/MenuEditor.jsx";

const EditorMain = ({page}) => {

    if (page === "member-editor") return <MemberEditor/>;
    else if (page === "dish-editor") return <DishEditor/>;
    else if (page === "menu-editor") return <MenuEditor/>;
    else return <>Please select an option!</>;
}

export default EditorMain;