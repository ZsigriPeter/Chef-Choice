package com.codecool.backend.service;

import com.codecool.backend.modell.dto.order.OrderDTO;
import com.codecool.backend.modell.entity.member.Address;
import com.codecool.backend.modell.entity.member.Member;
import com.codecool.backend.modell.entity.order.Purchase;
import com.codecool.backend.modell.entity.order.PurchaseItem;
import com.codecool.backend.modell.payload.NewOrderRequest;
import com.codecool.backend.repository.*;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final AddressRepository addressRepository;
    private final OrderRepository orderRepository;
    private final RestTemplateAutoConfiguration restTemplateAutoConfiguration;
    private MemberRepository memberRepository;
    private MemberService memberService;
    private MenuService menuService;
    private OrderItemRepository orderItemRepository;

    public OrderService(MemberRepository memberRepository, OrderRepository orderRepository,
                        AddressRepository addressRepository, MemberService memberService,
                        OrderItemRepository orderItemRepository,MenuService menuService, RestTemplateAutoConfiguration restTemplateAutoConfiguration) {
        this.addressRepository = addressRepository;
        this.orderRepository = orderRepository;
        this.memberRepository = memberRepository;
        this.memberService = memberService;
        this.menuService = menuService;
        this.restTemplateAutoConfiguration = restTemplateAutoConfiguration;
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderDTO> getAllOrdersOfMember(String memberUsername) {
        //TODO
        throw new UnsupportedOperationException();
    }

    public void addNewOrder(NewOrderRequest newOrderRequest) {
        Address address = new Address(
                newOrderRequest.getStreetAndHouseNumber(),
                newOrderRequest.getSettlement(),
                newOrderRequest.getCountry(),
                newOrderRequest.getZipCode()
        );
        Member member = memberService.getMemberByUsername(newOrderRequest.getUsername());
        List<PurchaseItem> purchaseItems = newOrderRequest.getDishList().stream().map(
                item-> {PurchaseItem purchaseItem= new PurchaseItem(item.getQuantity(), menuService.getMenuItemByIdMenuItem(item.getMenuItemId()));
                    orderItemRepository.save(purchaseItem);
                return purchaseItem;}
        ).collect(Collectors.toList());
        Purchase purchase = new Purchase(
                member,
                address,
                purchaseItems
        );
        addressRepository.save(purchase.getAddress());
        orderRepository.save(purchase);
    }
}
