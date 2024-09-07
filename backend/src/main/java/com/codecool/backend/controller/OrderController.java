package com.codecool.backend.controller;

import com.codecool.backend.modell.dto.order.OrderDTO;
import com.codecool.backend.modell.entity.member.Address;
import com.codecool.backend.modell.entity.member.Member;
import com.codecool.backend.modell.entity.order.Purchase;
import com.codecool.backend.modell.entity.order.PurchaseItem;
import com.codecool.backend.modell.payload.NewOrderRequest;
import com.codecool.backend.service.MemberService;
import com.codecool.backend.service.MenuService;
import com.codecool.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class OrderController {

    private final MemberService memberService;
    private final OrderService orderService;


    @Autowired
    public OrderController(MemberService memberService, OrderService orderService) {
        this.memberService = memberService;
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public void addNewPurchase(@RequestBody NewOrderRequest newOrderRequest) {
        orderService.addNewOrder(newOrderRequest);
    }

    @GetMapping("/order/{user-id}")
    public List<OrderDTO> getOrdersOfUser(@RequestParam String username) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
