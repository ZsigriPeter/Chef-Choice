package com.codecool.backend.modell.dto.member;

import java.util.Set;

public record MemberToAdminPageDTO(Long id, String username, String email, String firstName, String lastName, String phone
        , AddressDTO addressDTO, Set<String> roles) {
}
