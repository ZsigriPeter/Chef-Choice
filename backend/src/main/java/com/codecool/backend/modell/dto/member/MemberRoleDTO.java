package com.codecool.backend.modell.dto.member;

import com.codecool.backend.modell.entity.member.Role;

import java.io.Serializable;

public record MemberRoleDTO(Role role) implements Serializable {
}
