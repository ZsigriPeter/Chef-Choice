package com.codecool.backend.service;

import com.codecool.backend.modell.entity.member.Address;
import com.codecool.backend.modell.entity.member.Member;
import com.codecool.backend.modell.entity.order.Purchase;
import com.codecool.backend.modell.entity.order.PurchaseItem;
import com.codecool.backend.modell.entity.menu.MenuItem;
import com.codecool.backend.modell.payload.NewOrderItemRequest;
import com.codecool.backend.modell.payload.NewOrderRequest;
import com.codecool.backend.repository.AddressRepository;
import com.codecool.backend.repository.MemberRepository;
import com.codecool.backend.repository.OrderItemRepository;
import com.codecool.backend.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private MemberService memberService;

    @Mock
    private MenuService menuService;

    @Mock
    private OrderItemRepository orderItemRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addNewOrder_ShouldSavePurchaseWithCorrectDetails() {
        // Arrange
        NewOrderItemRequest dish=new NewOrderItemRequest(1,1);
        NewOrderItemRequest dish2=new NewOrderItemRequest(2,1);
        NewOrderRequest newOrderRequest = new NewOrderRequest(
                "JohnDoe",
                "Main St 123",
                "Springfield",
                "USA",
                12345,
                List.of(dish, dish2)
        );

        Member member = new Member("JohnDoe",1);
        Address address = new Address("Main St 123", "Springfield", "USA", 12345);
        MenuItem menuItem1 = new MenuItem(1L, "Pizza");
        MenuItem menuItem2 = new MenuItem(2L, "Burger");

        when(memberService.getMemberByUsername("JohnDoe")).thenReturn(member);
        when(menuService.getMenuItemByIdMenuItem(1L)).thenReturn(menuItem1);
        when(menuService.getMenuItemByIdMenuItem(2L)).thenReturn(menuItem2);

        // Act
        orderService.addNewOrder(newOrderRequest);

        // Assert
        verify(addressRepository, times(1)).save(any(Address.class));
        verify(orderItemRepository, times(2)).save(any(PurchaseItem.class));
        verify(orderRepository, times(1)).save(any(Purchase.class));
    }

    @Test
    void addNewOrder_ShouldCallMemberAndMenuServices() {
        // Arrange
        NewOrderItemRequest dish=new NewOrderItemRequest(1,1);
        NewOrderRequest newOrderRequest = new NewOrderRequest(
                "JohnDoe",
                "Main St 123",
                "Springfield",
                "USA",
                12345,
                List.of(dish)
        );

        Member member = new Member("JohnDoe",1);
        MenuItem menuItem = new MenuItem(1L, "Pizza");

        when(memberService.getMemberByUsername("JohnDoe")).thenReturn(member);
        when(menuService.getMenuItemByIdMenuItem(1L)).thenReturn(menuItem);

        // Act
        orderService.addNewOrder(newOrderRequest);

        // Assert
        verify(memberService, times(1)).getMemberByUsername("JohnDoe");
        verify(menuService, times(1)).getMenuItemByIdMenuItem(0);
    }

    @Test
    void getAllOrdersOfMember_ShouldThrowUnsupportedOperationException() {
        // Act & Assert
        assertThrows(UnsupportedOperationException.class, () -> orderService.getAllOrdersOfMember("JohnDoe"));
    }
}
