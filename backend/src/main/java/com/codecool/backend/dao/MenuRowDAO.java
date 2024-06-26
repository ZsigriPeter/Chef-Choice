package com.codecool.backend.dao;

import com.codecool.backend.modell.menu.MenuRow;

public interface MenuRowDAO {
    MenuRow getMenuRowByCode(String code);
}
