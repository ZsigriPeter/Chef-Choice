package com.codecool.backend.modell.dto.member;

import java.util.List;

public record MemberAdminDTO(Long id, String username, List<String> roles) {
}
