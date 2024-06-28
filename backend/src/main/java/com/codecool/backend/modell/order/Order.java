package com.codecool.backend.modell.order;

import com.codecool.backend.modell.user.Address;
import com.codecool.backend.modell.user.User;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int lastId = 0;
    private int id;
    private User user;
    private Address deliveryAddress;
    private Address invoiceAddress;
    private List<OrderItem> items;
    private double orderTotal;

    public Order(int id, User user, Address deliveryAddress, Address invoiceAddress, double orderTotal) {
        this.invoiceAddress = invoiceAddress;
        this.id = id;
        this.user = user;
        this.deliveryAddress = deliveryAddress;
        this.items = new ArrayList<>();
        this.orderTotal = orderTotal;
    }
}
