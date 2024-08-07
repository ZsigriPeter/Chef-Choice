package com.codecool.backend.modell.dto.member;

import com.codecool.backend.modell.entity.member.MemberRole;

import java.util.Set;

public record MemberAdminDTO(Long id, String username, String email, String firstName, String lastName, String phone
        , AddressDTO addressDTO, Set<String> roles) {
}
