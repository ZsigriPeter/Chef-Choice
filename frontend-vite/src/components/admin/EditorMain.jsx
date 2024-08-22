import DishEditor from "./DishEditor";
import MemberEditor from "./MemberEditor";

const EditorMain = ({page}) => {

    if (page === "member-editor") return <MemberEditor/>;
    else if (page === "dish-editor") return <DishEditor/>;
    else return <>Please select an option!</>;
}

export default EditorMain;