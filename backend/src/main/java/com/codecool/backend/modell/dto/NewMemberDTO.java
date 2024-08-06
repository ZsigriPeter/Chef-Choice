package com.codecool.backend.modell.dto;

import com.codecool.backend.modell.entity.member.MemberRole;

import java.util.Set;

public record NewMemberDTO(String username, String email, String firstName, String lastName, String phone
        , String streetAndHouseNumber, String settlement, String country, int ZIP, Set<MemberRole> roles) {
}
