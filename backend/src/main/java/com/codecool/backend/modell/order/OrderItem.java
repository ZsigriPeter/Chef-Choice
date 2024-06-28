package com.codecool.backend.modell.order;

import com.codecool.backend.modell.dish.Dish;

public class OrderItem {
    private int orderId;
    private int week;
    private int dayOfWeek;
    private String menuCode;
    private Dish dish;
    private double price;
    private int quantity;
    private double orderItemTotal;

    public OrderItem(int orderId, int week, int dayOfWeek, String menuCode, Dish dish, double price, int quantity, double orderItemTotal) {
        this.orderId = orderId;
        this.week = week;
        this.dayOfWeek = dayOfWeek;
        this.menuCode = menuCode;
        this.dish = dish;
        this.price = price;
        this.quantity = quantity;
        this.orderItemTotal = orderItemTotal;
    }
}
