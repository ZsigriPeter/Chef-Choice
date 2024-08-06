package com.codecool.backend.modell.entity.member;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class MemberRole {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private Role role;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Set<Member> members;

    public MemberRole(Role role) {
        this.role = role;
        this.members = new HashSet<>();
    }

    public MemberRole() {

    }
}
