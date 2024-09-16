import DishForm from "./DishForm.jsx";
import NewAllergenForm from "../NewAllergenForm.jsx";
import styles from "./DishEditor.module.css";

function DishEditor() {
    return <>
        <div className={styles.dishEditor}>
            <DishForm/>
            <NewAllergenForm/>
        </div>
    </>
}

export default DishEditor;