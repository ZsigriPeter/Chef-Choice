function AdminNavBar() {

    return <>
        <div className="nav-bar">
            <nav>
                <ul className="nav-links">
                    <li><a href="/admin/dish">Edit dishes</a></li>
                    <li><a href="/admin/menu">Edit weekly menu</a></li>
                    <li><a href="/admin/orders">Edit orders</a></li>
                    <li><a href="/admin/user">Edit users</a></li>
                </ul>
            </nav>
        </div>
    </>
}

export default AdminNavBar;