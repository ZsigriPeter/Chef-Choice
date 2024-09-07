package com.codecool.backend.modell.dto.order;

import com.codecool.backend.modell.dto.food.MenuItemDTO;
import com.codecool.backend.modell.dto.member.AddressDTO;
import com.codecool.backend.modell.dto.member.MemberDTO;

import java.util.Map;

public record OrderDTO(AddressDTO addressDTO, MemberDTO memberDTO, Map<MenuItemDTO, Integer> orderMap) {
}
