package com.codecool.backend.modell.dto.member;

import com.codecool.backend.modell.entity.member.MemberRole;

import java.util.Set;

public record MemberDTO(String username, String email, String firstName, String lastName, String phone
        , AddressDTO addressDTO, Set<MemberRole> roles) {
}
